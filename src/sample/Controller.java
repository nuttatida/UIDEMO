package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final String id ="admin";
    private final String pass ="1234";

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;
    @FXML
    private Label dbStatus;

    private loginModel loginModel = new loginModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDatabaseConnection()) {
            this.dbStatus.setText("Connected to DB.");
        } else {
            this.dbStatus.setText("Not Connect to DB.");
        }


    }

    @FXML
    public void Login(ActionEvent event){
        try {
            if (id.equals(username.getText())&& pass.equals(password.getText())){
                JOptionPane.showMessageDialog(null,"Welcome to MIT SAIYAI APP");
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "You username or password is incvalid","Warning Message",JOptionPane.WARNING_MESSAGE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }//Login


}//class
