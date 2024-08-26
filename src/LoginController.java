// src/LoginController.java
package src;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
public class LoginController {
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSignIn(){
        System.out.println("Sign In Clicked");
    }

    @FXML
    private void handleRegister(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/Register.fxml"));
            StackPane registerRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(registerRoot, 400, 300));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
