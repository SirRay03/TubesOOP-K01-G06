import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu{

    JFrame frame;

    Menu(){
        frame = new JFrame("SimPlicity 5 - Menu");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        frame.setVisible(true);
    }
}