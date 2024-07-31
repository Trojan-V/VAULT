package me.vault.game.view.newgame;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import me.vault.game.GameApplication;
import me.vault.game.utility.Config;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.interfaces.constant.TutorialConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.GameConstants.TAB_PANE_STYLE;


/**
 * This class acts as the controller and view for the tutorial (scene).
 * <br>
 * The class provides methods to display the tutorial {@link TutorialDelegate#show()} as well as methods for the
 * player to interact with the application {@link TutorialDelegate#click(MouseEvent)}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 30.04.2024
 */
public final class TutorialDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TutorialDelegate.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String TUTORIAL_VIEW_FXML = "tutorial.fxml";


	/**
	 * {@link Button} that provides the player with the ability to continue to the city.
	 */
	@FXML
	private Button continueButton;


	/**
	 * {@link Button} that provides the player with the ability to go back to the prolog.
	 */
	@FXML
	private Button backButton;


	/**
	 * {@link Text} that is shown in the introduction tab of the tutorial.
	 */
	@FXML
	private Text tutorialIntroductionText;


	/**
	 * {@link Text} that is shown in the city tab of the tutorial.
	 */
	@FXML
	private Text tutorialCityText;


	/**
	 * {@link Text} that is shown in the artefacts tab of the tutorial.
	 */
	@FXML
	private Text tutorialArtefactsText;


	/**
	 * {@link Text} that is shown in the factions tab of the tutorial.
	 */
	@FXML
	private Text tutorialFactionsText;


	/**
	 * {@link Text} that is shown in the missions tab of the tutorial.
	 */
	@FXML
	private Text tutorialMissionsText;


	/**
	 * {@link Text} that is shown in the fights tab of the tutorial.
	 */
	@FXML
	private Text tutorialFightsText;


	/**
	 * {@link TabPane} that contains all the tutorial tabs.
	 */
	@FXML
	private TabPane tutorialTabPane;


	/**
	 * Calls a method to display the content stored in {@link TutorialDelegate#TUTORIAL_VIEW_FXML} and initialized
	 * by {@link TutorialDelegate#initialize(URL, ResourceBundle)} on the main stage
	 * of this application ({@link GameApplication#getStage()}).
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized tutorial is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(TutorialDelegate.class, TUTORIAL_VIEW_FXML), TutorialDelegate.class);
	}


	/**
	 * Handles the button action "click" that is defined in the FXML-File.
	 * <br>
	 * <br>
	 * The method differentiates between different action that can be triggered by clicking on the different buttons
	 * of the scene.
	 * <br>
	 * <br>
	 * The actions that are triggered by their respective {@link Button} are listed below:
	 * <br>
	 * If the {@link TutorialDelegate#backButton} is clicked, the prolog is shown.
	 * <br>
	 * If the {@link TutorialDelegate#continueButton} is clicked, the config file is updated and the city is shown.
	 *
	 * @param mouseEvent The MouseEvent that determines the triggered action(s)
	 *
	 * @precondition The tutorial (scene) has to be displayed on the active stage.
	 * @postcondition The specified actions as described by this documentation are executed.
	 */
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
		//sets the texts from the tutorial tab pane from the StringConstants interface
		ViewUtil.setText(this.tutorialIntroductionText, TutorialConstants.TUTORIAL_INTRODUCTION);
		ViewUtil.setText(this.tutorialCityText, TutorialConstants.TUTORIAL_CITY);
		ViewUtil.setText(this.tutorialArtefactsText, TutorialConstants.TUTORIAL_ARTIFACTS);
		ViewUtil.setText(this.tutorialFactionsText, TutorialConstants.TUTORIAL_FACTIONS);
		ViewUtil.setText(this.tutorialMissionsText, TutorialConstants.TUTORIAL_MISSIONS);
		ViewUtil.setText(this.tutorialFightsText, TutorialConstants.TUTORIAL_FIGHTS);

		//sets the style for the tutorial tab pane
		ViewUtil.setTabPaneStyle(this.tutorialTabPane, TAB_PANE_STYLE);

	}

}
