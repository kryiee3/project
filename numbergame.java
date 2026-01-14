package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.SwingConstants;
import java.awt.Color;

public class numbergame {

	private JFrame frame;
	private JButton btnguess;
	private JTextField inputguess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numbergame window = new numbergame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public numbergame() {
		initialize();
		createEvent();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnguess = new JButton("\r\nGUESS\r\n");
		btnguess.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnguess.setBounds(161, 184, 126, 20);
		frame.getContentPane().add(btnguess);
		
		inputguess = new JTextField();
		inputguess.setForeground(new Color(192, 192, 192));
		inputguess.setText("type here...");
		inputguess.setBounds(179, 153, 86, 20);
		frame.getContentPane().add(inputguess);
		inputguess.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Guess the number game");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(60, 40, 310, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess the number from 1 to 10");
		lblNewLabel_1.setBounds(140, 128, 150, 14);
		frame.getContentPane().add(lblNewLabel_1);
		}
	
		private void createEvent() {
			inputguess.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {inputguess.setText(null);
				}
			});
			
			btnguess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Random r = new Random();
					int low = 1;
					int high = 11;
					int guess;
					int result = r.nextInt(high-low) + low;
					if (inputguess.getText().isEmpty()) {
						JOptionPane.showInternalMessageDialog(
								null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					guess = Integer.parseInt(inputguess.getText());
				}
				if(guess < low || guess > high) {
					JOptionPane.showInternalMessageDialog(
							null, "haha", "Alert", JOptionPane.INFORMATION_MESSAGE);
							inputguess.setText(null);
				return;
				}
				if (guess == result) {JOptionPane.showInternalMessageDialog(
						null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				} else if(guess < result) {JOptionPane.showInternalMessageDialog(
						null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					
				}
					JOptionPane.showInternalMessageDialog(
					null, result, "Alert", JOptionPane.INFORMATION_MESSAGE);	
				}
		});
			
	}
}
