package gui;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class MyTextField extends JTextField{

    JTextField textField;

    public MyTextField(String placeholder) {
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(1000, 50));
        textField.setForeground(Color.GRAY); // Set the text color to gray
        textField.setText(placeholder); // Set the placeholder text

        // Add a focus listener to the text field to remove the placeholder text when the user clicks on it
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // if (textField.getText().equals(placeholder)) {
                //     textField.setText("");
                //     textField.setForeground(Color.BLACK); // Set the text color back to black
                // }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // if (textField.getText().isEmpty()) {
                //     textField.setForeground(Color.GRAY); // Set the text color back to gray
                //     textField.setText(placeholder); // Set the placeholder text
                // }
            }
        });

    }

    public void setEdit(boolean editable) {
        textField.setEditable(editable);
    }
}