package me.vault.game.view;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.File;
import java.text.MessageFormat;

import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@link FileChooserDelegate} is responsible for the display (view) of the dialog that appears, when a user
 * wants to load a game from a save(file).
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see FileChooser
 * @since 30.07.2024
 */
public final class FileChooserDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(FileChooserDelegate.class.getSimpleName());

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link ExitGameDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "FileChooserDelegate'{'fileChooser={0}'}'";

	/**
	 * The name of the window, which is added to the {@link FileChooser} when displayed.
	 */
	private static final String FILE_CHOOSER_TITLE = "Choose a game file to load";


	/**
	 * The {@link FileChooser} object for the user to choose a file
	 */
	private final FileChooser fileChooser;


	/**
	 * The constructor for the {@link FileChooserDelegate}.
	 * <br>
	 * It creates a new instance of the {@link FileChooserDelegate} class, with a new instance of {@link FileChooser}
	 * that has a specified initial path and the title from {@link FileChooserDelegate#FILE_CHOOSER_TITLE}.
	 *
	 * @param initialFolderFilePath Path to the directory that is shown, when the file chooser is called.
	 *
	 * @precondition the initialFolderFilePath has to point to a valid directory
	 * @postcondition a new FileChooserDelegate instance is created with a new FileChooser that has the specified
	 * initialDirectory, and the title {@link FileChooserDelegate#FILE_CHOOSER_TITLE}
	 */
	public FileChooserDelegate (final String initialFolderFilePath)
	{
		this.fileChooser = new FileChooser();
		this.fileChooser.setTitle(FILE_CHOOSER_TITLE);
		this.fileChooser.setInitialDirectory(ResourceLoader.getDirectory(initialFolderFilePath));
	}


	/**
	 * Displays the {@link FileChooserDelegate#fileChooser} on the main {@link Stage} and returns the file that the user selects.
	 *
	 * @return A {@link File} object, which represents the user selection in the file chooser.
	 *
	 * @precondition The method gets called and the main stage was already set.
	 * @postcondition The {@link FileChooserDelegate#fileChooser} on the main {@link Stage} and returns the selected path.
	 */
	public File show ()
	{
		final File chosenFile = this.fileChooser.showOpenDialog(GameApplication.getStage());
		LOGGER.logf(DEBUG, "Config file selected in file chooser: {0}", chosenFile);
		return chosenFile;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link FileChooserDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link FileChooserDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link FileChooserDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.fileChooser);
	}

}
