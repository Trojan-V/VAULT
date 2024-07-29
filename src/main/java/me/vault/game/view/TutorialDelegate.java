package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.Config;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;


public final class TutorialDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TutorialDelegate.class.getSimpleName());

	private static final String cssFilePath = "./css/style.css";


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String TUTORIAL_VIEW_FXML = "tutorial.fxml";

	private static final Scene TUTORIAL_MENU_SCENE = ResourceLoader.loadScene(TutorialDelegate.class, TUTORIAL_VIEW_FXML);

	@FXML
	private Button continueButton;

	@FXML
	private Button backButton;

	@FXML
	private Text tutorialIntroductionText;

	@FXML
	private Text tutorialCityText;

	@FXML
	private Text tutorialArtefactsText;

	@FXML
	private Text tutorialFactionsText;

	@FXML
	private Text tutorialMissionsText;

	@FXML
	private Text tutorialFightsText;

	@FXML
	private TabPane tutorialTabPane;


	public static void show (final Stage stage)
	{
		ViewUtil.show(GameApplication.getStage(), TUTORIAL_MENU_SCENE, TutorialDelegate.class);
	}


	@FXML
	void click (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			PrologueDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			Config.getInstance().updateConfigFromModels();
			CityDelegate.show();
		}
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
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
