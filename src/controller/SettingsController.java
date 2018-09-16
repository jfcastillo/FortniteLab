package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SettingsController implements Initializable{
	public static final String[] PLATFORMS = {"PS4", "XBOX", "SWICHT"}; 

    @FXML
    private TextField txtNickname;

    @FXML
    private ComboBox<String> cbPlatform;

    @FXML
    private Button btnOk;

    
    private MainViewController menu;
    

	public SettingsController() {
		
		
	}

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbPlatform.getItems().add(PLATFORMS[0]);
		cbPlatform.getItems().add(PLATFORMS[1]);
		cbPlatform.getItems().add(PLATFORMS[2]);
		
	}
	@FXML
    void openMenu(ActionEvent event) {
		System.out.println("openMenu");
		String nickname = txtNickname.getText();
		String platform = cbPlatform.getValue();
		if (nickname.length() == 0 || platform.length() == 0) 
			JOptionPane.showMessageDialog(null, "Ingrese el usuario y la plataforma");		
		else {
//			menu = new MainViewController(nickname);
			
			try {
				Parent menuViewParent = FXMLLoader.load(getClass().getResource("/designs/Menu.fxml"));
				Scene menuViewScene = new Scene(menuViewParent);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(menuViewScene);
				window.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
    }
}
