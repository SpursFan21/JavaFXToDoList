// src/LoginController.java
package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
public class LoginController {
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
private void handleSignIn(){
    String username = usernameField.getText();
    String password = passwordField.getText();
    
    if (authenticateUser(username, password)){
        System.out.println("Sign In successful");
        // load the main app screen
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainApp.fxml"));
            StackPane mainRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow(); // Corrected line
            stage.setScene(new Scene(mainRoot, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Invalid username or password");
    }
}


    @FXML
    private void handleRegister(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Register.fxml"));
            StackPane registerRoot = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(registerRoot, 400, 300));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean authenticateUser(String username, String password){
        //connect to database and check credentials
        try (Connection conn = DatabaseHelper.connect()){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, username);
                stmt.setString(2, password);
                try(ResultSet rs = stmt.executeQuery()){
                    return rs.next();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
