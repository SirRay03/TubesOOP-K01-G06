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

        JPanel houseHAddress = new JPanel();
        houseHAddress.setPreferredSize(new Dimension(1500, 100));
        houseHAddress.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(houseHAddress);

        JTextField houseHAddressField = new JTextField();
        JTextField houseVAddressField = new JTextField();

        if (World.getInstance().getSimCount() > 0){
            JLabel houseHAddressLabel = new JLabel("House Horizontal Address: ");
            houseHAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            houseHAddressLabel.setForeground(Color.white);
            houseHAddress.add(houseHAddressLabel);

            houseHAddressField.setPreferredSize(new Dimension(500, 50));
            houseHAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            houseHAddressField.setHorizontalAlignment(JTextField.CENTER);
            houseHAddressField.setBorder(BorderFactory.createBevelBorder(1));
            houseHAddress.add(houseHAddressField);

            JPanel houseVAddress = new JPanel();
            houseVAddress.setPreferredSize(new Dimension(1500, 100));
            houseVAddress.setBackground(Color.DARK_GRAY);
            frame.middlePanel.add(houseVAddress);

            JLabel houseVAddressLabel = new JLabel("House Vertical Address: ");
            houseVAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            houseVAddressLabel.setForeground(Color.white);
            houseVAddress.add(houseVAddressLabel);

            houseVAddressField.setPreferredSize(new Dimension(500, 50));
            houseVAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            houseVAddressField.setHorizontalAlignment(JTextField.CENTER);
            houseVAddressField.setBorder(BorderFactory.createBevelBorder(1));
            houseVAddress.add(houseVAddressField);

            frame.middlePanel.add(houseHAddress);
            frame.middlePanel.add(houseVAddress);
        }

        JPanel submit = new JPanel();
        submit.setPreferredSize(new Dimension(1500, 100));
        submit.setBackground(Color.DARK_GRAY);
        frame.middlePanel.add(submit);

        MyButton submitButton = new MyButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                int hAddress = 0;
                int vAddress = 0;
                if (firstName.isEmpty() || lastName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid name!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean unique = true;
                    boolean valid = true;
                    if (World.getInstance().getSimCount() > 0){
                        try{
                            hAddress = Integer.parseInt(houseHAddressField.getText());
                            vAddress = Integer.parseInt(houseVAddressField.getText());
                        } catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Please enter a valid address!", "Error", JOptionPane.ERROR_MESSAGE);
                            valid = false;
                        }
                        if (unique && (hAddress < 0 || hAddress > 64 || vAddress < 0 || vAddress > 64)){
                            JOptionPane.showMessageDialog(null, "Please enter a valid address!", "Error", JOptionPane.ERROR_MESSAGE);
                            valid = false;
                        }
                        if (valid){
                            for (Sim sim: World.getInstance().getSimList()){
                                if (sim instanceof Sim){
                                    if (sim.getFirstName().equals(firstName) && sim.getLastName().equals(lastName)){
                                        JOptionPane.showMessageDialog(null, "Sim already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                                        unique = false;
                                        break;
                                    }
                                }
                            }
                            if (World.getInstance().getMap()[hAddress][vAddress] != null && unique){
                                JOptionPane.showMessageDialog(null, "House already occupied!", "Error", JOptionPane.ERROR_MESSAGE);
                                unique = false;
                            }
                        }
                        
                    }
                        if (unique){
                            Sim sim = new Sim(firstName, lastName);
                            Rumah rumah = new Rumah();
                            World.getInstance().addSim(sim,rumah,hAddress,vAddress);
                            frame.dispose();
                         }
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