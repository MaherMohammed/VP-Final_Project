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

    static ArrayList<JPanel> panels;

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
                JPanel d = createIfStatement();
                blocksInCenter.add(d);
                frame.revalidate();
                frame.repaint();
                panels.add(d);
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

        chatBot.add(writingArea,BorderLayout.SOUTH);
        frame.add(chatBot,BorderLayout.EAST);



        frame.add(blocksInCenter,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

//    public static


    public static JPanel createIfStatement() {
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

        return p;
    }

    class Condition {
        String question, answer;
        JPanel view;
        public Condition(String q, String ans) {
            question = q;
            answer = ans;
            view = createView(q, ans);
        }
        public JPanel createView(String q, String ans) {
            return new JPanel();
        }

    }
}
