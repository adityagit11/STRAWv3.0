package com.demo.tts;

public class MainSpeaker
{
	public Voice voice;
	//constructor
	public MainSpeaker()
	{
		setVoice();
	}
	public void setVoice()
	{
		voice = new Voice("kevin16"); //allocate memory in constructor
	}
	public Voice getVoice()
	{
		return voice;
	}
	public void convertToSpeech(String text)
	{
		voice.sayThis(text);
	}
	public void convertToSpeech(String[] text)
	{
		/*
		 * All of the Web - Elements come over here in the form of text
		 * Only those web - elements which can be accessed by the user
		 * the web - elements text is taken as argument in the form of array
		 * Each word / sentence is spoken by the rhetorician in command*/
		
		//the length of the array is stored in textLength
		int textLength = text.length;
		
		//we have 3 rhetoricians under our command
		
		/*
		 * The first : Kevin = a low quality, unlimited domain, 8kHz diphone voice.
		 * The second : Kevin 16 = a medium quality, unlimited domain, 16kHz diphone voice, called kevin16.
		 * a high quality, limited domain, 16kHz cluster unit voice, called alan
		 * */
		
		//we will choose kevin16 over alan because alan is not suitable for windows OS user and accordig to the statistics 40.23% desktop
		//users use windows operating system
		for(int i = 0;i<textLength;i++)
		{
			voice.sayThis(text[i]);
		}
		//done with this
	}
	public void freeReference()
	{
		voice.deallocateVoice();
		voice = null;
	}
}