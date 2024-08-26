// src/RegisterController.java
package src;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField usernamField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleRegister(){
        System.out.println("Register clicked");
    }
}
