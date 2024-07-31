package me.vault.game.utility;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.util.Objects;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.DISPLAY_FAILED_PATTERN;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.SHOWING_VIEW_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


/**
 * This class is a utility class that provides methods to manipulate different GUI elements.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 *
 * @version 1.0.0
 * @see Button
 * @see ImageView
 * @see TabPane
 * @see Text
 * @see Stage
 * @see Scene
 * @see MenuItem
 * @since 30.07.2024
 */
public final class ViewUtil
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ViewUtil.class.getSimpleName());


	/**
	 * As this class solely consists of static methods and therefore is a utility method, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of ArtifactController is created.
	 */
	private ViewUtil () {}


	/**
	 * Sets the text of a given {@link Text}.
	 *
	 * @param textElement the GUI element, whose text should be set.
	 * @param text the text that should be displayed by the GUI element.
	 *
	 * @precondition The textElement != null.
	 * @postcondition The text from the textElement equals the text from the parameter text.
	 */
	public static void setText (final Text textElement, final String text)
	{
		textElement.setText(text);
	}


	/**
	 * Sets the TabPane style of the given tabPane to the give style.
	 *
	 * @param tabPane The tab pane which style should be set.
	 * @param style The style that the tab pane should be set to.
	 *
	 * @precondition tabPane != null and style must be a valid style.
	 * @postcondition tabPane has the given style.
	 */
	public static void setTabPaneStyle (final TabPane tabPane, final String style)
	{
		tabPane.getStyleClass().add(style);
	}


	/**
	 * Disables a given {@link Button}.
	 *
	 * @param button The button that should be disabled.
	 *
	 * @precondition button != null.
	 * @postcondition The button is disabled.
	 */
	public static void disableButton (final Button button)
	{
		button.setDisable(true);
	}


	/**
	 * Disables a given {@link MenuItem}.
	 *
	 * @param menuItem The menu item that should be disabled.
	 *
	 * @precondition menuItem != null.
	 * @postcondition menuItem is disabled.
	 */
	public static void disableMenuItem (final MenuItem menuItem)
	{
		menuItem.setDisable(true);
	}


	/**
	 * Shows the given {@link Scene} on the given {@link Stage} and adds a log entry with the class that called the
	 * method.
	 *
	 * @param stage The {@link Stage} on which the Scene is displayed.
	 * @param scene The {@link Scene} to be displayed.
	 * @param clazz The class that called the method.
	 *
	 * @precondition The stage is != null, the scene is != null, and the class is != null;
	 * @postcondition The {@link GameConstants#BUTTON_LONG_CSS_FILE}-css file is added to the scene. The scene is
	 * displayed on the given stage and a log entry is created ({@link Logger#logf(ILogger.Level, String, Object...)}). If there's a
	 * {@link RuntimeException}, a corresponding log entry is also created.
	 */
	public static void show (final Stage stage, final Scene scene, final Class<?> clazz)
	{
		try
		{
			scene.getStylesheets().add(Objects.requireNonNull(GameApplication.class.getResource(GameConstants.BUTTON_LONG_CSS_FILE)).toExternalForm());
			stage.setScene(scene);
			stage.show();

			LOGGER.logf(DEBUG, SHOWING_VIEW_PATTERN, clazz.getSimpleName());
		}
		catch (final RuntimeException ex)
		{
			LOGGER.logf(ERROR, DISPLAY_FAILED_PATTERN, clazz.getSimpleName());
		}

	}

}
