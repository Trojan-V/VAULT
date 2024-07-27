package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.io.IOException;
import java.text.MessageFormat;

import static me.vault.game.model.arena.Arena.State;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class ArenaFinishedDialogDelegate
{

	@FXML
	private Label resultLabel;

	@FXML
	private DialogPane upgradeDialogPane;

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArenaFinishedDialogDelegate.class.getSimpleName());

	private static final String RESULT_LABEL_PATTERN = "You have {0}.";

	private static final String WINDOW_TITLE = "It's finally over...";

	private static final String FXML_FILENAME = "arenaFinishedDialog.fxml";

	private static final Stage STAGE = new Stage();

	private State state = State.RUNNING;


	static
	{
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.setResizable(false);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}


	public static void show (final State arenaState)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(FXML_FILENAME));
			final Parent root = fxmlLoader.load();

			final ArenaFinishedDialogDelegate dialogDelegate = fxmlLoader.getController();
			dialogDelegate.setState(arenaState);
			dialogDelegate.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, "Failed to display ArenaFinishedDialogDelegate with state: ", arenaState.toString());
		}
	}


	private void show (final Scene scene)
	{
		STAGE.setScene(scene);
		STAGE.showAndWait();
	}


	private void setState (final State arenaState)
	{
		this.state = arenaState;
		this.resultLabel.setText(MessageFormat.format(RESULT_LABEL_PATTERN, arenaState.toString()));
	}


	public State getState ()
	{
		return this.state;
	}


	@FXML
	void onContinue (final ActionEvent ignored)
	{
		STAGE.close();
		CityDelegate.show(GameApplication.getStage());
	}

}
