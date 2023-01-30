import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        //frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setLayout(null);
        //frame.setUndecorated(true);

        

        JTextField textField, textField1;
        textField = new JTextField();
        textField.setColumns(23);
        textField.setText("google.com");
        textField.setBounds(10, 10, 150, 20);
        textField.setEnabled(false);

        textField1 = new JTextField();
        textField1.setText("amazon.com");
        textField1.setBounds(10, 35, 150, 20);

        JLabel label = new JLabel();
        label.setBounds(10, 100, 250, 20);

        JButton button = new JButton("Button");
        //button.setBackground(Color.CYAN);
        button.setBounds(10, 70, 150, 30);
        frame.add(button);
        frame.add(textField);
        frame.add(textField1);
        frame.add(label);

        String host = textField.getText();

        String ip = java.net.InetAddress.getByName(host).getHostAddress();
        label.setText("IP of " + host + " is: " + ip);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        //frame.getContentPane().add(button); // Adds Button to content pane of frame
/*        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);*/

/*        JToggleButton tb = new JToggleButton("push me");
        tb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton btn =  (JToggleButton) e.getSource();
                btn.setText(btn.isSelected() ? "pushed" : "push me");
            }
        });

        frame.getContentPane().add(tb);*/


        button.addActionListener(new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Button")) {

                    System.out.println("Add button pressed");

                    JOptionPane.showMessageDialog(null,
                            "Hi, In the message box",
                            "PopUp Dialog",
                            JOptionPane.WARNING_MESSAGE);
                    counter++;
                }
                if (counter == 1) {
                    frame.setBounds(100, 100, 300, 300);
                }

                if (counter == 2) {
                    System.exit(0); // stop program
                    frame.dispose(); // close window
                    frame.setVisible(false); // hide window
                }
            }
        });

        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }
}
