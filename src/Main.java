import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        // width will store the width of the screen
        int width = (int)size.getWidth();

        // height will store the height of the screen
        int height = (int)size.getHeight();

        JFrame frame = new JFrame("Visual Programming For Expert System");
        frame.setSize(width, height);

        //build the panel for the blocks on the west of the screen
        JPanel blocksPanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(blocksPanel, BoxLayout.Y_AXIS);
        // to set the box layout
        blocksPanel.setLayout(boxlayout);

        JLabel label = new JLabel("testing label in west");
//        label.setIcon(new ImageIcon("Images/me.jpg"));
        JButton button = new JButton();
        button.setText("Button in west");
        blocksPanel.add(button);
        blocksPanel.add(label);
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

        //build the area that contains the chat
//        JPanel chatArea = new JPanel();
//        BoxLayout charAreaLayout = new BoxLayout(chatArea,BoxLayout.Y_AXIS);
//        chatArea.setLayout(charAreaLayout);
//        JTextArea chatArea = new JTextArea();
//        chatArea.se
//        JLabel l = new JLabel("hello world");
//        frame.add(l,BorderLayout.CENTER);

//        chatBot.add(chatArea, BorderLayout.NORTH);

        JPanel h = new JPanel();
        h.setLayout(new BorderLayout());
        h.add(createIfStatement(),BorderLayout.NORTH);
        frame.add(h,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static JPanel createIfStatement(){
        JPanel p = new JPanel();
        BoxLayout boxLayout = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(boxLayout);
        //if statement
        JPanel ifStatement = new JPanel();
        ifStatement.setLayout(new FlowLayout());
        JLabel ifLabel = new JLabel("IF");
        ifLabel.setOpaque(true);
        ifLabel.setBackground(Color.BLUE);
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
        JTextField res = new JTextField(15);
        resStatement.add(resLabel);
        resStatement.add(res);

        p.add(resStatement);

        return p;
    }
}
