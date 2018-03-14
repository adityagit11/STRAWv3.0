package pack.straw.ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InvalidLoginWindow 
{
	private Stage invalidWindow;
	private FXMLLoader loader;
	private AnchorPane rootLayout;
	private Scene scene;
	
	public void openInvalid_Popup() throws IOException
	{
		invalidWindow = new Stage();
		loader = new FXMLLoader();
		loader.setLocation(SelectSite.class.getResource("InvalidLoginWindow.fxml"));
		rootLayout = (AnchorPane) loader.load();
		scene = new Scene(rootLayout);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent t){
				KeyCode key = t.getCode();
				if(key == KeyCode.ESCAPE) {
					invalidWindow.close();
				}
			}
		});
		
		invalidWindow.setScene(scene);
		invalidWindow.show();
	}
}
