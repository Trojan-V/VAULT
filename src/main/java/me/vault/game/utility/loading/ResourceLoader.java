package me.vault.game.utility.loading;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.vault.game.utility.logging.ILogger.Level.ERROR;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;

public final class ResourceLoader
{
	private static final ILogger LOGGER = new Logger(ResourceLoader.class.getSimpleName());

	private static final String IMAGE_NOT_LOADED_MSG = "The image-resource \"{0}\" couldn't load.";

	private static final String SCENE_NOT_LOADED_MSG = "The scene-resource \"{0}\" couldn't load.";


	private ResourceLoader () {}


	public static MetaDataImage loadImage (final String resourcePath)
	{
		try
		{
			return new MetaDataImage(new FileInputStream(resourcePath), new File(resourcePath));
		}
		catch (final FileNotFoundException e)
		{
			// Logs the corrupted method call before logging the exception
			LOGGER.log(WARNING, MessageFormat.format(IMAGE_NOT_LOADED_MSG, resourcePath));
			LOGGER.log(WARNING, e.getMessage());
			return null;
		}
	}


	public static <T> Scene loadScene (final Class<T> clazz, final String fxmlResourcePath)
	{
		try
		{
			return new Scene(FXMLLoader.load(Objects.requireNonNull(clazz.getResource(fxmlResourcePath))));
		}
		catch (final IOException e)
		{
			// Logs the corrupted method call before logging the exception
			LOGGER.log(ERROR, MessageFormat.format(SCENE_NOT_LOADED_MSG, fxmlResourcePath));
			LOGGER.log(ERROR, e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public static File getDirectory (final String filePath)
	{
		return new File(filePath);
	}


	public static ArrayList<File> collectFiles (final String filePath)
	{
		return new ArrayList<File>(List.of(new File(filePath).listFiles()));
	}

}
