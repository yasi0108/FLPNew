package presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.GetKV;

public class adminUI {

	private Button laan, laaneanmodning, opretSealger;
	private Scene scene;
	private Pane pane;
	private Image ferrari;
	private ImageView ferraripic;
	private Stage adminUIStage;

	public void start() {
// pane, stage, pic
		adminUIStage = new Stage();
		pane = new Pane();
		pane.setStyle("-fx-background-color: #F40808");
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		ferraripic = new ImageView();
		ferraripic.setImage(ferrari);
		adminUIStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		scene = new Scene(pane, 755, 551);
		adminUIStage.setResizable(false);
		adminUIStage.setScene(scene);
		adminUIStage.show();

		// Button assignments
		laan = new Button("Opret lån");
		laaneanmodning = new Button("Låneanmodninger");
		opretSealger = new Button("Opret Sælger");

		// location
		ferraripic.relocate(223, 30);
		ferraripic.setFitWidth(300);
		ferraripic.setFitHeight(150);

		laan.setPrefHeight(62);
		laan.setPrefWidth(189);
		laan.relocate(274, 235);

		laaneanmodning.setPrefHeight(62);
		laaneanmodning.setPrefWidth(189);
		laaneanmodning.relocate(274, 317);

		opretSealger.setPrefHeight(62);
		opretSealger.setPrefWidth(189);
		opretSealger.relocate(274, 404);

		// getChildren
		pane.getChildren().addAll(ferraripic, laaneanmodning, opretSealger, laan);

		// Eventhandler
		opretSealger.setOnAction(e -> opretLoginUI());
		laan.setOnAction(e -> opretLaaneUI());

	}

	private void opretLoginUI() {
		OpretMedarbejderUI oprlogUI = new OpretMedarbejderUI();
		oprlogUI.start();
	}

	private void opretLaaneUI() {
		LaaneUI laan = new LaaneUI();
		laan.start();
	}

}
