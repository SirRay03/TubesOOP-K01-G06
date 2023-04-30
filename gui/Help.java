package gui;

import java.awt.*;
import javax.swing.JLabel;

public class Help {
    MyFrame frame;

    public Help(){
        frame = new MyFrame("HELP","Panduan Bermain");
        frame.middlePanel.setLayout(new GridLayout(8,1));

        JLabel helpText1 = new JLabel("1. Start Game untuk memulai permainan ataupun membuat sim baru");
        JLabel helpText2 = new JLabel("2. Exit untuk keluar dari permainan");
        JLabel helpText3 = new JLabel("3. Load game intuk berganti sim");
        JLabel helpText4 = new JLabel("4. Go to world");
        JLabel helpText5 = new JLabel("5. Go to Inventory untuk melihat seluruh item yang dimiliki");
        JLabel helpText6 = new JLabel("6. Buy item untuk membeli beberapa item in game");
        JLabel helpText7 = new JLabel("7. View sim info untuk melihat status sebuah sim yang sedang dimainkan");
        JLabel helpText8 = new JLabel("8. Terdapat beberapa aksi yang dapat dilakukkan oleh sim");
        helpText1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText8.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText1.setForeground(Color.WHITE);
        helpText2.setForeground(Color.WHITE);
        helpText3.setForeground(Color.WHITE);
        helpText4.setForeground(Color.WHITE);
        helpText5.setForeground(Color.WHITE);
        helpText6.setForeground(Color.WHITE);
        helpText7.setForeground(Color.WHITE);
        helpText8.setForeground(Color.WHITE);

        MyButton back = new MyButton("Back");
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        frame.bottomPanel.setLayout(new BorderLayout());
        frame.bottomPanel.add(back, BorderLayout.WEST);

        frame.middlePanel.add(helpText1);
        frame.middlePanel.add(helpText2);
        frame.middlePanel.add(helpText3);
        frame.middlePanel.add(helpText4);
        frame.middlePanel.add(helpText5);
        frame.middlePanel.add(helpText6);
        frame.middlePanel.add(helpText7);
        frame.middlePanel.add(helpText8);
        frame.setVisible(true);
    }
}
