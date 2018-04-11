package ViewLogin;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RegisterController {
		private User user;
		
		boolean User;
		
		boolean Name;
		
		boolean Pass;
		
		boolean Mail;
	    
	    @FXML
	    private TextField FirstName ;
	    
	    @FXML
	    private TextField LastName ;
	    
	    @FXML
	    private TextField UserName ;
	    
	    @FXML
	    private TextField Email ;

	    @FXML
	    private PasswordField Password ;
	    
	    @FXML
	    private PasswordField Confirm ;
	    
	    @FXML
	    private Button Create;
	    
	    @FXML
	    private Button Cancel;

	    @FXML
	    public void Create(ActionEvent event) {
	    	Create.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {
	    	    	/*user.Firstname = FirstName;
	    	    	FirstName.textProperty().addListener(
	    	    		     (observable, old_value, new_value) -> {
	    	    		          if(FirstName.getText().contains(" "))
	    	    		          {
	    	    		                //prevents from the new space char
	    	    		                FirstName.setText(old_value); 
	    	    		          }
	    	    		     }
	    	    		)
	    	    	user.LastName = LastName;
	    	    	user.Email = Email;
	    	    	user.password = Password;;*/
	    	        if((FirstName.getText().isEmpty() && LastName.getText().isEmpty()) || (FirstName.getText().isEmpty() || LastName.getText().isEmpty())) {
	    	            Alert Name = new Alert(Alert.AlertType.ERROR);
	    	            Name.setTitle("Form Error!");
	    	            Name.setHeaderText("Please enter your name");
	    	           // FirstName.setText();
	    	           // LastName.setText();
	    	            return;
	    	        }
	    	        if(UserName.getText().isEmpty()) {
	    	        	Alert User = new Alert(Alert.AlertType.ERROR);
	    	            User.setTitle("Form Error!");
	    	            User.setHeaderText("Please enter your email id");
	    	            return;
	    	        }
	    	        if((Password.getText().isEmpty() && Confirm.getText().isEmpty()) || (Password.getText().isEmpty() || Confirm.getText().isEmpty())) {
	    	            Alert emptyPassword = new Alert (Alert.AlertType.ERROR);
	    	            emptyPassword.setTitle("Form Error!");
	    	            emptyPassword.setHeaderText("Please enter a password");
	    	            return;
	    	        }
	    	        if(!Password.getText().equals(Confirm)) {
	    	        	Alert PassConf = new Alert (Alert.AlertType.ERROR);
	    	        	PassConf.setTitle("Form Error!");
	    	        	PassConf.setHeaderText("Password does not match");
	    	        	return;
	    	        }

	    	       Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
	    	       Confirmation.setTitle("Welcome");
	    	       Confirmation.setHeaderText("Registration Succsesful");
	    	       Confirmation.setContentText(FirstName.getText() + " " + LastName.getText());
	    	       return;
	    	    }
	    	});
	    }
	    @FXML
	    public boolean NameField (ActionEvent event) {
	    	User = false;
	    	do {
	    		user.Firstname = FirstName.getText().toString();
		    	user.Lastname = LastName.getText().toString();
		    	User = true;
	    	}
	    	while ((!FirstName.getText().equals(null) || !LastName.getText().equals(null)) && (!FirstName.getText().equals(null) && !LastName.getText().equals(null)));
	    	return User;
	    }
	    
	    @FXML
	    public boolean PasswordField (ActionEvent event) {
	    	Pass = false;
	    	do {
	    		user.password = Password.getText().toString();
	    		Pass = true;
	    	}
	    	while ((!Password.getText().equals(null) || !Confirm.getText().equals(null)) && (!Password.getText().equals(null) && !Confirm.getText().equals(null)) && (!Password.getText().equals(Confirm.getText())));
	    	return Pass;
	    }
	    
	    @FXML
	    public boolean EmailField(ActionEvent event) {
	    	Mail = false;
	    	do {
	    		user.Email = Email.getText().toString();
	    		Mail = true;
	    	}
	    	while(!Email.getText().equals(null));
	    	return Mail;
	    }
	    
	    @FXML
	    public boolean UserNameField(ActionEvent event) {
	    	User = false;
	    	do {
	    		user.Username = UserName.getText().toString();
	    		User = true;
	    	}
	    	while(!UserName.getText().equals(null));
	    	return User;
	    }
	    
		@FXML 
		public void Craete(ActionEvent event) throws IOException {
			do {
				Parent Register = FXMLLoader.load(getClass().getResource("CreditCardTransaction.fxml"));// Will be changed to Homepage.fmxl
				Scene RegisterScene = new Scene(Register);
				Stage window3 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				window3.setScene(RegisterScene);
				window3.show();
			} while((User = true) && (Mail = true) && (Name = true) && (Pass = true));
				Alert alert = new Alert (Alert.AlertType.ERROR);
 	            alert.setTitle("Form Error!");
 	            if (User = false) {
 	            	alert.setHeaderText("Please enter a username.");
 	            } 
 	            else if (Mail = false) {
 	            	alert.setHeaderText("Please enter a valid e-mail address.");
 	            }
 	           else if (Pass = false) {
	            	alert.setHeaderText("Please enter a correct password.");
	            }
 	          else if (Name = false) {
	            	alert.setHeaderText("Please enter your name.");
	            }
 	            
 	            return;
			}
			
		
		@FXML
		public void CancelButtontoLogin(ActionEvent event) throws IOException{
			Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene LoginScene = new Scene(Login);
			Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			window2.setScene(LoginScene);
			window2.show();
	    }
}

