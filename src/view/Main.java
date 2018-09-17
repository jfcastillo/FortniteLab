package view;
	
import java.io.IOException;

import collections.HashTable;
import collections.IHashTable;
import collections.ILinkedList;
import collections.IStack;
import collections.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Player;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/designs/Settings.fxml"));
		Scene scene = new Scene(root);		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
//		Player p1 = new Player("1", "Felipe", "PS4", 220, 110, 12, 2, 112);
//		IHashTable<Integer, Player> ht = new HashTable<>();
//		ht.tableInsert(p1.getPing(), p1);
//		System.out.println(ht.tableRetrieve(112).getValue().getName());
		
		launch(args);		
		
		
	}
}
