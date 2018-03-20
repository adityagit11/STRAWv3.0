package pack.straw.ui;

import javafx.application.Application;
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

// Window - 1
public class KickStart extends Application 
{
	/*
	 * GUI IS built using Java-FX and Scene Builder*/
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private FXMLLoader loader;
	private Scene scene;
	
	// Global variables used for programming STRAW
	private String userUsername;
	private String userPassword;
	
	// Set of some user-credentials in-built
	private String adminLoginUsername1 = "Aditya Singh";
	private String adminLoginPassword1 = "B120223005";
	
	private String adminLoginUsername2 = "Geet Prakash Maurya";
	private String adminLoginPassword2 = "B120223040";
	
	private String adminLoginUsername3 = "Chandan Kumar";
	private String adminLoginPassword3 = "B120223030";
	
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
		
		// Design for transparent window
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	/*
	 * To configure this function execution with the button on UI
	 * First open the scene builder and provide fx:id to the button
	 * Next on the bottom left side with controller tab enter the java file with UI
	 * Next on the right side of the layout with Code tab enter the #onAction with this function name*/
	public void click_LoginButton()
	{
		userUsername = UsernameField.getText();
		userPassword = PasswordField.getText();
		
		if(authenticate_Login(userUsername, userPassword))
		{
			//Valid Login
			// Then start a session or simply start the next window to select site
			SelectSite startSession = new SelectSite();
			try
			{
				startSession.openSelectSiteWindow();
				primaryStage = (Stage) LoginButton.getScene().getWindow();
				primaryStage.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Invalid Login
			// Then pop up a window for invalid login credentials
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
