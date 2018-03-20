package pack.straw.automate.bankbazaar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pack.straw.recog.RecognitionEngine;
import pack.straw.tts.Speaker;

public class HomeBankBazaar 
{
	private static String websiteURL = "https://www.bankbazaar.com";
	
	private static String recognizedString = "";
	
	public static void run(RecognitionEngine REO, Speaker speak, WebDriver driver, JavascriptExecutor jse)
	{
		driver.get(websiteURL);
		
		REO.startMicRecording();
		while(!recognizedString.equalsIgnoreCase("terminate application"))
		{
			REO.startRecognizing();
			recognizedString = REO.getResultText();
			
			if(recognizedString.equalsIgnoreCase("MOUSE SCROLL UPWARD"))
				jse.executeScript("window.scrollBy(0,-200)");
			else if(recognizedString.equalsIgnoreCase("MOUSE SCROLL DOWN"))
				jse.executeScript("window.scrollBy(0,+200)");
		}
		
		
		driver.close();		
		REO.stopMicRecording();
		REO.memoryDeallocation();
	}
}
