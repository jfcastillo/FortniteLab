package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController implements Initializable{
	private String nickname;
    @FXML
    private Button btnJoinMatch;

    @FXML
    private Button btnPlatformMode;

    @FXML
    private Button btnValentineMode;

    @FXML
    private Button btnLeaveFortnite;

    @FXML
    private Label lblUserName;

    private SettingsController settings;
	


//	public MainViewController(SettingsController s) {
//		nickname = "" ;
//		settings = s;
//
//
//		
//		
//		//username();
//	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		lblUserName.setText(nickname); 

		
	}
	public void setUsername(String username) {
		nickname = username;
		
	}
	public void param(SettingsController s, String username) {
		settings = s;
		lblUserName.setText(username); 
		
	}
	
	public void username() {
		
		//lblUserName.setText("ser");
		
		
	}
	
	

} 