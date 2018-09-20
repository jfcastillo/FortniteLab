package view;
	
import java.io.IOException;

import collections.HashEntry;
import collections.HashTable;
import collections.IHashTable;
import collections.ILinkedList;
import collections.IStack;
import collections.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Fortnite;
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
		Player p1 = new Player("Juan", "PS4", "Inqueue");
//		Player p2 = new Player("Felipe", "PS4", "Inqueue");
//		Player p3 = new Player("Castillo", "PS4", "Inqueue");
//		Player p4 = new Player("Rincon", "PS4", "Inqueue");
//		IHashTable<Integer, Player> ht = new HashTable<>();
//		ht.tableInsert(p1.getPing(), p1);		
//		System.out.println(ht.tableRetrieve(p1.getPing()).get(0).getValue().getPing());
//		IHashTable<Integer, String> ht2 = new HashTable<>();
//		ht2.tableInsert(10, "Felipe");
//		ht2.tableInsert(10, "Castillo");
//		ILinkedList<HashEntry<Integer, String>> list = ht2.tableRetrieve(10);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getValue());
//			
//		}
//		System.out.println(list.size());
//		System.out.println(ht.tableRetrieve(112).getValue().getName());
//		for (int i = 90; i < 500;i++) {
//			System.out.println(i%100003);
//		}
		ILinkedList<Integer> list = new List<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		launch(args);		
		
		
	}
}
