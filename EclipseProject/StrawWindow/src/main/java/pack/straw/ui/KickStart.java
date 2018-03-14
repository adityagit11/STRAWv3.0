package pack.straw.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KickStart extends Application 
{
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private FXMLLoader loader;
	private Scene scene;
	
	private String userUsername;
	private String userPassword;
	
	private String adminLoginUsername1 = "Aditya Singh";
	private String adminLoginPassword1 = "B120223005";
	
	private String adminLoginUsername2 = "Geet Prakash Maurya";
	private String adminLoginPassword2 = "B120223040";
	
	private String adminLoginUsername3 = "Chandan Kumar";
	private String adminLoginPassword3 = "B120223030";
	
	private String adminLoginUsername4 = "Abhishek Sharma";
	private String adminLoginPassword4 = "B120220801";
	
	@FXML private TextField UsernameField;
	@FXML private TextField PasswordField;
	@FXML private Button LoginButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		this.primaryStage = primaryStage;
		loader = new FXMLLoader();
		loader.setLocation(KickStart.class.getResource("KickStart.fxml"));
		rootLayout = (AnchorPane)loader.load();
		scene = new Scene(rootLayout);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				KeyCode key = t.getCode();
				if(key == KeyCode.ESCAPE) {
					primaryStage.close();
				}
			}
		});
		
		primaryStage.setScene(scene);
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public void click_LoginButton()
	{
		userUsername = UsernameField.getText();
		userPassword = PasswordField.getText();
		
		if(authenticate_Login(userUsername, userPassword))
		{
			//Valid Login
			SelectSite startSession = new SelectSite();
			try
			{
				startSession.openSelectSiteWindow();
				Stage stage = (Stage) LoginButton.getScene().getWindow();
				stage.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Invalid Login
			InvalidLoginWindow loginPop = new InvalidLoginWindow();
			try
			{
				loginPop.openInvalid_Popup();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public boolean authenticate_Login(String username, String password)
	{
		if((username.equalsIgnoreCase(adminLoginUsername1) && password.equalsIgnoreCase(adminLoginPassword1)) ||
				(username.equalsIgnoreCase(adminLoginUsername2) && password.equalsIgnoreCase(adminLoginPassword2)) ||
				(username.equalsIgnoreCase(adminLoginUsername3) && password.equalsIgnoreCase(adminLoginPassword3)))
			return true;
		return false;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
