package gui;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JFrame frame;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    
    MyFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
    }
}
