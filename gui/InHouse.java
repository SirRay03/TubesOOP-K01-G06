package gui;
import javax.swing.*;
import java.awt.*;

public class InHouse{
    JFrame frame;
    JPanel info;
    JPanel room;
    JPanel menu;
    JPanel interact;

    public InHouse(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLayout(new BorderLayout(10, 5)); // 10 = horizontal gap, 5 = vertical gap
        frame.setVisible(true);

        info = new JPanel();
        room = new JPanel();
        menu = new JPanel();
        interact = new JPanel();

        info.setPreferredSize(new Dimension(200, 400));
        room.setPreferredSize(new Dimension(400, 400));
        menu.setPreferredSize(new Dimension(400, 200));
        interact.setPreferredSize(new Dimension(200, 200));
    }   
}