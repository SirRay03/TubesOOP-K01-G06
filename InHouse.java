import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InHouse{
    JFrame frame;
    JPanel room;
    JPanel menu;
    JPanel info;
    JPanel interact;

    public InHouse(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLayout(new BorderLayout(10, 5)); // 10 = horizontal gap, 5 = vertical gap
        frame.setVisible(true);

        room = new JPanel();
        menu = new JPanel();
        info = new JPanel();
        interact = new JPanel();

        room.setPreferredSize(new Dimension(400, 400));
        menu.setPreferredSize(new Dimension(400, 200));
        info.setPreferredSize(new Dimension(200, 400));
        interact.setPreferredSize(new Dimension(200, 200));
    }   
}