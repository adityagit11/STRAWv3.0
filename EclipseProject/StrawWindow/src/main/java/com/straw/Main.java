package com.straw;
	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application 
{
	Stage window;
	private String pivot_user = "Aditya Singh";
	private String pivot_pass = "S.T.R.A.W";
	public static void main(String[] args) 
	{
		launch(args);
		/*
		System.setProperty("webdriver.gecko.driver","E:\\BEproject\\geckodriver.exe");
		String baseUrl = "https://www.guru99.com/first-webdriver-script.html";
		WebDriver driver = new FirefoxDriver();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.close();
		*/
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		window = primaryStage;
		window.setTitle("Log-IN");
		
		// Username Label
		Label UsernameLabel = new Label();
		UsernameLabel.setText("Username: ");
		
		TextField UsernameInput = new TextField();
		UsernameInput.setPromptText("Enter Username Here!");
		
		VBox UsernameLayout = new VBox(10);
		UsernameLayout.getChildren().addAll(UsernameLabel, UsernameInput);
		
		// Password Label
		Label PasswordLabel = new Label();
		PasswordLabel.setText("Password: ");
		
		TextField PasswordInput = new TextField();
		PasswordInput.setPromptText("Enter Password Here!");
		
		VBox PasswordLayout = new VBox(10);
		PasswordLayout.getChildren().addAll(PasswordLabel,PasswordInput);
		
		VBox InputLayout = new VBox(10);
		InputLayout.getChildren().addAll(UsernameLayout, PasswordLayout);
		
		Button SubmitBut = new Button("Submit");
		SubmitBut.setOnAction(e -> submitButton(UsernameInput.getText(), PasswordInput.getText()));
		
		StackPane Pane = new StackPane();
		Pane.getChildren().add(SubmitBut);
		Pane.setAlignment(Pos.CENTER);
		
		VBox FinalLayout = new VBox(20);
		FinalLayout.getChildren().addAll(UsernameLayout, PasswordLayout, Pane);
		FinalLayout.setPadding(new Insets(70, 50, 50, 50));
		FinalLayout.setSpacing(20);
				
		Scene LoginScene = new Scene(FinalLayout,600,400);
		LoginScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
			KeyCode key = t.getCode();
				if (key == KeyCode.ESCAPE){
					// Here
				}
			}
		});
		
		window.setScene(LoginScene);
				
		window.initStyle(StageStyle.TRANSPARENT);
				
		window.show();
	}
	public void submitButton(String username, String password)
	{
		
	}
}
