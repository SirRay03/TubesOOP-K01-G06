package gui;

import java.awt.*;
import javax.swing.JLabel;

public class Help {
    MyFrame frame;

    public Help(){
        frame = new MyFrame("HELP","Panduan Bermain");
        frame.middlePanel.setLayout(new GridLayout(10, 1));

        JLabel helpText1 = new JLabel("Sim-plicity adalah sebuah game single player dan");
        JLabel helpText2 = new JLabel("tidak bisa dimainkan oleh banyak orang sekaligus.");
        JLabel helpText3 = new JLabel("Namun setiap player bisa memiliki banyak dan");
        JLabel helpText4 = new JLabel("mengganti karakter sim dalam satu game sekaligus sesuai dengan keinginan.");
        JLabel helpText5 = new JLabel("Di dalam simplicity kita bisa berinteraksi dengan");
        JLabel helpText6 = new JLabel("sim tersebut dengan melakukan berbagai aksi yang terdapat di dalamnya seperti makan, tidur, olahraga, dan  banyak aksi lainnya");
        JLabel helpText7 = new JLabel("Rules permainan sangat sederhana yaitu");
        JLabel helpText8 = new JLabel("Sim bisa beraktivitas sesuai dengan keinginan user atau player. ");
        JLabel helpText9 = new JLabel("Namun selama beraktifitas sim  harus memiliki mood,");
        JLabel helpText10 = new JLabel("kesehatan dan kekenyangan di atas 0. Apabila mood, kesehatan dan kekenyangan sim mencapai angka 0 maka sim akan mati.");
        
        helpText1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        helpText1.setForeground(Color.WHITE);
        helpText2.setForeground(Color.WHITE);
        helpText3.setForeground(Color.WHITE);
        helpText4.setForeground(Color.WHITE);
        helpText5.setForeground(Color.WHITE);
        helpText6.setForeground(Color.WHITE);
        helpText7.setForeground(Color.WHITE);
        helpText8.setForeground(Color.WHITE);
        helpText9.setForeground(Color.WHITE);
        helpText10.setForeground(Color.WHITE);
        helpText1.setHorizontalAlignment(JLabel.CENTER);
        helpText2.setHorizontalAlignment(JLabel.CENTER);
        helpText3.setHorizontalAlignment(JLabel.CENTER);
        helpText4.setHorizontalAlignment(JLabel.CENTER);
        helpText5.setHorizontalAlignment(JLabel.CENTER);
        helpText6.setHorizontalAlignment(JLabel.CENTER);
        helpText7.setHorizontalAlignment(JLabel.CENTER);
        helpText8.setHorizontalAlignment(JLabel.CENTER);
        helpText9.setHorizontalAlignment(JLabel.CENTER);
        helpText10.setHorizontalAlignment(JLabel.CENTER);

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
        frame.middlePanel.add(helpText9);
        frame.middlePanel.add(helpText10);
        frame.setVisible(true);
    }
}
