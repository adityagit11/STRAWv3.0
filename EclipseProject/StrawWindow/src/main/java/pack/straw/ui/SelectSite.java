package pack.straw.ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pack.straw.recog.RecognitionEngine;

//Window - 2
public class SelectSite 
{
	private Stage siteWindow;
	private FXMLLoader loader;
	private AnchorPane rootLayout;
	private Scene scene;
	
	private String userWebsite;
	
	@FXML private TextField WebsiteField;
	@FXML private Button StartButton;
	
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
		userWebsite = WebsiteField.getText();
		
		// Site to automate has been entered
		// Let's start with the automation!
		
		System.out.println("Starting recognition for: "+userWebsite);
		
		RecognitionEngine myRecogEngine = new RecognitionEngine(userWebsite);
		
		// Creating a new thread of Recognition Engine!
		myRecogEngine.start();
		
		Stage stage = (Stage) StartButton.getScene().getWindow();
		stage.close();
	}
}
