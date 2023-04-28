package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.*;

public class NewGame implements ActionListener{
    JFrame frame;
    JPanel title;
    JLabel titleText;
    JTextField firstName;
    JTextField lastName;
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JButton submit;
    JButton back;

    NewGame(){
        frame = new JFrame();
        frame.setTitle("SimPlicity 5 - New Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);

        title = new JPanel();
        title.setBounds(0, 0, 800, 100);
        title.setBackground(Color.black);

        titleText = new JLabel("New Game");
        titleText.setForeground(Color.white);
        titleText.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        title.add(titleText);

        firstName = new JTextField();
        firstName.setBounds(300, 200, 200, 50);
        firstName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        firstName.setHorizontalAlignment(JTextField.CENTER);
        firstName.setBorder(BorderFactory.createBevelBorder(1));

        lastName = new JTextField();
        lastName.setBounds(300, 300, 200, 50);
        lastName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lastName.setHorizontalAlignment(JTextField.CENTER);
        lastName.setBorder(BorderFactory.createBevelBorder(1));

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(150, 200, 200, 50);
        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(150, 300, 200, 50);
        lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        submit = new JButton("Submit");
        submit.setBounds(300, 400, 200, 50);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        submit.setFocusPainted(false);
        submit.setBackground(Color.white);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(300, 500, 200, 50);
        back.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        back.setFocusPainted(false);
        back.setBackground(Color.white);
        back.addActionListener(this);

        frame.add(title);
        frame.add(firstName);
        frame.add(lastName);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(submit);
        frame.add(back);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            //Check if textfield is empty
            if (firstName.getText().isEmpty() || lastName.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            //Check if textfield contains only letters
            } 
            else if (!firstName.getText().matches("[a-zA-Z]+") || !lastName.getText().matches("[a-zA-Z]+")){
                JOptionPane.showMessageDialog(null, "Please enter a valid name.");
            }
            else{
                //Create new sim
                Sim sim = new Sim(firstName.getText(), lastName.getText());
                Rumah rumah = new Rumah();
                World.addSim(sim,rumah);
                JOptionPane.showMessageDialog(null, "New sim created. Welcome to SimPlicity 5, " + firstName.getText() + " " + lastName.getText() + "!");
                frame.dispose();
                new SimMenu(sim);
            }
        }
        if(e.getSource() == back){
            frame.dispose();
            new MainMenu();
        }
    }
}