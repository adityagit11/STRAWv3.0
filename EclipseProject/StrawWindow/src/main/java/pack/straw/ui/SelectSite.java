package pack.straw.ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SelectSite 
{
	private Stage siteWindow;
	private FXMLLoader loader;
	private AnchorPane rootLayout;
	private Scene scene;
	
	private String userWebsite;
	
	@FXML private TextField WebsiteField;
	
	public void openSelectSiteWindow() throws IOException
	{
		siteWindow = new Stage();
		loader = new FXMLLoader();
		loader.setLocation(SelectSite.class.getResource("SelectSite.fxml"));
		rootLayout = (AnchorPane) loader.load();
		scene = new Scene(rootLayout);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent t){
				KeyCode key = t.getCode();
				if(key == KeyCode.ESCAPE) {
					siteWindow.close();
				}
			}
		});
		
		siteWindow.setScene(scene);
		siteWindow.initStyle(StageStyle.TRANSPARENT);
		siteWindow.show();
	}
	
	public void click_StartButton()
	{
		
	}
}
