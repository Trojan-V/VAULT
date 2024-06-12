package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.VaultApplication;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.*;
import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class MainMenuDelegate implements Initializable
{
	// Buttons ------------------------------------------------------------------------------------------------------------------

	/**
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(MainMenuDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String MAIN_MENU_VIEW_FXML = "mainMenu.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, MAIN_MENU_VIEW_FXML);

	@FXML
	private Button continueButton;

	@FXML
	private Button newGameButton;

	@FXML
	private Button loadGameButton;

	//ImageViews ------------------------------------------------------------------------------------------------------------
	@FXML
	private Button settingsButton;

	@FXML
	private Button exitGameButton;

	@FXML
	private Button arenaButton;

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView newGameButtonBackground;

	@FXML
	private ImageView loadGameButtonBackground;

	// Texts -------------------------------------------------------------------------------------------------------------
	@FXML
	private ImageView settingsButtonBackground;

	@FXML
	private ImageView exitGameButtonBackground;

	@FXML
	private ImageView arenaButtonBackground;

	@FXML
	private Text continueButtonText;

	@FXML
	private Text newGameButtonText;

	@FXML
	private Text loadGameButtonText;

	// MenuItems --------------------------------------------------------------------------------------------------------
	@FXML
	private Text settingsButtonText;

	@FXML
	private Text exitGameButtonText;

	@FXML
	private Text arenaButtonText;

	@FXML
	private MenuItem continueMenuItem;

	@FXML
	private MenuItem newGameMenuItem;

	@FXML
	private MenuItem loadGameMenuItem;

	// Actions ------------------------------------------------------------------------------------------------------------
	@FXML
	private MenuItem settingsMenuItem;

	@FXML
	private MenuItem exitGameMenuItem;

	@FXML
	private MenuItem arenaMenuItem;


	public static void show (final Stage stage)
	{
		ViewUtils.show(SCENE, MainMenuDelegate.class);
	}


	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtils.setImage(this.newGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtils.setImage(this.loadGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtils.setImage(this.settingsButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtils.setImage(this.exitGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtils.setImage(this.arenaButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
	}


	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtils.setImage(this.newGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtils.setImage(this.loadGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtils.setImage(this.settingsButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtils.setImage(this.exitGameButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtils.setImage(this.arenaButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtils.setButtonColor(this.newGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtils.setButtonColor(this.settingsButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtils.setButtonColor(this.arenaButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setButtonColor(this.continueButtonText, Color.BLACK);
			CityView.show(VaultApplication.getStage()); // TODO: nur temporär zum testen
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtils.setButtonColor(this.newGameButtonText, Color.BLACK);
			DifficultyDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.BLACK);
			FileChooserView.show(VaultApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH, StringConstants.chooseGameFile);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtils.setButtonColor(this.settingsButtonText, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.BLACK);
			ExitGameDialogDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtils.setButtonColor(this.arenaButtonText, Color.BLACK);
		}
	}


	@FXML
	void buttonClickMenu (final ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(this.continueMenuItem))
		{

		}
		else if (actionEvent.getSource().equals(this.newGameMenuItem))
		{
			DifficultyDelegate.show(VaultApplication.getStage());
		}
		else if (actionEvent.getSource().equals(this.loadGameMenuItem))
		{
			FileChooserView.show(VaultApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH, StringConstants.chooseGameFile);
		}
		else if (actionEvent.getSource().equals(this.settingsMenuItem))
		{
			ViewUtils.showUpgradeDialog(DefenseArtifact.getInstance());
		}
		else if (actionEvent.getSource().equals(this.exitGameMenuItem))
		{
			ExitGameDialogDelegate.show();
		}
		else if (actionEvent.getSource().equals(this.arenaMenuItem))
		{

		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		ViewUtils.setImage(this.backgroundImageView, ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
		this.initializeContinue();
		this.initializeLoadGame();

	}


	@FXML
	private void initializeContinue ()
	{
		if (ResourceLoader.collectFiles(GAME_SAVE_FOLDER_FILE_PATH).isEmpty())
		{
			ViewUtils.setMenuItemInactive(this.continueMenuItem);
			ViewUtils.setButtonInactive(this.continueButton);
		}
	}


	@FXML
	private void initializeLoadGame ()
	{
		if (ResourceLoader.collectFiles(GAME_SAVE_FOLDER_FILE_PATH).isEmpty())
		{
			ViewUtils.setMenuItemInactive(this.loadGameMenuItem);
			ViewUtils.setButtonInactive(this.loadGameButton);
		}
	}

}
