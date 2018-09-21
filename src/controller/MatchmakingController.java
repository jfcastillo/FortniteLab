package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.Match;
import model.Player;

public class MatchmakingController implements Initializable{
	@FXML
    private TableView<Player> table1;

    @FXML
    private Button btnPlay;
    
    private ObservableList<Player> data;
    private MainViewController mainView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		data = FXCollections.observableArrayList();
		table1.setEditable(false);

		table1.setItems(data);
	}
	public void param(MainViewController s, String username) {
		mainView = s;
		data.add(mainView.getSettings().getFortnite().getActualPlayer());
		
	}
	public void tableRefresh(Player p) {
		data.add(p);
		table1.setItems(data);
	}
	

    @FXML
    void startMatch(ActionEvent event) {
    	mainView.getSettings().joinMatch();
    	Match p = mainView.getSettings().getFortnite().getActualMatch();
    	for (int i = 0; i <25; i++) {
//			tableRefresh(p.getPlayers().get(i));
    		data.add(p.getPlayers().get(i));
    		table1.setItems(data);
//    		table1.getColumns().get(i).setVisible(false);
//    		table1.getColumns().get(i).setVisible(true);
			System.out.println(p.getPlayers().get(i).toString());
		}
    	
    }
    

}
