import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        //frame.setBounds(100, 100, 450, 300);
        //frame.getContentPane().setBackground(Color.GREEN);
        frame.setLayout(null);
        //frame.setUndecorated(true);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        JTextField textField1, textField2, textField3;
        textField1 = new JTextField();
        textField1.setColumns(23);
        textField1.setText("google.com");
        textField1.setBounds(10, 10, 150, 20);
        textField1.setEnabled(false);

        textField2 = new JTextField();
        textField2.setText("amazon.com");
        textField2.setBounds(10, 35, 150, 20);

        textField3 = new JTextField();
        textField3.setColumns(23);
        textField3.setText("directory");
        textField3.setBounds(40, 130, 150, 20);
        textField3.setEnabled(false);

        JLabel label, label1;
        label = new JLabel();
        label.setBounds(10, 100, 250, 20);

        JButton button1, button2;
        button1 = new JButton("Button");
        //button.setBackground(Color.CYAN);
        button1.setBounds(10, 70, 100, 20);
        button1.setFocusable(false);
        button1.setToolTipText("This is the text");
        button1.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        button2 = new JButton("Choose directory");
        button2.setBounds(270, 130, 100, 20);
        button2.setFocusable(false);
        button2.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        JCheckBox checkbox1 = new JCheckBox();
        checkbox1.setBounds(10,130, 20,20);
        checkbox1.setBorderPaintedFlat(false);

        frame.add(button1);
        frame.add(button2);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(label);
        frame.add(checkbox1);

        String host = textField1.getText();

        String ip = java.net.InetAddress.getByName(host).getHostAddress();
        label.setText("IP of " + host + " is: " + ip);

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


        button1.addActionListener(new ActionListener() {
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

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Choose directory")) {

                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("choosertitle");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    chooser.setAcceptAllFileFilterUsed(false);

                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                        System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                        textField3.setText(String.valueOf(chooser.getSelectedFile()));
                        textField3.setEnabled(true);
                    } else {
                        System.out.println("Nothing was Selected");
                    }
                }
            }
        });

        checkbox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1){
                    textField3.setEnabled(true);
                }else {
                    textField3.setEnabled(false);
                }
            }
        });


        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }
}
