package ViewLogin;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController {
	    @FXML 
	    private Text actiontarget;
	
	    @FXML
	    private Label Status;
	    
	    @FXML static TextField UserField ;

	    @FXML static PasswordField PassField ;
	    
	    @FXML static Button LoginButton;
	    
	     @FXML static Button CreateButton;

	    @FXML
	    private void login() {
	       if(UserField.getText().equals("user") && PassField.getText().equals("pass")) {
	    	   Status.setText("Login Succesful");
	       } else {
	    	   Status.setText("Login Failed");
	       }
	    }
	    @FXML 
	    public void Login(ActionEvent event) { 
	    	LoginButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("!");
				}
		    });
	    }
		@FXML 
		public void Create(ActionEvent event) throws IOException {
			Parent Registration = FXMLLoader.load(getClass().getResource("Registration.fxml"));
			Scene RegistrationScene = new Scene(Registration);
			Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			window.setScene(RegistrationScene);
			window.show();
	    }
}

