// src/RegisterController.java
package src;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleRegister(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        DatabaseHelper.createUser(username, password);
        System.out.println("User registered");
    }
}
