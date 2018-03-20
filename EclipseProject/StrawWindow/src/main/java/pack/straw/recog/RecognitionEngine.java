package pack.straw.recog;

import java.net.URL;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/*
 * To use below following steps has to be followed!
 * 
 * Step1: Instantiate this class with web site name.
 * 
 * 		RecognitionEngine REO = new RecognitionEngine(websiteName);
 * 
 * Step 2: Start Mic Recording
 * 
 * 		REO.startMicRecording();
 * 
 * Step 3: Start Microphone Recognizing
 * 
 * 		REO.startRecognizing();
 * 
 * Step 4: Get the Result
 * 
 * 		String result = REO.getResultText();
 * 
 * Step 5: Stop Microphone Recording
 * 
 * 		REO.stopMicRecording();
 * 
 * Step 6: Deallocate memory to recognizer
 * 
 * 		REO.memoryDeallocation();
 * */

public class RecognitionEngine extends Thread
{
	private String configFileName;
	
	private  URL url;
	private ConfigurationManager configManager;
	private Recognizer recognizer;
	private Microphone microphone;
	private Result result;
	
	private String resultText;
	
	public RecognitionEngine() 
	{
		// No-arg constructor
	}
	
	public RecognitionEngine(String configFileName)
	{
		this.configFileName = configFileName + ".config.xml";
		url = RecognitionEngine.class.getResource(this.configFileName);
		configManager = new ConfigurationManager(url);
		recognizer = (Recognizer) configManager.lookup("recognizer");
		microphone = (Microphone) configManager.lookup("microphone");
		recognizer.allocate();
	}
	
	public void startMicRecording()
	{
		microphone.clear();
		microphone.startRecording();
	}
	
	// Function based implementation of Recognition
	public void startRecognizing()
	{
		// microphone.clear();
		
		System.out.println("Console: Speak now my friend!");
		
		// microphone.startRecording();
		
		result = recognizer.recognize();
		
		resultText = result.getBestFinalResultNoFiller();
		
		System.out.println("Console: You said: "+resultText);
		
		// microphone.stopRecording();
	}
	
	public void stopMicRecording()
	{
		microphone.stopRecording();
	}
	
	public String getResultText()
	{
		return resultText;
	}
	
	public void memoryDeallocation()
	{
		this.recognizer.deallocate();
	}
	
	
	
	
	/* ANYTHING BELOW THIS IS REDUNDANT CODE!! */
	
	
	
	
	// Thread based implementation of Recognition
	@Override
	public void run()
	{		
		if (microphone.startRecording()) 
        {
        	
        	while (true) 
        	{
        		System.out.println("Start speaking. Press Ctrl-C to quit.\n");
        		 
        		result = recognizer.recognize();
        		
        		if (result != null) 
        		{
        			resultText = result.getBestFinalResultNoFiller();
        			        			
        			System.out.println("You said: " + resultText + "\n");
        		} 
        		else 
        		{
        			System.out.println("I can't hear what you said.\n");
        		}
        	}
        } 
        else 
        {
        	System.out.println("Cannot start microphone.");
        	memoryDeallocation();
        	System.exit(1);
        }
	}
	
	/*
	public static void main(String[] args) throws InterruptedException 
	{
		
        try 
        {
        	URL url = RecognitionEngine.class.getResource("bankbazaar.config.xml");
        	
            System.out.println("Loading...");
            
            ConfigurationManager cm = new ConfigurationManager(url);
            
            Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
            Microphone microphone = (Microphone) cm.lookup("microphone");
            
            
            // allocate the resource necessary for the recognizer 
            recognizer.allocate();
            
            // the microphone will keep recording until the program exits
            if (microphone.startRecording()) 
            {
            	
            	while (true) 
            	{
            		System.out.println("Start speaking. Press Ctrl-C to quit.\n");
            		
                    
                    // This method will return when the end of speech
                    // is reached. Note that the endpointer will determine
                    // the end of speech.
                      
            		Result result = recognizer.recognize();
            		
            		if (result != null) 
            		{
            			String resultText = result.getBestFinalResultNoFiller();
            		
            			System.out.println("You said: " + resultText + "\n");
            		} 
            		else 
            		{
            			System.out.println("I can't hear what you said.\n");
            		}
            	}
            } 
            else 
            {
            	System.out.println("Cannot start microphone.");
            	recognizer.deallocate();
            	System.exit(1);
            }
        } 
        catch (PropertyException e) 
        {
            System.err.println("Problem configuring Recognition Engine!: " + e);
            e.printStackTrace();
        }
    }
    */
}
