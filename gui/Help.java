package gui;

import java.awt.*;
import javax.swing.JLabel;

public class Help {
    MyFrame frame;

    public Help(){
        frame = new MyFrame("HELP","Panduan Bermain");
        frame.middlePanel.setLayout(new GridLayout(8,1));

        JLabel helpText1 = new JLabel("Sim-plicity adalah sebuah game single player dan tidak bisa dimainkan oleh banyak orang sekaligus.");
        JLabel helpText2 = new JLabel("Namun setiap player bisa memiliki banyak dan mengganti karakter sim dalam satu game sekaligus sesuai dengan keinginan.");
        JLabel helpText3 = new JLabel("Di dalam simplicity kita bisa berinteraksi dengan sim tersebut dengan melakukan berbagai aksi yang terdapat di dalamnya seperti makan, tidur, olahraga, dan  banyak aksi lainnya");
        JLabel helpText4 = new JLabel("Rules permainan sangat sederhana yaitu Sim bisa beraktivitas sesuai dengan keinginan user atau player. ");
        JLabel helpText5 = new JLabel("Namun selama beraktifitas sim  harus memiliki mood, kesehatan dan kekenyangan di atas 0. Apabila mood, kesehatan dan kekenyangan sim mencapai angka 0 maka sim akan mati.");
        
        helpText1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        helpText1.setForeground(Color.WHITE);
        helpText2.setForeground(Color.WHITE);
        helpText3.setForeground(Color.WHITE);
        helpText4.setForeground(Color.WHITE);
        helpText5.setForeground(Color.WHITE);

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
        frame.setVisible(true);
    }
}
