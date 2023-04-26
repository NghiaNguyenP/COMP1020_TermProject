package COMP1020_TermProject;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Tetris extends JFrame {

    private JLabel statusbar;

    public Tetris() {
        initButton();
        // initUI();
    }

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
    }  
  

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }

    public static void main(String[] args) {
        // TODO: Save the score
        Scanner sc = new Scanner(System.in);
        // String player = sc.nextLine();
        int score;

        EventQueue.invokeLater(() -> {
            var game = new Tetris();
            game.setVisible(true);
        });
    }
}
