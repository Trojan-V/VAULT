package me.vault.game;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.jvm.JvmArgument;
import me.vault.game.utility.jvm.JvmArgumentParser;
import me.vault.game.view.ExitGameDialogDelegate;
import me.vault.game.view.menu.MainMenuDelegate;

import static me.vault.game.utility.interfaces.constant.GameConstants.WINDOW_TITLE;


/**
 * The entry point of the VAULT game application. This class launches the GUI window the player will interact with to. The class which inherits from
 * {@link Application} is responsible for loading any {@code .fxml} files.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Application
 * @since 24.04.2024
 */
public class GameApplication extends Application
{


	/**
	 * The main {@link Stage} of the application on which the {@link Scene}s are displayed.
	 */
	private static Stage mainStage = null;


	/**
	 * Starts the JavaFX framework by invoking the launch method from the {@link Application} class. It isn't required to explicitly declare the main
	 * method, as the runtime environment will automatically invoke it anyway in a JavaFX project. Declaring it explicitly doesn't hurt though.
	 *
	 * @param args Contains the JVM arguments which have been passed into the program at the start.
	 *
	 * @precondition The args must be valid ({@link JvmArgument}).
	 * @postcondition The application is launched with the modifications given by the args.
	 */
	public static void main (final String[] args)
	{
		JvmArgumentParser.apply(args);
		launch();
	}


	/**
	 * Returns the {@link GameApplication#mainStage} of the application.
	 *
	 * @return mainStage of
	 *
	 * @precondition the {@link GameApplication#start(Stage)} has been called.
	 * @postcondition the current {@link GameApplication#mainStage} is returned.
	 */
	public static Stage getStage ()
	{
		return mainStage;
	}


	/**
	 * Loads the {@code .fxml} files which are located in {@code ./src/main/java/resources/me/vault/game} and starts the GUI powered by JavaFX.
	 *
	 * @param stage The {@link Stage} which will be displayed in the GUI window which pops up.
	 *
	 * @precondition stage != null.
	 * @postcondition The parameter stage is set as the {@link GameApplication#mainStage}. The stage is set
	 * non-resizable and the title is set to {@link GameConstants#WINDOW_TITLE}; The main menu is shown; An event
	 * Handler is added for the {@link Stage#setOnCloseRequest(EventHandler)} that shows the exit dialog upon
	 * receiving the close request.
	 */
	@Override
	public void start (final Stage stage)
	{
		mainStage = stage;
		mainStage.setResizable(false);
		mainStage.setTitle(WINDOW_TITLE);
		MainMenuDelegate.show();

		mainStage.setOnCloseRequest(evt -> {
			evt.consume();
			ExitGameDialogDelegate.show();
		});
	}

}