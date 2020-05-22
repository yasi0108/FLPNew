package presentation;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.List;

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
import logic.LaanCheckTlf;
import logic.TFieldLogik;
import logic.TFieldLogik.TFieldResult;

public class OpretLaanUIv2 {

	DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField tlfTField, bilnavnTField, bilprisTField, udbetalingTField, laengdeTField, samletprisTField,
			renteTField;
	private Stage opretLaanStage;
	private Scene scene3;
	private Pane pane3;
	private String bilnavnGetText, bilprisGetText, udbetalingGetText, laanleangdeGetText, valgtBilNavn, cprnr,
			renteString, tlfGetText, samletPrisString;
	private Image ferrari;
	private ImageView ferraripic;
	private Button vaelgBilBtn, indsaetBil, opretLaanBtn, tlfSoegBtn, opretKundeBtn;
	private Label opretStatusLbl, lblbilMangler, lbltlfUgyldig;
	private double rente, samletPris;
	private boolean isClicked = false;

	GetBiler billogic = new GetBiler();
	List<Biler> getbiler = billogic.getAllBilerInfo();
	ObservableList<String> getbiler1 = FXCollections.observableArrayList();
	ListView<String> bilList1 = new ListView<>(getbiler1);

	public void start() {
		opretLaanStage = new Stage();
		opretLaanStage.setTitle("Ferrari l�nesystem");
		opretLaanStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget in som " + "username");

		pane3 = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		ferraripic = new ImageView();

		// Button assignments
		opretLaanBtn = new Button("Opret lånetilbud");
		vaelgBilBtn = new Button("Vælg Bil");
		indsaetBil = new Button("Indsæt bil i lån");
		tlfSoegBtn = new Button("Søg");
		opretKundeBtn = new Button("Opret ny kunde");
		// Textfield assignments
		tlfTField = new TextField();
		samletprisTField = new TextField();
		opretStatusLbl = new Label();
		bilnavnTField = new TextField();
		bilprisTField = new TextField();
		udbetalingTField = new TextField();
		laengdeTField = new TextField();
		// label assignments
		opretStatusLbl = new Label();
		lblbilMangler = new Label("Vælg venligst en bil!");
		lbltlfUgyldig = new Label("Beklager, denne bruger findes ikke i systemet!");

		// Textfield location
		tlfTField.relocate(320.0, 200.0);
		tlfTField.setPrefHeight(51.0);
		tlfTField.setPrefWidth(272.0);
		bilnavnTField.relocate(350, 300.0);
		bilnavnTField.setPrefHeight(35.0);
		bilnavnTField.setPrefWidth(272.0);
		bilprisTField.relocate(350, 350);
		bilprisTField.setPrefHeight(35.0);
		bilprisTField.setPrefWidth(272.0);
		udbetalingTField.relocate(350, 400);
		udbetalingTField.setPrefHeight(35.0);
		udbetalingTField.setPrefWidth(272.0);
		laengdeTField.relocate(350, 450);
		laengdeTField.setPrefHeight(35.0);
		laengdeTField.setPrefWidth(272.0);

		// Buttons location
		tlfSoegBtn.relocate(595, 200);
		vaelgBilBtn.relocate(630, 302.5);
		vaelgBilBtn.setPrefHeight(30.0);
		vaelgBilBtn.setPrefWidth(80);
		indsaetBil.setPrefWidth(200);
		indsaetBil.relocate(645, 502);

		bilList1.setPrefHeight(300);
		bilList1.setPrefWidth(250);
		bilList1.relocate(625, 200);
		opretLaanBtn.relocate(380, 550);
		opretKundeBtn.relocate(390, 400);

		// label location
		lgnNameLbl.relocate(800, 640);
		lblbilMangler.relocate(642, 535);
		lblbilMangler.setTextFill(Color.WHITE);

		// LOGO location
		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(305, 25);
		lbltlfUgyldig.relocate(250, 290);

		lbltlfUgyldig.setTextFill(Color.WHITE);

		// Setting prompt text style to only appear once a character has been inserted
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		laengdeTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		udbetalingTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilnavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		samletprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Setting prompt text
		samletprisTField.setPromptText("Samlet pris for l�netilbuddet");
		tlfTField.setPromptText("Indtast telefonnummer");
		laengdeTField.setPromptText("Lånets længde:");
		udbetalingTField.setPromptText("Udbetaling:");
		bilprisTField.setPromptText("Bilpris:");
		bilnavnTField.setPromptText("Bilnavn:");
		// Setting visibility
		bilnavnTField.setEditable(false);
		bilprisTField.setEditable(true);
		indsaetBil.setVisible(false);
		bilList1.setVisible(false);
		lblbilMangler.setVisible(false);
		opretKundeBtn.setVisible(false);
		bilnavnTField.setVisible(false);
		bilprisTField.setVisible(false);
		udbetalingTField.setVisible(false);
		laengdeTField.setVisible(false);
		vaelgBilBtn.setVisible(false);
		opretLaanBtn.setVisible(false);
		opretStatusLbl.setVisible(false);
		lbltlfUgyldig.setVisible(false);
		opretKundeBtn.setVisible(false);
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

		// Event handlers
		opretLaanBtn.setOnAction(e -> opretLaan());
		tlfSoegBtn.setOnAction(e -> tlfnrCheck());
		opretKundeBtn.setOnAction(e -> startKundeUI());

		vaelgBilBtn.setOnAction(e -> {
			bilList1.setVisible(true);
			indsaetBil.setVisible(true);
			vaelgBilBtn.setDisable(true);
			if (isClicked == false) {
				for (int i = 0; i < getbiler.size(); i++) {
					String bilnavnList = getbiler.get(i).getBilnavn();
					getbiler1.add(bilnavnList);
					isClicked = true;
				}
			}

		});

		indsaetBil.setOnAction(e -> {

			valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();
			// String �ge = valgtBilNavn();

			if (valgtBilNavn == null) {
				lblbilMangler.setVisible(true);
			} else {
				bilnavnTField.setText(valgtBilNavn);
				bilList1.setVisible(false);
				indsaetBil.setVisible(false);
				vaelgBilBtn.setDisable(false);
				lblbilMangler.setVisible(false);
				// int bilprisList = getbiler.get(i).getBilPris();
			}

		});

		// font size
		opretKundeBtn.setFont(new Font(24));
		lbltlfUgyldig.setFont(new Font(24));
		lblbilMangler.setFont(new Font(24));
		tlfSoegBtn.setFont(new Font(24));
		tlfTField.setFont(new Font(24));
		opretLaanBtn.setFont(new Font(24));
		laengdeTField.setFont(new Font(14));
		udbetalingTField.setFont(new Font(14));
		bilprisTField.setFont(new Font(14));
		bilnavnTField.setFont(new Font(14));
		vaelgBilBtn.setFont(new Font(12));
		indsaetBil.setFont(new Font(14));
		opretStatusLbl.setFont(new Font(24));

		// Set color to pane
		pane3.setStyle("-fx-background-color: #F40808");

		// Add to pane
		pane3.getChildren().addAll(opretLaanBtn, opretStatusLbl, ferraripic, tlfTField, lgnNameLbl, bilnavnTField,
				udbetalingTField, laengdeTField, bilprisTField, vaelgBilBtn, indsaetBil, bilList1, lblbilMangler,
				lbltlfUgyldig, tlfSoegBtn, opretKundeBtn, samletprisTField);

		// Show scene
		scene3 = new Scene(pane3, 950, 670);
		opretLaanStage.setScene(scene3);
		opretLaanStage.show();
	}

