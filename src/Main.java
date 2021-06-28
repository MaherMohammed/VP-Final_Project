import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

public class Main {
    static JFrame frame;
    static JPanel blocksInCenter;

    static ArrayList<Condition> panels;

    public static void main(String[] args) {
        panels = new ArrayList<>();

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        // width will store the width of the screen
        int width = (int)size.getWidth();

        // height will store the height of the screen
        int height = (int)size.getHeight();

        frame = new JFrame("Visual Programming For Expert System");
        frame.setSize(width, height);

        //build the panel for the blocks on the west of the screen
        JPanel blocksPanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(blocksPanel, BoxLayout.Y_AXIS);
        // to set the box layout
        blocksPanel.setLayout(boxlayout);



        JButton button = new JButton();
        button.setText("Add IF Block");

        blocksInCenter = new JPanel();
        BoxLayout boxInCenter = new BoxLayout(blocksInCenter, BoxLayout.Y_AXIS);
        blocksInCenter.setLayout(boxInCenter);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Condition c = createIfStatement();
                JPanel d = c.view;
                blocksInCenter.add(d);
                frame.revalidate();
                frame.repaint();
                panels.add(c);
            }
        });

        blocksPanel.add(button);
        frame.add(blocksPanel,BorderLayout.WEST);

        //building the chatbot on the east
        JPanel chatBot = new JPanel();
//        BoxLayout chatBotboxlayout = new BoxLayout(chatBot, BoxLayout.Y_AXIS);
        chatBot.setLayout(new BorderLayout());

        //build text field and a button to enter
        JPanel writingArea = new JPanel();
        writingArea.setLayout(new BorderLayout());
        JTextField userWords = new JTextField(20);
        userWords.setBorder(new LineBorder(Color.black,3));
        //button for enter
        JButton enterButton = new JButton("Enter");
        writingArea.add(userWords,BorderLayout.WEST);
        writingArea.add(enterButton,BorderLayout.EAST);

        JPanel chatArea = new JPanel();
        BoxLayout chatAreaLayout = new BoxLayout(chatArea, BoxLayout.Y_AXIS);
        chatArea.setLayout(chatAreaLayout);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = userWords.getText();
                boolean answered = false;
                for(Condition c : panels) {
                    if(c.question.getText().equals(question)) {
                        answered = true;
//                        System.out.println(c.answer.getText());
                        JPanel questionPanel = new JPanel();
                        JPanel resPanel = new JPanel();
                        questionPanel.setLayout(new BorderLayout());
                        resPanel.setLayout(new BorderLayout());

                        JLabel questionLabel = new JLabel(question);
                        questionPanel.add(questionLabel,BorderLayout.EAST);
                        JLabel resLabel = new JLabel(c.answer.getText());
                        resPanel.add(resLabel, BorderLayout.WEST);
                        chatArea.add(questionPanel);
                        chatArea.add(resPanel);
                        frame.revalidate();
                        frame.repaint();
                        userWords.setText("");
                        break;
                        //chat answer
                    }

                }
                if(!answered) {
                    //handle unknown questions
                    JPanel questionPanel = new JPanel();
                    JPanel resPanel = new JPanel();
                    questionPanel.setLayout(new BorderLayout());
                    resPanel.setLayout(new BorderLayout());

                    JLabel questionLabel = new JLabel(question);
                    questionPanel.add(questionLabel,BorderLayout.EAST);
                    JLabel resLabel = new JLabel("I don't know. Can you please enter a valid question?");
                    resPanel.add(resLabel, BorderLayout.WEST);
                    chatArea.add(questionPanel);
                    chatArea.add(resPanel);
                    frame.revalidate();
                    frame.repaint();
                    userWords.setText("");

                }
            }
        });
        chatBot.add(chatArea,BorderLayout.NORTH);
        chatBot.add(writingArea,BorderLayout.SOUTH);


        JScrollPane pane = new JScrollPane();
        pane.setViewportView (blocksInCenter);


        frame.add(chatBot,BorderLayout.EAST);



        frame.add(pane,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

//    public static


    public static Condition createIfStatement() {
        JPanel p = new JPanel();
        BoxLayout boxLayout = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(boxLayout);
        //if statement
        JPanel ifStatement = new JPanel();
        ifStatement.setLayout(new FlowLayout());
        JLabel ifLabel = new JLabel("IF");
        ifLabel.setOpaque(true);
        ifLabel.setBackground(Color.white);
        ifLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

        // set the border of this component
        ifLabel.setBorder(border);

        //question text field
        JTextField question = new JTextField(15);

        ifStatement.add(ifLabel);
        ifStatement.add(question);

        p.add(ifStatement);

        // response field
        JPanel resStatement = new JPanel();
        resStatement.setLayout(new FlowLayout());
        JLabel resLabel = new JLabel("RESPONSE");
        resLabel.setOpaque(true);
        resLabel.setBackground(Color.red);
        resLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        JTextField res = new JTextField(15);
        resStatement.add(resLabel);
        resStatement.add(res);

        p.add(resStatement);
        Condition c = new Condition(question, res, p);
        return c;
    }

    static class Condition {
        JTextField question, answer;
        JPanel view;
        public Condition(JTextField q, JTextField res, JPanel jp) {
            question = q;
            answer = res;
            view = jp;
        }
        public JPanel createView(String q, String ans) {
            return new JPanel();
        }

    }
}
