package presentation;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.ArrayList;

import entity.Biler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GetBiler;
import logic.GetKV;
import logic.GetKV.kreditRating;
import logic.laanCheckDuplicate;
import logic.opretLaan;
/*
public class OpretLaanUI {

	DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField navnTField;
//	        private TextField adrTField;
	private TextField tlfTField;
	private TextField PostnrTField;
	private TextField ByTField;
	private TextField VejTField;
	private TextField HusnrTField;
	private TextField cprTField;
	private TextField mailTField;
	private TextField bilnavnTField;
	private TextField bilprisTField;
	private TextField udbetalingTField;
	private TextField laengdeTField;
	private Button opretLaanBtn;
	private Stage opretLaanStage;
	private laanCheckDuplicate laanlogic = new laanCheckDuplicate();
	private String fornavn;
//	private String efternavn;
	private String tlf;
	private String postnr;
	private String by;
	private String vej;
	private String husnr;
	private String cpr;
	private String mail;
	private String bilnavn;
	private String bilpris;
	private String udbetaling;
	private String laanleangde;
	private String valgtBilNavn;
	private Label opretStatusLbl;
	private Scene scene3;
	private Pane pane3;
	private Image ferrari;
	private ImageView ferraripic;
	private Button vaelgBil;
	private Button indsaetBil;
	kreditRating kreditVurdering;

	public void start() {
		opretLaanStage = new Stage();
		opretLaanStage.setTitle("Ferrari lånesystem");
		opretLaanStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget in som " + "username");

		pane3 = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		pane3.setPrefHeight(670.0);
		ferraripic = new ImageView();

		// Button assignments
		opretLaanBtn = new Button("Opret lånetilbud");
		vaelgBil = new Button("Vælg Bil");
		indsaetBil = new Button("Indsæt I lån");

		GetBiler billogic = new GetBiler();
		ArrayList<Biler> getbiler = billogic.getAllBilerInfo();
		ObservableList<String> getbiler1 = FXCollections.observableArrayList();
		ListView<String> bilList1 = new ListView<>(getbiler1);

		navnTField = new TextField();
		// adrTField = new TextField();
		PostnrTField = new TextField();
		ByTField = new TextField();
		VejTField = new TextField();
		HusnrTField = new TextField();
		tlfTField = new TextField();
		cprTField = new TextField();
		mailTField = new TextField();
		bilnavnTField = new TextField();
		bilprisTField = new TextField();
		udbetalingTField = new TextField();
		laengdeTField = new TextField();
		opretStatusLbl = new Label();
		navnTField.relocate(298.0, 185.0);
		navnTField.setPrefHeight(25.0);
		navnTField.setPrefWidth(321.0);
		PostnrTField.relocate(298.0, 210.0);
		PostnrTField.setPrefHeight(25.0);
		PostnrTField.setPrefWidth(321.0);
		ByTField.setPrefWidth(321.0);
		ByTField.relocate(298.0, 240.0);
		ByTField.setPrefHeight(25.0);
		VejTField.setPrefWidth(321.0);
		VejTField.relocate(298.0, 270.0);
		VejTField.setPrefHeight(25.0);
		HusnrTField.setPrefWidth(321.0);
		HusnrTField.relocate(298.0, 300.0);
		HusnrTField.setPrefHeight(25.0);
		tlfTField.relocate(298.0, 330.0);
		tlfTField.setPrefHeight(25.0);
		tlfTField.setPrefWidth(321.0);
		cprTField.relocate(298, 360.0);
		cprTField.setPrefHeight(25.0);
		cprTField.setPrefWidth(321.0);
		mailTField.relocate(298, 390);
		mailTField.setPrefHeight(25.0);
		mailTField.setPrefWidth(321.0);
		bilnavnTField.relocate(298, 420);
		bilnavnTField.setPrefHeight(25.0);
		bilnavnTField.setPrefWidth(321.0);
		bilprisTField.relocate(298, 450);
		bilprisTField.setPrefHeight(25.0);
		bilprisTField.setPrefWidth(321.0);
		udbetalingTField.relocate(298, 480);
		udbetalingTField.setPrefHeight(25.0);
		udbetalingTField.setPrefWidth(321.0);
		laengdeTField.relocate(298, 510);
		laengdeTField.setPrefHeight(25.0);
		laengdeTField.setPrefWidth(321.0);
		opretStatusLbl.setFont(new Font(24));
		opretLaanBtn.relocate(355, 600);
		vaelgBil.relocate(630, 422);
		indsaetBil.setPrefWidth(200);
		indsaetBil.relocate(645, 502);
		indsaetBil.setVisible(false);

		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(282, 25);

		bilList1.setPrefHeight(300);
		bilList1.setPrefWidth(250);
		//bilList1.relocate(0, 275);
		 bilList1.relocate(625, 200);
		bilList1.setVisible(false);

		//Setting prompt text style to only appear once a character has been inserted
		laengdeTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		udbetalingTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilnavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		mailTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		cprTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		PostnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		navnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		ByTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		VejTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		HusnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		pane3.setStyle("-fx-background-color: #ff2800");

		//Setting prompt text
		laengdeTField.setPromptText("Lånets længde:");
		udbetalingTField.setPromptText("Udbetaling:");
		bilprisTField.setPromptText("Bilpris:");
		bilnavnTField.setPromptText("Bilnavn:");
		mailTField.setPromptText("E-Mail:");
		cprTField.setPromptText("CPR-nr:");
		tlfTField.setPromptText("Tlf.nr:");
		PostnrTField.setPromptText("Postnr:");
		HusnrTField.setPromptText("Husnr:");
		VejTField.setPromptText("Vejnavn:");
		ByTField.setPromptText("By:");
		navnTField.setPromptText("Navn:");

		lgnNameLbl.setPrefHeight(17);
		lgnNameLbl.setPrefWidth(200);
		lgnNameLbl.relocate(750, 625);

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

		bilprisTField.setTextFormatter(new TextFormatter<>(c -> {
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

		udbetalingTField.setTextFormatter(new TextFormatter<>(c -> {
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

		laengdeTField.setTextFormatter(new TextFormatter<>(c -> {
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
		vaelgBil.setFont(new Font(12));
		opretLaanBtn.setFont(new Font(24));
		lgnNameLbl.setFont(new Font(12));
		laengdeTField.setFont(new Font(14));
		udbetalingTField.setFont(new Font(14));
		bilprisTField.setFont(new Font(14));
		bilnavnTField.setFont(new Font(14));
		mailTField.setFont(new Font(14));
		cprTField.setFont(new Font(14));
		tlfTField.setFont(new Font(14));
		PostnrTField.setFont(new Font(14));
		HusnrTField.setFont(new Font(14));
		VejTField.setFont(new Font(14));
		ByTField.setFont(new Font(14));
		indsaetBil.setFont(new Font(14));
		
		
		// Add to pane
		pane3.getChildren().addAll(navnTField, PostnrTField, ByTField, VejTField, HusnrTField, tlfTField,
				cprTField, mailTField, bilnavnTField, vaelgBil, bilprisTField, udbetalingTField, laengdeTField,
				opretLaanBtn, bilList1, opretStatusLbl, ferraripic, lgnNameLbl, indsaetBil);

		// Show scene
		scene3 = new Scene(pane3, 950, 670);
		opretLaanStage.setScene(scene3);
		opretLaanStage.show();

		// Event handlers
		opretLaanBtn.setOnAction(e -> opretLaan());
		vaelgBil.setOnAction(e -> {
			bilList1.setVisible(true);
			indsaetBil.setVisible(true);
			vaelgBil.setDisable(true);
			for (int i = 0; i < getbiler.size(); i++) {
		        
				int bilid = getbiler.get(i).getBilId();
				String bilidString = Integer.toString(bilid);
				String bilnavnList = getbiler.get(i).getBilnavn();
				getbiler1.add(bilidString);
				getbiler1.add(bilnavnList);

			}

		});
		indsaetBil.setOnAction(e -> {
			valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();
			if (bilList1.getSelectionModel().getSelectedItem().isEmpty()) {
			} else {
			System.out.println(bilList1.getSelectionModel().getSelectedIndex());	
				
				bilnavnTField.setText(valgtBilNavn);
				bilList1.setVisible(false);
				indsaetBil.setVisible(false);
				vaelgBil.setDisable(false);
				//				int bilprisList = getbiler.get(i).getBilPris();
			}

		});
	}

	private void opretLaan() {
		fornavn = navnTField.getText();
		tlf = tlfTField.getText();
		postnr = PostnrTField.getText();
		by = ByTField.getText();
		vej = VejTField.getText();
		husnr = HusnrTField.getText();
		cpr = cprTField.getText();
		mail = mailTField.getText();
		bilnavn = bilnavnTField.getText();
		bilpris = bilprisTField.getText();
		udbetaling = udbetalingTField.getText();
		laanleangde = laengdeTField.getText();

		if (fieldsEmpty() == true) {
			laanFail();

		} else if (cprTField.getText().length() != 10) {
			cprFail();
		} else if (laanlogic.LaanCheckDuplicate(cpr, tlf) == true) {
			laanDuplicate();
		}

		else {
			checkRating();
		}
	}

	private boolean fieldsEmpty() {
		if (fornavn.isEmpty() || tlf.isEmpty() || postnr.isEmpty() || by.isEmpty()
				|| vej.isEmpty() || husnr.isEmpty() || cpr.isEmpty() || mail.isEmpty()
				|| bilnavn.isEmpty() || bilnavn.isEmpty() || bilpris.isEmpty()
				|| udbetaling.isEmpty() || laanleangde.isEmpty()) {
			return true;
		}
		return false;
	}

	private void laanSuccess() {
		opretLaan OpretLaan = new opretLaan();

		opretStatusLbl.setText("Lån successfuldt oprettet!");
		opretStatusLbl.setTextFill(Color.LIGHTGREEN);
		opretStatusLbl.relocate(323, 553);
		OpretLaan.CreateLaan(fornavn, tlf, postnr, by, vej, husnr, cpr,
				mail, bilnavn, bilpris, udbetaling, laanleangde, kreditVurdering);
	}

	private void cprFail() {
		opretStatusLbl.setText("Der skal vaare 10 CPR-cifre. Nuværende antal: " + cprTField.getText().length());
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(200, 553);
	}

	private void laanDuplicate() {
		opretStatusLbl.setText("Bruger eksisterer allerede med valgte CPR og/eller tlfnr!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(152, 553);

	}

	private void laanFail() {
		opretStatusLbl.setText("Udfyld venligst alle felter!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(325, 553);

	}

	private void kreditRatingFail() {
		opretStatusLbl.setText("Kundens kreditvaerdighed er under den tilladte graense!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(155, 553);
	}

	private void systemError() {
		opretStatusLbl.setText("Der opstod en fejl i systemet! Genstart venligst programmet.");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(150, 553);
	}

	private kreditRating checkRating() {
		GetKV getKV = new GetKV();
		kreditVurdering = getKV.getKreditvaerdighed(cpr);

		switch (kreditVurdering) {
		case A:
			laanSuccess();
			System.out.println("Kunden er oprettet" + "\n" + "rating: A");
			break;
		case B:
			laanSuccess();
			System.out.println("Kunden er oprettet" + "\n" + "rating: B");
			break;
		case C:
			laanSuccess();
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

}*/