	private void opretLaan() {
		// add tlf
		bilnavnGetText = bilnavnTField.getText();
		bilprisGetText = bilprisTField.getText();
		udbetalingGetText = udbetalingTField.getText();
		laanleangdeGetText = laengdeTField.getText();

		checkTFields();
		getRente();
		renteString = Double.toString(rente);
		samletPrisString = Double.toString(samletPris);
		renteTField.setText(renteString);
		samletprisTField.setText(samletPrisString);

	}

	private void checkTFields() {
		TFieldLogik tflog = new TFieldLogik();
		TFieldResult tfCheck = tflog.TFieldCheck(tlfGetText, bilnavnGetText, bilprisGetText, udbetalingGetText,
				laanleangdeGetText, rente);
		opretStatusLbl.setTextFill(Color.WHITE);

		switch (tfCheck) {
		case bilnavnIsEmpty:
			opretStatusLbl.setText("Udfyld venligst bilnavn");
			opretStatusLbl.relocate(360, 500);
			break;
		case bilprisIsEmpty:
			opretStatusLbl.setText("Udfyld venligst bilpris");
			opretStatusLbl.relocate(365, 500);
			break;
		case udbetalingIsEmpty:
			opretStatusLbl.setText("Udfyld venligst udbetaling");
			opretStatusLbl.relocate(345, 500);
			break;
		case laanleangdeIsEmpty:
			opretStatusLbl.setText("Udfyld venligst l�nets l�ngde");
			opretStatusLbl.relocate(330, 500);
			break;
		case allIsEmpty:
			opretStatusLbl.setText("Udfyld venligst alle manglende felter");
			opretStatusLbl.relocate(285, 500);
			break;
		case Success:
			opretStatusLbl.setText("L�n Oprettet!");
			opretStatusLbl.relocate(410, 500);
			break;
		}
	}

	private void tlfnrCheck() {
		tlfGetText = tlfTField.getText();
		LaanCheckTlf tlfLogic = new LaanCheckTlf();
		if (tlfLogic.CheckTlfDB(tlfGetText) == true) {
			bilnavnTField.setVisible(true);
			bilprisTField.setVisible(true);
			udbetalingTField.setVisible(true);
			laengdeTField.setVisible(true);
			vaelgBilBtn.setVisible(true);
			lbltlfUgyldig.setVisible(false);
			opretKundeBtn.setVisible(false);
			opretLaanBtn.setVisible(true);
			opretStatusLbl.setVisible(true);
		}

		else if (tlfLogic.CheckTlfDB(tlfGetText) == false) {
			bilnavnTField.setVisible(false);
			bilprisTField.setVisible(false);
			udbetalingTField.setVisible(false);
			laengdeTField.setVisible(false);
			vaelgBilBtn.setVisible(false);
			opretLaanBtn.setVisible(false);
			lbltlfUgyldig.setVisible(true);
			opretKundeBtn.setVisible(true);
			opretStatusLbl.setVisible(false);

		}

	}

	private void startKundeUI() {
		OpretKundeUI kundeUI = new OpretKundeUI();
		kundeUI.start();
	}

	private void getRente() {
		LaanCheckTlf tlflogic = new LaanCheckTlf();
		GetKV getCPR = new GetKV();
		cprnr = tlflogic.getCPRNR(tlfGetText);
		rente = getCPR.getRente(cprnr);
		samletPris = getCPR.getSamletPris(cprnr, bilprisGetText);

	}

}
