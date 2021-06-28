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
        JPanel chatArea = new JPanel();
        BoxLayout charAreaLayout = new BoxLayout(chatArea,BoxLayout.Y_AXIS);
        chatArea.setLayout(charAreaLayout);



        chatBot.add(chatArea, BorderLayout.NORTH);


        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
