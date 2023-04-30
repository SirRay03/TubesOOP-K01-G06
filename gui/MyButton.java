package gui;
import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton{
    MyButton(String name){
        this.setText(name);
        this.setPreferredSize(new Dimension(300, 100));
        this.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.setFocusPainted(false);
        this.setBackground(Color.white);
    }
}
