package COMP1020_TermProject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import javax.swing.border.Border;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


class Tetris extends JFrame{
    private JLabel statusbar;

    public Tetris() {
        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }
}

class GameLeaderboardGUI extends JFrame {
    private JTextArea leaderboardTextArea;

    public GameLeaderboardGUI() {
        setTitle("Game Leaderboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        // Set a custom background image
        URL imageUrl = getClass().getResource("background.jpg");
        if (imageUrl != null) {
            ImageIcon backgroundIcon = new ImageIcon(imageUrl);
            JLabel backgroundLabel = new JLabel(backgroundIcon);
            backgroundLabel.setBounds(0, 0, backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
            add(backgroundLabel);
        }

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create a title label
        JLabel titleLabel = new JLabel("Game Leaderboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Create a styled border for the text area
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE),
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        leaderboardTextArea = new JTextArea();
        leaderboardTextArea.setEditable(false);
        leaderboardTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        leaderboardTextArea.setForeground(Color.WHITE);
        leaderboardTextArea.setBackground(new Color(0, 0, 0, 150));
        leaderboardTextArea.setOpaque(true);
        leaderboardTextArea.setBorder(border);
        panel.add(leaderboardTextArea, BorderLayout.CENTER);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public void loadLeaderboardFromFile(String filePath) {
        StringBuilder leaderboardText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboardText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        leaderboardTextArea.setText(leaderboardText.toString());
    }
}


public class Game extends JFrame {

    public String username;

    public void writeLeaderboard(String username) throws IOException{
        File file = new File("leaderboard.txt");
        FileWriter leaderboard = new FileWriter(file, true);
        leaderboard.write(username + " ");
        leaderboard.close();
    }

    // public void LeaderboardGUI() throws IOException {
    //     // setTitle("Leaderboard");
    //     // setSize(400, 400);
    //     // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     // setLocationRelativeTo(null);

    //     JFrame f=new JFrame("Leaderboard");  
    //     final JTextField tf=new JTextField();
    //     tf.setBounds(50,50, 200,200);

    //     Scanner scanner = new Scanner(new File("leaderboard.txt"));
    //     String leaderboard = "";
    //     while (scanner.hasNextLine()) {
    //         leaderboard += scanner.nextLine() + "\n";
    //     }
    //     scanner.close();
    //     tf.setText(leaderboard);
    //     // JLabel leaderboardLabel = new JLabel(leaderboard);
    //     // add(leaderboardLabel);
    //     f.add(tf);
    //     f.setSize(400,400); 
    //     f.setLayout(null);  
    //     f.setVisible(true);
    // }

    public void initButton() throws IOException{
        JFrame f=new JFrame("Login");  
        final JTextField tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        JButton b=new JButton("PLAY");  
        b.setBounds(50,100,100,30);  
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                tf.setText("Enter username.");  
            }  
        });

        JButton l=new JButton("SCORES");  
        l.setBounds(50,150,100,30);

        JCheckBox s = new JCheckBox("SOUND");
        s.setBounds(50,200,100,30);

        f.add(b);f.add(tf);f.add(l);f.add(s);
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (b.isEnabled()){
                    System.out.println("Add Button is pressed");
                    username = tf.getText();
                    System.out.print(username);
                    try{
                        FileWriter leaderboard = new FileWriter("leaderboard.txt", true);
                        leaderboard.write(username + " ");
                        System.out.println("WRITING USERNAME");
                        leaderboard.close();
                    } catch (IOException exc){
                        System.out.println("An error occurred.");
                    }
                    b.setVisible(false);
                    f.setVisible(false);
                    tf.setVisible(false);
                    // game.setVisible(true);
                    EventQueue.invokeLater(() -> {
                        var game = new Tetris();
                        game.setVisible(true);
                    });
                }
                if (!b.isEnabled()){
                    System.out.println("Add Button is not pressed");
                }
            }
        });

        l.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (l.isEnabled()){
                    GameLeaderboardGUI leaderboardGUI = new GameLeaderboardGUI();
                    leaderboardGUI.loadLeaderboardFromFile("leaderboard.txt");
                    leaderboardGUI.setVisible(true);
                    // leaderboard.setVisible(true);
                }
            }
        });

    }   

    public static void main(String[] args) throws IOException {


        var login = new Game();
        login.initButton();

        // EventQueue.invokeLater(() -> {
        //     // var login = new Tetris();
        //     // login.initButton();
        //     // var game = new Game();
        //     // game.setVisible(true);
        // });
    }
}