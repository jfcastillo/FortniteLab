
package controller;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import collections.HashEntry;
import collections.ILinkedList;
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

    private Fortnite fortnite;
    private MainViewController menu;
    
    
    

	public SettingsController() {
		

	}
	
	


	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbPlatform.getItems().add(PLATFORMS[0]);
		cbPlatform.getItems().add(PLATFORMS[1]);
		cbPlatform.getItems().add(PLATFORMS[2]);
		fortnite = new Fortnite();
		for (int i = 0; i < 1000; i++) {
			
			Player playerToAdd = fortnite.generatorPlayer();
			System.out.println(i+" "+playerToAdd.toString());
			fortnite.addPlayerQueue(playerToAdd);
			fortnite.addPlayersHash(playerToAdd);
		} 
//		Player p1 = new Player("Felipe", "PS4", Player.IN_QUEUE);
//		Player p2 = new Player("Castillo", "PS4", Player.IN_QUEUE);
//		Player p3 = new Player("Rincon", "PS4", Player.IN_QUEUE);
//		Player p4 = new Player("Juan", "PS4", Player.IN_QUEUE);
//		fortnite.addPlayersHash(p1);
//		fortnite.addPlayersHash(p2);
//		fortnite.addPlayersHash(p3);
//		fortnite.addPlayersHash(p4);
//		System.out.println(fortnite.getPlayers().tableRetrieve(100).size());
//		System.out.println("----------------------------------------------");
//		int pingMin = 0;
//		int pingMax = 100;
//		for (int i = pingMin; i < pingMax ; i++) {
//			ILinkedList<HashEntry<Integer, Player>> list = fortnite.getPlayers().tableRetrieve(i);
//			System.out.println("indice: "+i+" "+fortnite.getPlayers().tableRetrieve(i).size());
////			System.out.println(i);
//			if (list.size()>0) {
//				for (int j = 0; j < list.size(); j++) {
//					System.out.println("skill "+list.get(j).getValue().getSkill());
//				}
//				
//			}
//			
//		}
		
		
//		try {
//			fortnite.leerTxt();
//		} catch (ClassNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	@FXML
    void openMenu(ActionEvent event) {
		String nickname = txtNickname.getText();
		String platform = cbPlatform.getValue();
		System.out.println(fortnite.getPlayerInQueue().deQueue().toString());
		fortnite.setActualPlayer(nickname, platform, Player.NORMAL);
		
		
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


	public void joinMatch() {
		fortnite.getActualPlayer().setStatus(Player.IN_QUEUE);
		fortnite.addPlayerToMatch(fortnite.getActualPlayer(), (int)(Math.random()*100)+1);
	}
	
	
	
	
}
