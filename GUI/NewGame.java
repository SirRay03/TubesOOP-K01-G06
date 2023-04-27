import javax.swing.*;
import java.awt.event.*;

public class NewGame implements ActionListener{

    JButton createNewSim;
    JButton loadSim;
    JButton back;
    JLabel title;
    JLabel description;
    JPanel panel;
    JFrame frame;

    public NewGame(){
        frame = new JFrame("New Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("New Game");
        title.setBounds(350, 50, 100, 25);
        panel.add(title);

        description = new JLabel("Create a new simulation or load a previous one.");
        description.setBounds(250, 100, 300, 25);
        panel.add(description);

        createNewSim = new JButton("Create New Simulation");
        createNewSim.setBounds(300, 200, 200, 25);
        createNewSim.addActionListener(this);
        panel.add(createNewSim);

        loadSim = new JButton("Load Simulation");
        loadSim.setBounds(300, 250, 200, 25);
        loadSim.addActionListener(this);
        panel.add(loadSim);

        back = new JButton("Back");
        back.setBounds(300, 300, 200, 25);
        back.addActionListener(this);
        panel.add(back);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createNewSim){
            frame.dispose();
            System.out.println("Create New Simulation");
        }
        else if(e.getSource() == loadSim){
            frame.dispose();
            System.out.println("Load Simulation");
        }
        else if(e.getSource() == back){
            frame.dispose();
            new MainMenu();
        }
    }
}