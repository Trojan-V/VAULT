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


	private final FileChooser fileChooser;


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
