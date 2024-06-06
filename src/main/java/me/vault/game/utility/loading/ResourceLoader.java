package me.vault.game.utility.loading;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Objects;

import static me.vault.game.utility.logging.ILogger.Level.ERROR;


public final class ResourceLoader
{
	private static final ILogger LOGGER = new Logger(ResourceLoader.class.getSimpleName());


	private static final String IMAGE_NOT_LOADED_MSG = "The image-resource \"{0}\" couldn't load.";


	private static final String SCENE_NOT_LOADED_MSG = "The scene-resource \"{0}\" couldn't load.";


	private ResourceLoader () {}


	public static Image loadImage (final String resourcePath)
	{
		try
		{
			// Converts the parsed URL-String into a URL object and checks if the created object is null.
			final InputStream inputStream = new FileInputStream(resourcePath);

			// Creates an Image from the created URL object.
			return new Image(inputStream);
		}
		catch (final FileNotFoundException e)
		{
			// Logs the corrupted method call before logging the exception
			LOGGER.log(ERROR, MessageFormat.format(IMAGE_NOT_LOADED_MSG, resourcePath));
			LOGGER.log(ERROR, e.getMessage());
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
			return null;
		}
	}
}
