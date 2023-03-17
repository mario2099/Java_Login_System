import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel("THIS IS A TEST");
    HashMap<String,String> logininfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        messageLabel.setVisible(false);

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setVisible(false);
        }

        if(e.getSource()==loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            messageLabel.setVisible(true);

            if (logininfo.containsKey(userID)) {
                if(logininfo.get(userID).equals(password)){
                    //String user = logininfo.get(userID);
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    WelcomePage welcomePage = new WelcomePage(userID);

                }else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
    }
}
