
package controller;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.LoaderHandler;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Fortnite;
import model.Player;

public class SettingsController implements Initializable{
	public static final String[] PLATFORMS = {"PS4", "XBOX", "SWICHT"}; 

    @FXML
    private TextField txtNickname;

    @FXML
    private ComboBox<String> cbPlatform;

    @FXML
    private Button btnOk;

    private Player m;
    private String nickname;
    
    private MainViewController menu;
    private Fortnite fortnite;
    

	public SettingsController() {
		

	}
	
	


	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbPlatform.getItems().add(PLATFORMS[0]);
		cbPlatform.getItems().add(PLATFORMS[1]);
		cbPlatform.getItems().add(PLATFORMS[2]);
		for (int i = 0; i < 10000; i++) {
			fortnite = new Fortnite();
			Player playerToAdd = fortnite.generatorPlayer();
			System.out.println(i+" "+playerToAdd.toString());
			fortnite.addPlayerQueue(playerToAdd);
			fortnite.addPlayersHash(playerToAdd);
		}
		
	}
	@FXML
    void openMenu(ActionEvent event) {
		nickname = txtNickname.getText();
		String platform = cbPlatform.getValue();
		
		
		if (nickname.length() == 0 || platform.length() == 0) 
			JOptionPane.showMessageDialog(null, "Ingrese el usuario y la plataforma");		
		else {
//			menu = new MainViewController(nickname);
			
			try {
//				Stage window = new Stage();
				FXMLLoader loader = new FXMLLoader();
//				Parent menuViewParent = FXMLLoader.load(getClass().getResource("/designs/Menu.fxml"));
				
				//Don't forget to put openStream();
				AnchorPane menuViewParent = (AnchorPane) loader.load(getClass().getResource("/designs/Menu.fxml").openStream());
				MainViewController mainControllerInstance = (MainViewController)loader.getController();
				mainControllerInstance.param(this, nickname);
				
				Scene menuViewScene = new Scene(menuViewParent);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				
				window.setScene(menuViewScene);
//				window.alwaysOnTopProperty();
//				window.initModality(Modality.APPLICATION_MODAL);
				window.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
    }



	
	
	
	
}
