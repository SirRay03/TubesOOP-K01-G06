import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener{

    JFrame frame = new JFrame();
    JButton newGame;
    JButton exitGame;
    JPanel title;
    JPanel buttons;
    JLabel titleText;
    JLabel titleImage;
    ImageIcon titleImageIcon;

    MainMenu(){
        frame.setTitle("SimPlicity 5 - Main Menu");
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JPanel();
        title.setBounds(0, 0, 500, 100);
        title.setBackground(Color.black);

        titleText = new JLabel("SimPlicity 5");
        titleText.setForeground(Color.white);
        titleText.setFont(new Font("Serif", Font.BOLD, 50));
        title.add(titleText);

        titleImageIcon = new ImageIcon("simplicity5.png");
        titleImage = new JLabel(titleImageIcon);
        titleImage.setBounds(0, 0, 500, 100);
        title.add(titleImage);

        buttons = new JPanel();
        buttons.setBounds(0, 100, 500, 400);

        newGame = new JButton("New Game");
        newGame.setBounds(0, 0, 500, 200);
        newGame.addActionListener(this);
        buttons.add(newGame);

        exitGame = new JButton("Exit Game");
        exitGame.setBounds(0, 200, 500, 200);
        exitGame.addActionListener(this);
        buttons.add(exitGame);

        frame.add(title);
        frame.add(buttons);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
            frame.dispose();
            new NewGame();
        }
        else if (e.getSource() == exitGame) {
            System.exit(0);
        }
	}
}