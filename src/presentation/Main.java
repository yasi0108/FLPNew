package presentation;

import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage loginStage) {
		
		LoginUI uiLaunch = new LoginUI();
		uiLaunch.start();

	}


}
