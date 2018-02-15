package LoginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame{

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
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
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel UserName = new JLabel("Username: ");
		UserName.setBounds(22, 72, 73, 24);
		frame.getContentPane().add(UserName);
		
		JLabel PassWord = new JLabel("Password: ");
		PassWord.setBounds(22, 125, 73, 24);
		frame.getContentPane().add(PassWord);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(105, 74, 270, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton Login = new JButton("LOGIN");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = txtPassword.getText();
				String username = txtUsername.getText();
			}
		});
		Login.setBounds(105, 204, 108, 23);
		frame.getContentPane().add(Login);
		
		JButton newUser = new JButton("NEW USER");
		newUser.setBounds(272, 204, 114, 23);
		frame.getContentPane().add(newUser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 180, 414, 2);
		frame.getContentPane().add(separator);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(105, 125, 270, 20);
		frame.getContentPane().add(txtPassword);
		Login.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        try {
		          File file = new File("userPass.txt");
		          Scanner scan = new Scanner(file);;
		          String line = null;
		          FileWriter filewrite = new FileWriter(file, true);

		          String usertxt = " ";
		          String passtxt = " ";
		          String puname = txtUsername.getText();
		          String ppaswd = txtPassword.getText();


		          while (scan.hasNext()) {
		        	  if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
		        		    MainMenu menu =new MainMenu();
		        		    dispose();
		        		} 
		            usertxt = scan.nextLine();
		            passtxt = scan.nextLine();

		          }
		          if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
		            MainMenu menu =new MainMenu();
		            dispose();
		          } 
		          else if(puname.equals("") && ppaswd.equals("")){
		            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
		          }
		          else {
		            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
		            txtUsername.setText("");
		            txtPassword.setText("");
		            txtUsername.requestFocus();
		          }
		        } catch (IOException d) {
		          d.printStackTrace();
		        }
		      }
		    });
		newUser.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e) {
		        NewUser user = new NewUser();
		        dispose();
		      }
		    });
	}
}
