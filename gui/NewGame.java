package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.*;

public class NewGame{
    MyFrame frame;

    NewGame(){
        frame = new MyFrame("New Game","Please enter your new sim's name:");

        JPanel firstName = new JPanel();
        firstName.setPreferredSize(new Dimension(1500, 100));
        firstName.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(firstName);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        firstNameLabel.setForeground(Color.white);
        firstName.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(500, 50));
        firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        firstNameField.setHorizontalAlignment(JTextField.CENTER);
        firstNameField.setBorder(BorderFactory.createBevelBorder(1));
        firstName.add(firstNameField);

        JPanel lastName = new JPanel();
        lastName.setPreferredSize(new Dimension(1500, 100));
        lastName.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(lastName);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lastNameLabel.setForeground(Color.white);
        lastName.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(500, 50));
        lastNameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lastNameField.setHorizontalAlignment(JTextField.CENTER);
        lastNameField.setBorder(BorderFactory.createBevelBorder(1));
        lastName.add(lastNameField);

        JPanel submit = new JPanel();
        submit.setPreferredSize(new Dimension(1500, 100));
        submit.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(submit);

        MyButton submitButton = new MyButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                if (firstName.isEmpty() || lastName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid name!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    //TO DO
                    //CHECK IF SIM ALREADY EXISTS
                    Sim sim = new Sim(firstName, lastName);
                    Rumah rumah = new Rumah();
                    World.addSim(sim,rumah);
                    JOptionPane.showMessageDialog(null, "New sim created. Welcome to SimPlicity 5, " + firstName + " " + lastName + "!");
                    frame.dispose();
                    new HomePage(sim);
                    frame.dispose();
                }
            }
        });
        submit.add(submitButton);

        JPanel back = new JPanel();
        back.setPreferredSize(new Dimension(1500, 100));
        back.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(back);

        MyButton backButton = new MyButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });
        back.add(backButton);
    
        frame.getRootPane().setDefaultButton(submitButton);

        frame.setVisible(true);
    }
}