package me.vault.vaultgame.utility;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public final class ResourceLoader
{
	private static final String IMAGE_NOT_LOADED_MSG = "The image-resource \"{0}\" could not load.";


	private static final Logger LOGGER = Logger.getLogger(ResourceLoader.class.getName());


	private ResourceLoader () {}


	/**
	 * @param resourcePath
	 *
	 * @return
	 */
	public static Image loadImage (final String resourcePath)
	{
		try
		{
			// Converts the parsed URL-String into a URL-object and checks if the created object is null.
			final InputStream inputStream = new FileInputStream(resourcePath);

			// Creates an Image from the created URL-object.
			return new Image(inputStream);
		}
		catch (final FileNotFoundException ex)
		{
			// Logs the corrupted method call before logging the exception
			LOGGER.log(new LogRecord(Level.SEVERE, MessageFormat.format(IMAGE_NOT_LOADED_MSG, resourcePath)));
			LOGGER.log(new LogRecord(Level.SEVERE, ex.getMessage()));
			return null;
		}
	}
}
