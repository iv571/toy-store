package mru.tsc.application;

import mru.tsc.controller.StoreManager;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class AppDriver extends Application {
	
	/**
	 * Runs the program
	 * @param args
	 */
	
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String [] args) {
		
		LOGR.setLevel(Level.ALL);
		LogManager.getLogManager().reset();
		
		FileHandler fh;
		try {
			fh = new FileHandler("doc/myLog.log", true);
			fh.setLevel(Level.ALL);
			LOGR.addHandler(fh);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		LOGR.info("My First Log");

		new StoreManager();
		   launch(args);
	}
	
	 @Override
	   public void start(Stage primaryStage)
	   {
	      // Constants for the scene dimensions
		   
		   try {
			   BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("sample.fxml"));
			   Scene scene = new Scene(root, 1280, 720);
			 
			   primaryStage.setScene(scene);
			   primaryStage.show();
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }



	
	  
	
}
