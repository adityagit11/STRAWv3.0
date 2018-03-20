package com.demo.tts;

import pack.straw.tts.Speaker;

public class DemoTTSengine 
{
	public static void main(String args[])
	{
		/*
		MainSpeaker speak = new MainSpeaker();
		speak.convertToSpeech("Hello Everyone, Welcome to STRAW, Speech To Text Recognition for Automating Web Browser");
		speak.freeReference();
		*/
		
		Speaker speak = new Speaker();
		
		System.out.println("1");
		String command = "Hello everyone, Welcome to Speech To Text Recognition" +
				"for Automating Web Browser"+
				"Production of Aditya Singh, Chandan Kumar and Geek Prakash Maurya" +
				"You have choosen "+ "bankbazaar" + "for voice control automation" +
				"Kindly wait for program to load";
		speak.setCommand(command);
		System.out.println("2");
		speak.start();
		System.out.println("3");
		//speak.deallocateVoice();
		System.out.println("4");
	}
}
