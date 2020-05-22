package presentation;

import java.text.DecimalFormat;

import java.text.ParsePosition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GetKV;
import logic.GetKV.kreditRating;
import logic.kundeCheckDuplicate;
import logic.opretKunde;

public class OpretKundeUI {

	DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField tlfTField;
	private TextField PostnrTField, ByTField, VejTField, HusnrTField, cprTField, mailTField, kundefornavnTField,
			kundeefternavnTField;
	private Button opretKundeBtn;
	private Stage opretKundeStage;
	private kundeCheckDuplicate kundelogic = new kundeCheckDuplicate();
	private String fornavnGetText, efternavnGetText, tlfGetText, postnrGetText, byGetText, vejGetText, husnrGetText,
			cprGetText, mailGetText, kv;
	private Label opretStatusLbl;
	private Scene scene4;
	private Pane pane4;
	private Image ferrari;
	private ImageView ferraripic;
	private kreditRating kreditVurdering;

	public void start() {
		opretKundeStage = new Stage();
		opretKundeStage.setTitle("Ferrari l�nesystem");
		opretKundeStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget in som " + "username");

		pane4 = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		pane4.setPrefHeight(670.0);
		ferraripic = new ImageView();

		// Button assignments
		opretKundeBtn = new Button("Opret Kunde!");

		// Textfield assignments
		kundefornavnTField = new TextField();
		kundeefternavnTField = new TextField();
		PostnrTField = new TextField();
		ByTField = new TextField();
		VejTField = new TextField();
		HusnrTField = new TextField();
		tlfTField = new TextField();
		cprTField = new TextField();
		mailTField = new TextField();
		// label assignments
		opretStatusLbl = new Label();
		// TextField Location
		kundefornavnTField.relocate(320.0, 195.0);
		kundefornavnTField.setPrefHeight(25.0);
		kundefornavnTField.setPrefWidth(321);
		kundeefternavnTField.relocate(320.0, 225.0);
		kundeefternavnTField.setPrefHeight(25.0);
		kundeefternavnTField.setPrefWidth(321.0);

		PostnrTField.relocate(320.0, 255.0);
		PostnrTField.setPrefHeight(25.0);
		PostnrTField.setPrefWidth(321.0);

		ByTField.setPrefWidth(321.0);
		ByTField.relocate(320.0, 285.0);
		ByTField.setPrefHeight(25.0);

		VejTField.setPrefWidth(321.0);
		VejTField.relocate(320.0, 315.0);
		VejTField.setPrefHeight(25.0);

		HusnrTField.setPrefWidth(321.0);
		HusnrTField.relocate(320.0, 345.0);
		HusnrTField.setPrefHeight(25.0);

		tlfTField.relocate(320.0, 375.0);
		tlfTField.setPrefHeight(25.0);
		tlfTField.setPrefWidth(321.0);

		cprTField.relocate(320.0, 405.0);
		cprTField.setPrefHeight(25.0);
		cprTField.setPrefWidth(321.0);

		mailTField.relocate(320.0, 435);
		mailTField.setPrefHeight(25.0);
		mailTField.setPrefWidth(321.0);
		// Button location

		opretKundeBtn.relocate(390, 550);
		// LOGO location
		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(305, 25);

		// Label location
		lgnNameLbl.setPrefHeight(17);
		lgnNameLbl.setPrefWidth(200);
		lgnNameLbl.relocate(750, 625);
		// Setting prompt text style to only appear once a character has been inserted
		mailTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		cprTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		PostnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		ByTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		VejTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		HusnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundefornavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundeefternavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		pane4.setStyle("-fx-background-color: #F40808");

		// Setting prompt text
		kundefornavnTField.setPromptText("Fornavn:");
		kundeefternavnTField.setPromptText("Efternavn:");
		mailTField.setPromptText("E-Mail:");
		cprTField.setPromptText("CPR-nr:");
		tlfTField.setPromptText("Tlf.nr:");
		PostnrTField.setPromptText("Postnr:");
		HusnrTField.setPromptText("Husnr:");
		VejTField.setPromptText("Vejnavn:");
		ByTField.setPromptText("By:");

		// Make TFields number only accept number inputs
		cprTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}

			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));

		tlfTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}

			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));

		// Font sizes
		opretStatusLbl.setFont(new Font(24));
		kundeefternavnTField.setFont(new Font(14));
		kundefornavnTField.setFont(new Font(14));
		opretKundeBtn.setFont(new Font(24));
		lgnNameLbl.setFont(new Font(12));
		mailTField.setFont(new Font(14));
		cprTField.setFont(new Font(14));
		tlfTField.setFont(new Font(14));
		PostnrTField.setFont(new Font(14));
		HusnrTField.setFont(new Font(14));
		VejTField.setFont(new Font(14));
		ByTField.setFont(new Font(14));

		// getChildren Add to pane
		pane4.getChildren().addAll(kundefornavnTField, kundeefternavnTField, PostnrTField, ByTField, VejTField,
				HusnrTField, tlfTField, cprTField, mailTField, opretKundeBtn, opretStatusLbl, ferraripic, lgnNameLbl);

		// Show scene
		scene4 = new Scene(pane4, 950, 670);
		opretKundeStage.setScene(scene4);
		opretKundeStage.show();

		// Event handlers
		opretKundeBtn.setOnAction(e -> opretKunde());

