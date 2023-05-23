package COMP1020_TermProject;

import COMP1020_TermProject.Leaderboard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

class Tetris extends JFrame {
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

public class Game extends JFrame {

    public String username;

    public void writeLeaderboard(String username) throws IOException {
        File file = new File("leaderboard.txt");
        FileWriter leaderboard = new FileWriter(file, true);
        leaderboard.write(username + " ");
        leaderboard.close();
    }

    public void initButton() throws IOException {
        JFrame f = new JFrame("Login");
        Font font = new Font("SansSerif", Font.BOLD, 14);

        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        tf.setFont(font);

        ImageIcon playIcon = new ImageIcon("Icons/play.png");
        Image playScaledIcon = playIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon scaledPlayIcon = new ImageIcon(playScaledIcon);
        JButton b = new JButton("PLAY");
        int playButtonWidth = 130;
        int playButtonHeight = 50;
        int playButtonX = (f.getContentPane().getWidth() - playButtonWidth) / 2;
        int playButtonY = (f.getContentPane().getHeight() - playButtonHeight) / 2;
        b.setBounds(playButtonX, playButtonY, playButtonWidth, playButtonHeight);
        b.setFont(font);
        b.setIcon(scaledPlayIcon);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Enter username.");
            }
        });
        // b.addMouseListener(new ButtonHoverEffect(){
        //     public void mouseEntered(MouseEvent e) {
        //         //add animation for hovering
        //     }
        //     public void mouseExited(MouseEvent e) {
        //         //exit hovering animation
        //     }
        // });

        ImageIcon scoreIcon = new ImageIcon("Icons/high-score.png");
        Image scoreScaledIcon = scoreIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon scaledScoreIcon = new ImageIcon(scoreScaledIcon);
        JButton l = new JButton("SCORES");
        l.setBounds(50, 150, 130, 50);
        l.setFont(font);
        l.setIcon(scaledScoreIcon);
        int scoreButtonWidth = 130;
        int scoreButtonHeight = 50;
        int scoreButtonX = (f.getContentPane().getWidth() - scoreButtonWidth) / 2;
        int scoreButtonY = (f.getContentPane().getHeight() - scoreButtonHeight) / 2;
        b.setBounds(scoreButtonX, scoreButtonY + 80, scoreButtonWidth, scoreButtonHeight);

        JCheckBox s = new JCheckBox("SOUND");
        s.setBounds(50, 200, 100, 30);
        s.setFont(font);

        f.add(b);
        f.add(tf);
        f.add(l);
        f.add(s);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (b.isEnabled()) {
                    System.out.println("Add Button is pressed");
                    username = tf.getText();
                    System.out.print(username);
                    try {
                        FileWriter leaderboard = new FileWriter("leaderboard.txt");
                        leaderboard.write(username + " ");
                        System.out.println("WRITING USERNAME");
                        leaderboard.close();
                    } catch (IOException exc) {
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
                if (!b.isEnabled()) {
                    System.out.println("Add Button is not pressed");
                }
            }
        });

        l.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (l.isEnabled()) {
                    // new Leaderboard(100);
                }
            }
        });

    }

    public static void main(String[] args) throws IOException {

        var login = new Game();
        login.initButton();

        // EventQueue.invokeLater(() -> {
        // // var login = new Tetris();
        // // login.initButton();
        // // var game = new Game();
        // // game.setVisible(true);
        // });
    }
}
