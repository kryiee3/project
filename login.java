package proj;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblPassword;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JDesktopPane desktopPane;
    private JButton btnLogin;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                login window = new login();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     * @wbp.parser.entryPoint
     */
    public login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setBounds(700, 400, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblTitle = new JLabel("Login Form");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setBounds(160, 20, 150, 30);
        frame.getContentPane().add(lblTitle);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsername.setBounds(60, 80, 100, 25);
        frame.getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setText("type here......");
        txtUsername.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtUsername.setText(null);
        	}
        });
        txtUsername.setBounds(160, 80, 200, 25);
        frame.getContentPane().add(txtUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPassword.setBounds(60, 120, 100, 25);
        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(160, 120, 200, 25);
        frame.getContentPane().add(txtPassword);
        
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, 1, 1);
        frame.getContentPane().add(desktopPane);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        btnLogin.setBounds(160, 170, 90, 30);
        frame.getContentPane().add(btnLogin);

        // ACTION: Login button
        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = String.valueOf(txtPassword.getPassword());
            if(user.isEmpty()||pass.isEmpty()) {
            	JOptionPane.showMessageDialog(frame, "Login Successful!");
            }
            
            
            //if (user.equals("admin") && pass.equals("123")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            //} else {
            	//if (user.getText().isEmpty()|| pass.getText().isEmpty)
              //  JOptionPane.showMessageDialog(frame, "Empty, fill blank/s.");
            //}
        });
    }
}
