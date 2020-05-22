package presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.OpretMedarbejderLogin;
import logic.userCheckDuplicate;

public class OpretMedarbejderUI {

	private Stage opretLoginStage;

	private TextField fornavnTF;
	private TextField efternavnTF;
	private TextField brugernavnTF;
	private TextField passwordTF;
	private Label opretLoginStatus;
	private Image ferrari;
	private ImageView ferraripic;
	private Button opretLoginKnap;
	private Scene scene2;
	private Pane pane2;
	// private BorderPane bp2;

	public void start() {
		opretLoginStage = new Stage();
		opretLoginStage.setTitle("Ferrari lånesystem");
		opretLoginStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Pane assignment
		pane2 = new Pane();
		pane2.setStyle("-fx-background-color: #F40808");
		// button assignment and label
		opretLoginKnap = new Button("Opret medarbejder");
		opretLoginStatus = new Label();
		// Textfield assignment
		fornavnTF = new TextField();
		efternavnTF = new TextField();
		brugernavnTF = new TextField();
		passwordTF = new TextField();
		// Image assignment
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		ferraripic = new ImageView();

		// Textfield location + promt + font
		fornavnTF.setFont(new Font(24));
		fornavnTF.setPromptText("Fornavn");
		fornavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		fornavnTF.relocate(150, 195);
		efternavnTF.setFont(new Font(24));
		efternavnTF.setPromptText("Efternavn");
		efternavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		efternavnTF.relocate(150, 255);
		brugernavnTF.setFont(new Font(24));
		brugernavnTF.setPromptText("Brugernavn");
		brugernavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		brugernavnTF.relocate(150, 315);
		passwordTF.setFont(new Font(24));
		passwordTF.setPromptText("Password");
		passwordTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		passwordTF.relocate(150, 375);

		// Buttons location + font
		opretLoginKnap.relocate(180, 505);
		opretLoginKnap.setFont(new Font(24));

		opretLoginStatus.setFont(new Font(24));
		opretLoginStatus.setFont(new Font(30));

		// LOGO location
		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(173, 25);

		// Add to pane
		pane2.getChildren().addAll(fornavnTF, efternavnTF, brugernavnTF, passwordTF, opretLoginKnap, opretLoginStatus,
				ferraripic);

		// bp2.getChildren().add(pane2);

		// Show scene
		scene2 = new Scene(pane2, 600, 600);
		opretLoginStage.setResizable(false);
		opretLoginStage.setScene(scene2);
		opretLoginStage.show();

		// Eventhandler
		opretLoginKnap.setOnAction(e -> opretBruger());

	}

	private void opretLoginSuccess() {
		opretLoginStatus.setTextFill(Color.LIGHTGREEN);
		opretLoginStatus.relocate(130, 445);
		opretLoginStatus.setText("Medarbejder blev oprettet!");

	}

	private void opretLoginFailAll() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(135, 445);
		opretLoginStatus.setText("Udfyld venligst alle felter");
	}

	private void opretLoginFailMNavn() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(95, 445);
		opretLoginStatus.setText("Udfyld venligst medarbejder navn");
	}

	private void opretLoginFailUserfornavnTF() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(125, 445);
		opretLoginStatus.setText("Udfyld venligst brugernavn");
	}

	private void opretLoginFailPassword() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(130, 445);
		opretLoginStatus.setText("Udfyld venligst password");
	}

	private void opretLoginFailDuplicateBruger() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(150, 445);
		opretLoginStatus.setAlignment(Pos.CENTER);
		opretLoginStatus.setText("Bruger findes allerede");
	}

	private void opretBruger() {
		userCheckDuplicate opretLoginLGC = new userCheckDuplicate();
		String getTextFornavn = fornavnTF.getText();
		String getTextEfternavn = efternavnTF.getText();
		String getTextBrugernavn = brugernavnTF.getText();
		String getTextPassword = passwordTF.getText();

		if (getTextFornavn.isEmpty() && getTextEfternavn.isEmpty() && getTextBrugernavn.isEmpty()
				&& getTextPassword.isEmpty()) {
			opretLoginFailAll();
		}

		else if (getTextFornavn.isEmpty()) {
			opretLoginFailMNavn();
		} else if (getTextEfternavn.isEmpty()) {
			opretLoginFailMNavn();
		} else if (getTextBrugernavn.isEmpty()) {
			opretLoginFailUserfornavnTF();
		} else if (getTextPassword.isEmpty()) {
			opretLoginFailPassword();
		} else if (opretLoginLGC.UserCheckDuplicate(getTextBrugernavn) == true) {
			opretLoginFailDuplicateBruger();

		} else if (opretLoginLGC.UserCheckDuplicate(getTextBrugernavn) == false) {
			opretLoginSuccess();
			OpretMedarbejderLogin crtLogin = new OpretMedarbejderLogin();
			crtLogin.opretBruger(getTextFornavn, getTextEfternavn, getTextBrugernavn, getTextPassword);
		}

		else {
			System.out.println("Houston, we have a problem! Ukendt fejlkode.");
		}
	}

}
