package pack.straw.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pack.straw.automate.bankbazaar.HomeBankBazaar;
import pack.straw.recog.RecognitionEngine;
import pack.straw.tts.Speaker;

/*
 * Three events are taken care of here,
 * 1. Starting the recognition engine.
 * 2. Selection of web site to automate.
 * 3. Starting Kevin-16, FreeTTS Engine
 * */

public class HomePageSelection 
{
	private static String geckoDriverLoc = "E:\\BEproject\\geckodriver.exe";
	
	private RecognitionEngine REO;
	private Speaker speaker;
	private static WebDriver driver;
	private static JavascriptExecutor jse;
	
	private String websiteName;
	
	private String command;
	
	public HomePageSelection() 
	{
		// No-Arg Constructor
	}
	
	public HomePageSelection(String websiteName)
	{
		this.websiteName = websiteName;
	}
	
	public void run()
	{
		// Start TTS Engine
		
		speaker = new Speaker();
		
		command = "Hello everyone, Welcome to Speech To Text Recognition" +
				"for Automating Web Browser"+
				"Production of Aditya Singh, Chandan Kumar and Geek Prakash Maurya" +
				"You have choosen "+ websiteName + "for voice control automation" +
				"Kindly wait for program to load";
		
		speaker.setCommand(command);
		speaker.start();
		
		// Start Recognition Engine
		
		REO = new RecognitionEngine(websiteName);
		

		// Update this location
		System.setProperty("webdriver.gecko.driver", geckoDriverLoc);
				
		driver = new FirefoxDriver();
		
		jse = (JavascriptExecutor) driver;
		
		if(websiteName.equalsIgnoreCase("BANKBAZAAR"))
		{
			HomeBankBazaar.run(REO, speaker, driver, jse);
		}
		else if(websiteName.equalsIgnoreCase("FACEBOOK"))
		{
			// Not-Available
		}
		else if(websiteName.equalsIgnoreCase("YOUTUBE"))
		{
			// Not-Available
		}
		
		// De-allocate memory to speaker after website driver has been closed.
		speaker.deallocateVoice();
		
		/**
		 * EVERY LINE OF CODE BELOW THIS IS REDUNDANT*/
		
		/*
		RecognitionEngine REO = new RecognitionEngine(websiteName);
		String recognizedString = "";
		REO.startMicRecording();
		while(!recognizedString.equalsIgnoreCase("terminate application"))
		{
			REO.startRecognizing();
			recognizedString = REO.getResultText();
		}
		REO.stopMicRecording();
		REO.memoryDeallocation();
		*/
	}
}
