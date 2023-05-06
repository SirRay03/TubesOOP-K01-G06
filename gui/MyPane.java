package gui;

import javax.swing.JOptionPane;

public class MyPane extends JOptionPane {
    public MyPane(String message, String title){
        MyPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
