package gui;

import javax.swing.*;

import src.Sim;

public class OverlayMerenung{
    MyOverlay overlay;
    public OverlayMerenung(Sim sim){
        overlay = new MyOverlay("I am the magic conch shell");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ask me a question and I will answer!"));
        panel.add(new JTextField(20));
        panel.add(new JButton("Ask"));
        overlay.middlePanel.add(panel);

        JTextField answer = new JTextField(20);
        panel = new JPanel();
        panel.add(new JLabel("Answer:"));
        panel.add(answer);
        overlay.middlePanel.add(panel);

        MyButton submit = new MyButton("Submit");
        submit.addActionListener(e -> {
            String question = answer.getText();
            if (question.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please ask a question!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                sim.merenung();
            }
        });
        overlay.middlePanel.add(submit);
    }
}