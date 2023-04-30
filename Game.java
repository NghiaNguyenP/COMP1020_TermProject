package COMP1020_TermProject;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
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



public class Game extends JFrame {

    // private JLabel statusbar;
    // private String username;

    // public Tetris() {
    //     initUI();
    // }

    // private void initUI() {

    //     statusbar = new JLabel(" 0");
    //     add(statusbar, BorderLayout.SOUTH);

    //     var board = new Board(this);
    //     add(board);
    //     board.start();

    //     setTitle("Tetris");
    //     setSize(400, 700);
    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setLocationRelativeTo(null);
    // }

    // JLabel getStatusBar() {

    //     return statusbar;
    // }
    private String username;

    public void initButton(){
        JFrame f=new JFrame("Login");  
        final JTextField tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        JButton b=new JButton("PLAY");  
        b.setBounds(50,100,95,30);  
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                tf.setText("Enter username.");  
            }  
        });

        f.add(b);f.add(tf);
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (b.isEnabled()){
                    System.out.println("Add Button is pressed");
                    username = tf.getText();
                    System.out.print(username);
                    // b.dispose();
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
    }

    public static void main(String[] args) {
        // TODO: Save the score
        Scanner sc = new Scanner(System.in);
        // String player = sc.nextLine();
        int score;

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