package com.demo.tts;

import com.sun.speech.freetts.VoiceManager;

public class Voice {
	
	private String name;
	
	private com.sun.speech.freetts.Voice voice; //empty instance of Voice class within class
	
	public void allocateVoice()
	{
		this.voice.allocate();
	}
	public void deallocateVoice()
	{
		this.voice.deallocate();
	}
	public Voice(String text)
	{
		this.name = text;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		allocateVoice();
	}
	public void sayThis(String textToSpeech)
	{
		this.voice.speak(textToSpeech);
	}
}
