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
	import javafx.scene.control.RadioButton;
	import javafx.scene.control.TextField;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;
	import javafx.stage.WindowEvent;

	public class TransactionCotnroller {
		    
		 	@FXML
		    private TextField CreditCard ;
		 	
		    @FXML
		    private TextField FirstName ;
		    
		    @FXML
		    private TextField LastName ;
		    
		    @FXML
		    private TextField Month ;
		    
		    @FXML
		    private TextField Year ;
		    
		    @FXML
		    private TextField BillingAddress1;
		    
		    @FXML
		    private TextField BillingAddress2;
		    
		    @FXML
		    private TextField City;
		    
		    @FXML
		    private TextField State;
		    
		    @FXML
		    private TextField ZipCode;
		    
		    @FXML
		    private TextField PhoneNumber;
		    
		    @FXML
		    private TextField EMailAddress;

		    @FXML
		    private PasswordField Password ;
		    
		    @FXML
		    private PasswordField Confirm ;
		    
		    @FXML
		    private RadioButton VISA;
		    
		    @FXML
		    private RadioButton MasterCard;
		    
		    @FXML
		    private RadioButton AMEX;
		    
		    @FXML
		    private RadioButton Discovery;
		    
		    @FXML
		    private Button Pay;
		    
		    @FXML
		    private Button Cancel;


		    @FXML 
		    public void Pay(ActionEvent event) {
		    	Pay.setOnAction(new EventHandler<ActionEvent>() {
		    	    @Override
		    	    public void handle(ActionEvent event) {
		    	        if((FirstName.getText().isEmpty() && LastName.getText().isEmpty()) || (FirstName.getText().isEmpty() || LastName.getText().isEmpty())) {
		    	            Alert Name = new Alert(Alert.AlertType.ERROR);
		    	            Name.setTitle("Form Error!");
		    	            Name.setHeaderText("Please enter your name");
		    	            return;
		    	        }
		    	        if(EMailAddress.getText().isEmpty()) {
		    	        	Alert User = new Alert(Alert.AlertType.ERROR);
		    	            User.setTitle("Form Error!");
		    	            User.setHeaderText("Please enter your E-Mail");
		    	            return;
		    	        }
		    	        if((Month.getText().isEmpty() && Year.getText().isEmpty()) || (Month.getText().isEmpty() || Year.getText().isEmpty())) {
		    	            Alert emptyPassword = new Alert (Alert.AlertType.ERROR);
		    	            emptyPassword.setTitle("Form Error!");
		    	            emptyPassword.setHeaderText("Please enter an expiration date:");
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
			public void Craete(ActionEvent event) throws IOException {
				if(Password.getText().equals(Confirm.getText())) {
					Parent Login1 = FXMLLoader.load(getClass().getResource("Login.fxml"));// Will be changed to Homepage.fmxl
					Scene LoginScene1 = new Scene(Login1);
					Stage window3 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
					window3.setScene(LoginScene1);
					window3.show();
				}
				Parent Login1 = FXMLLoader.load(getClass().getResource("Login.fxml"));// Will be changed to Homepage.fmxl
				Scene LoginScene1 = new Scene(Login1);
				Stage window3 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				window3.setScene(LoginScene1);
				window3.show();
		    }
			public void CancelButtontoLogin(ActionEvent event) throws IOException{
				Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
				Scene LoginScene = new Scene(Login);
				Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				window2.setScene(LoginScene);
				window2.show();
		    }
	}