//		indsaetBil.setOnAction(e -> {
//			valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();
//		
//			if (bilList1.getSelectionModel().getSelectedItem().isEmpty()) {
//			} else {
//				bilnavnTField.setText(valgtBilNavn);
//				bilList1.setVisible(false);
//				indsaetBil.setVisible(false);
//				vaelgBil.setDisable(false);
//				//				int bilprisList = getbiler.get(i).getBilPris();
//			}
//
//		});
	}

	private void opretKunde() {
		fornavnGetText = kundefornavnTField.getText();
		efternavnGetText = kundeefternavnTField.getText();
		tlfGetText = tlfTField.getText();
		postnrGetText = PostnrTField.getText();
		byGetText = ByTField.getText();
		vejGetText = VejTField.getText();
		husnrGetText = HusnrTField.getText();
		cprGetText = cprTField.getText();
		mailGetText = mailTField.getText();

//		String getTlf = tlfTField.getText();
//        int getTextTlf = Integer.valueof(tlfTField.getText());
//        System.out.println(tlfGetText);
//		
		if (fieldsEmpty() == true) {
			kundeFail();

		} else if (cprTField.getText().length() != 10) {
			cprFail();
		} else if (kundelogic.KundeCheckDuplicate(cprGetText, tlfGetText) == true) {
			kundeDuplicate();
		}

		else {
			checkRating();
		}

	}

	private boolean fieldsEmpty() {
		if (fornavnGetText.isEmpty() || efternavnGetText.isEmpty() || tlfGetText.isEmpty() || postnrGetText.isEmpty()
				|| byGetText.isEmpty() || vejGetText.isEmpty() || husnrGetText.isEmpty() || cprGetText.isEmpty()
				|| mailGetText.isEmpty()) {
			return true;
		}
		return false;
	}

	private void cprFail() {
		opretStatusLbl.setText("Der skal vaare 10 CPR-cifre. Nuvaerende antal: " + cprTField.getText().length());
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(200, 490);
	}

	private void kundeSuccess() {
		opretKunde OpretKunde = new opretKunde();

		opretStatusLbl.setText("Kunde Oprettet!");
		opretStatusLbl.setTextFill(Color.LIGHTGREEN);
		opretStatusLbl.relocate(390.5, 490);
		OpretKunde.CreateKunde(fornavnGetText, efternavnGetText, tlfGetText, postnrGetText, byGetText, vejGetText,
				husnrGetText, cprGetText, mailGetText, kreditVurdering);
	}

	private void kundeDuplicate() {
		opretStatusLbl.setText("Bruger eksisterer allerede med valgte CPR og/eller tlfnr!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(190, 490);

	}

	private void kundeFail() {
		opretStatusLbl.setText("Udfyld venligst alle felter!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(345, 490);

	}

	private void kreditRatingFail() {
		opretStatusLbl.setText("Kundens kreditvaerdighed er under den tilladte graense!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(175, 490);
	}

	private void systemError() {
		opretStatusLbl.setText("Der opstod en fejl i systemet! Genstart venligst programmet.");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(150, 490);
	}

	public kreditRating checkRating() {

		GetKV getKV = new GetKV();
		kreditVurdering = getKV.getKreditvaerdighed(cprGetText);

		switch (kreditVurdering) {
		case A:
			kundeSuccess();
			System.out.println("Kunden er oprettet" + "\n" + "rating: A");
			break;
		case B:
			kundeSuccess();
			System.out.println("Kunden er oprettet" + "\n" + "rating: B");
			break;
		case C:
			kundeSuccess();
			System.out.println("Kunden er oprettet" + "\n" + "rating: C");
			break;
		case D:
			kreditRatingFail();
			System.out.println("Fejl: " + "\n" + "Kunden er rating: D");
			break;
		case error:
			System.out.println("major ERROR BOY");
			systemError();
			break;
		}
		System.out.println("Rating: " + kreditVurdering + " blev printet til DB!");
		return kreditVurdering;
	}

}
