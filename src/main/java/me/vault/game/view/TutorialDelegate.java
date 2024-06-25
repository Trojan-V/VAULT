package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;


public final class TutorialDelegate implements Initializable
{
	//Buttons ----------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TutorialDelegate.class.getSimpleName());

	private static final String cssFilePath = "./css/style.css";

	//ImageViews -----------------------------------------------------------------------------------------------------------

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String TUTORIAL_VIEW_FXML = "tutorial.fxml";

	private static final Scene TUTORIAL_MENU_SCENE = ResourceLoader.loadScene(TutorialDelegate.class, TUTORIAL_VIEW_FXML);

	@FXML
	private Button continueButton;

	//Texts -----------------------------------------------------------------------------------------------------------
	@FXML
	private Button backButton;

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView backButtonBackground;

	@FXML
	private Text tutorialIntroductionText;

	@FXML
	private Text tutorialCityText;

	@FXML
	private Text tutorialArtefactsText;

	@FXML
	private Text tutorialFactionsText;

	//TabPane ----------------------------------------------------------------------------------------------------------
	@FXML
	private Text tutorialMissionsText;

	@FXML
	private Text tutorialFightsText;

	@FXML
	private Text continueButtonText;

	@FXML
	private Text backButtonText;

	@FXML
	private TabPane tutorialTabPane;


	public static void show (final Stage stage)
	{
		ViewUtil.show(GameApplication.getStage(), TUTORIAL_MENU_SCENE, TutorialDelegate.class);
	}


	//Actions ----------------------------------------------------------------------------------------------------------
	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}

	}


	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.BLACK);
			PrologueDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonColor(this.continueButtonText, Color.BLACK);
			CityDelegate.show(GameApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		ViewUtil.setText(this.tutorialIntroductionText, StringConstants.tutorialIntroduction);
		ViewUtil.setText(this.tutorialCityText, StringConstants.tutorialCity);
		ViewUtil.setText(this.tutorialArtefactsText, StringConstants.tutorialArtifacts);
		ViewUtil.setText(this.tutorialFactionsText, StringConstants.tutorialFactsions);
		ViewUtil.setText(this.tutorialMissionsText, StringConstants.tutorialMissions);
		ViewUtil.setText(this.tutorialFightsText, StringConstants.tutorialFights);
		ViewUtil.setTabPaneStyle(this.tutorialTabPane, TAB_PANE_STYLE);

	}

}
