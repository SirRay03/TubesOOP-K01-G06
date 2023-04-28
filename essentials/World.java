package essentials;

import javax.swing.*;
import gui.*;
import java.awt.*;
import java.awt.event.*;

public class World{
    private static int worldCount = 0;
    private static int panjang = 64;
    private static int lebar = 64;
    private Sim[][] map;
    private long time;
    
    public World(){
        this.map = new Sim[panjang-1][lebar-1]; // initialize the map with the appropriate size
        this.time = 720000;
        worldCount++;
    }
    
    public int getPanjangWorld(){
        return panjang;
    }

    public int getLebarWorld(){
        return lebar;
    }

    public void addSim(Sim sim){//i kebawah (kordinat y) j kesamping (kordinat x)
        //Validasi rumah melewati batas
        int x = (int)((Math.random() * panjang)-1);
        int y = (int)((Math.random() * lebar)-1);

        if (map[x][y] == null){
            map[x][y] = sim;
        }
        else{
            while (map[x][y] != null){
                x = (int)((Math.random() * panjang)-1);
                y = (int)((Math.random() * lebar)-1);
            }
            map[x][y] = sim;
        }
    }

        // //Validasi rumah melewati batas
        // if (x >= 0 && x <= getLebarWorld() && y >= 0 && y <= getPanjangWorld()){
        //     //Validasi apakah sudah ada rumah yang dibangun sebelumnya
        //     //Jika belum ada rumah yang dibangun
        //     if (map[y][x] != '0'){
        //         //Mengubah petak yang ada menjadi rumah
        //         map[y][x] = '0';
        //         //Menambahkan rumah ke listofRumah
        //         listofRumah.add(new Point(x,y));
        //     }
        //     else{
        //         System.out.println("Rumah sudah ada");
        //     }   
        // }
        // else{
        //     System.out.println("Rumah melewati batas");
        // }

    // public void printMap() {
    //      for (int i = 0; i < lebar * 2 + 1; i++) {
    //         for (int j = 0; j < panjang * 2 + 1; j++) {
    //             System.out.print(map[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // } 

    public Long getTime(){
        return time;
    }

    public void setTime (Long time){
        this.time -= time;
        if(this.time >= 0){
            this.time += 720000;
        }
    }

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
                    addSim(sim);
                    JOptionPane.showMessageDialog(null, "New sim created. Welcome to SimPlicity 5, " + firstName.getText() + " " + lastName.getText() + "!");
                    frame.dispose();
                    new SimMenu(sim);
                    
                    // for (int i = 0; i < panjang-1; i++){
                    //     for (int j = 0; j < lebar-1; j++){
                    //         if (map[i][j] != null){
                    //             System.out.println(i + " " + j + " " + map[i][j].getFullName());
                    //         }
                    //     }
                    // }
                }
            }
            if(e.getSource() == back){
                frame.dispose();
                new MainMenu();
            }
        }
    }

    public void createNewGame(){
        new NewGame();
    }

    public static int getWorldCount(){
        return worldCount;
    }
}