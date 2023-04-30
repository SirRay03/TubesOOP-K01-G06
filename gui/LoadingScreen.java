package gui;

import javax.swing.JProgressBar;

public class LoadingScreen {
    LoadingScreen(){
        MyFrame frame = new MyFrame("Loading Screen", "Your sim is loading...");
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(0);


        frame.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();
        //new HomePage1();
    }
}
