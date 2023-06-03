package COMP1020_TermProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisLoginWindow extends JFrame {
    private JTextField usernameTextField;
    private JButton loginButton;

    public TetrisLoginWindow() {
        setTitle("Tetris - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));

        // Set custom background image
        ImageIcon backgroundImage = new ImageIcon("background.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        add(backgroundLabel);

        // Create a panel with transparent background
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Create username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        // Create username text field
        usernameTextField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(usernameTextField, constraints);

        // Create login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();

                // Perform login authentication here
                if (authenticateUser(username)) {
                    JOptionPane.showMessageDialog(TetrisLoginWindow.this,
                            "Login successful!",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Launch Tetris game window or perform other actions
                } else {
                    JOptionPane.showMessageDialog(TetrisLoginWindow.this,
                            "Invalid username. Please try again.",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the panel to the content pane
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    private boolean authenticateUser(String username) {
        // Implement your authentication logic here
        // Return true if the username is valid, otherwise return false
        // You can use a database, file, or any other authentication mechanism
        return username.equals("admin");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TetrisLoginWindow loginWindow = new TetrisLoginWindow();
            loginWindow.setVisible(true);
        });
    }
}
