package gui;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

import src.Sim;
import src.World;


public class OverlayMerenung{
    MyOverlay frame;

    public OverlayMerenung(Sim sim){
        frame = new MyOverlay("I am the magic conch shell", "Ïnsert your question here, my child");
        
        JTextField textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(1000, 50));
        textField.setForeground(Color.GRAY); // Set the text color to gray
        frame.interactionBar.add(textField);
        
        MyButton button = new MyButton("Ask");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            textField.setEditable(false);
            button.setEnabled(false);
            int pilihanJawaban = new Random().nextInt(11);
            String[] jawaban = new String[11];
            jawaban[0] = "Semua akan baik-baik saja!";
            jawaban[1] = "Lakukan lebih baik!";
            jawaban[2] = "Semangat!";
            jawaban[3] = "Tidak perlu overthinking";
            jawaban[4] = "Just do it!";
            jawaban[5] = "Ayo, kamu pasti bisa!";
            jawaban[6] = "Yakin? Coba pikir lagi";
            jawaban[7] = "Hal itu terlalu rumit untuk direnungkan";
            jawaban[8] = "Hal yang sangat baik untuk direnungkan";
            jawaban[9] = "Jangan terlalu dipikirkan";
            jawaban[10] = "Merenunglah kembali";
            JOptionPane.showMessageDialog(null,jawaban[pilihanJawaban], "Merenung", JOptionPane.INFORMATION_MESSAGE);
            sim.getKesejahteraan().setMood(3);
            sim.getKesejahteraan().setHunger(-2);
            World.getInstance().addWaktu(1000);
            // World.getInstance().checkSimTime(durasiOlahraga);
            sim.tambahWaktuBelumTidur(1000);
            sim.tambahWaktuBelumBAB(1000); 
            sim.resetTimerBelumBab();
            sim.resetWaktuTidurAfterNoSleep();
            frame.dispose();
        });
        frame.interactionBar.add(button);
    }
}