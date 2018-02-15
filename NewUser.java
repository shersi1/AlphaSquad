package LoginSystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.*;

public class NewUser extends JFrame{

	private JFrame frame;
	private JTextField UserName;
	private JTextField LastName;
	private JTextField FirstName;
	private JPasswordField PassWord;
	private JPasswordField Confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
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
	public NewUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel First_name = new JLabel("First Name:");
		First_name.setBounds(40, 50, 64, 14);
		frame.getContentPane().add(First_name);
		
		JLabel Last_name = new JLabel("Last Name:");
		Last_name.setBounds(40, 85, 64, 14);
		frame.getContentPane().add(Last_name);
		
		JLabel Username = new JLabel("Username:");
		Username.setBounds(40, 120, 64, 14);
		frame.getContentPane().add(Username);
		
		JLabel Password = new JLabel("Password:");
		Password.setBounds(40, 155, 64, 14);
		frame.getContentPane().add(Password);
		
		JLabel Pass_Confirm = new JLabel("Confirm  Pass:");
		Pass_Confirm.setBounds(40, 190, 76, 14);
		frame.getContentPane().add(Pass_Confirm);
		
		UserName = new JTextField();
		UserName.setColumns(10);
		UserName.setBounds(120, 117, 275, 20);
		frame.getContentPane().add(UserName);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		LastName.setBounds(120, 82, 275, 20);
		frame.getContentPane().add(LastName);
		
		FirstName = new JTextField();
		FirstName.setColumns(10);
		FirstName.setBounds(120, 47, 275, 20);
		frame.getContentPane().add(FirstName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 227, 419, 2);
		frame.getContentPane().add(separator);
		
		JButton create = new JButton("CREATE");
		create.setBounds(118, 251, 89, 23);
		frame.getContentPane().add(create);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setBounds(275, 251, 89, 23);
		frame.getContentPane().add(cancel);
		
		PassWord = new JPasswordField();
		PassWord.setBounds(120, 152, 275, 20);
		frame.getContentPane().add(PassWord);
		
		Confirm = new JPasswordField();
		Confirm.setBounds(120, 187, 275, 20);
		frame.getContentPane().add(Confirm);
		Writer writer = null;
	    File check = new File("userPass.txt");
	    if(check.exists()){

	      //Checks if the file exists. will not add anything if the file does exist.
	    }else{
	      try{
	        File texting = new File("userPass.txt");
	        writer = new BufferedWriter(new FileWriter(texting));
	        writer.write("message");
	      }catch(IOException e){
	        e.printStackTrace();
	      }
	    }
	    create.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        try {
	    File file = new File("userPass.txt");
	    Scanner scan = new Scanner(file);;

	      FileWriter filewrite = new FileWriter(file, true);
	      
	      String firsttxter = " ";
	      String lasttxter = " ";
	      String usertxter = " ";
	      String passtxter = " ";
	      String conftxter = " ";
	      String first = FirstName.getText();
	      String last = LastName.getText();
	      String user = UserName.getText();
	      String pass = PassWord.getText();
	      String confirm = Confirm.getText();
	      while (scan.hasNext()) {
	    	firsttxter = scan.nextLine();
	    	lasttxter = scan.nextLine();
	        usertxter = scan.nextLine();
	        passtxter = scan.nextLine();
	        conftxter = scan.nextLine();
	      }

	        if(user.equals(usertxter) && pass.equals(passtxter)) {
	        	JOptionPane.showMessageDialog(null,"Username is already in use");
	        	UserName.setText("");
	        	PassWord.setText("");
	        	UserName.requestFocus();

	        } 
	        else if(user.equals("") && pass.equals("")){
	        	JOptionPane.showMessageDialog(null,"Please insert Username and Password");
	        }
	        else {
	        	filewrite.write(user+"\r\n" +pass+ "\r\n");
	        	filewrite.close();
	        	JOptionPane.showMessageDialog(null,"Account has been created.");
	        	dispose();
	        	LoginScreen log = new LoginScreen();
	        }
	        } catch (IOException d) {
	      d.printStackTrace();
	    }

	      }
	    });
	    cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
	}

}
