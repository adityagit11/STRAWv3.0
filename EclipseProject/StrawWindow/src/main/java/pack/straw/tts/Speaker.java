package pack.straw.tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * There are two ways to use this class, 
 * 1. Creating thread of speaker
 * 		Speaker speaker = new Speaker();
 * 		String command = "This is command!";
 * 		speaker.setCommand(command);
 * 		speaker.start();
 * 		speaker.deallocateVoice();
 * 
 * 2. Function calling - speakThis()
 * 		Speaker speaker = new Speaker();
 * 		String command = "This is command!";
 * 		speaker.speakThis(command);
 * 		speaker.deallocateVoice();
 * */

public class Speaker extends Thread
{
	private Voice voice;
	
	private String command;
	
	public Speaker()
	{
		voice = VoiceManager.getInstance().getVoice("kevin16");
		allocateVoice();
	}
	
	private void allocateVoice()
	{
		voice.allocate();
	}
	
	public void setCommand(String command)
	{
		this.command = command;
	}
	
	public void speakThis(String command)
	{
		voice.speak(command);
	}
	
	public void run()
	{
		voice.speak(command);
	}
	
	public void deallocateVoice()
	{
		voice.deallocate();
	}
}