package me.vault.game.utility.loading;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.vault.game.model.arena.Blocked;
import me.vault.game.model.arena.GameBoardConstants;
import me.vault.game.model.arena.Placeholder;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.mission.AccessibleTile;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.mission.Obstacle;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.vault.game.utility.logging.ILogger.Level.ERROR;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * This class is a utility class that provides methods to load images and scenes.
 * <br>
 * After the loading process is complete, an instance of a Java object is returned to the method invoker.
 * This instance can be used to give JavaFX the proper data structure that it requires to load the image or scene.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see MetaDataImage
 * @see Scene
 * @since 19.06.2024
 */
public final class ResourceLoader
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ResourceLoader.class.getSimpleName());


	/**
	 * The message which is printed into the console if the image couldn't be loaded.
	 */
	private static final String IMAGE_NOT_LOADED_MSG = "The image-resource \"{0}\" couldn't load.";


	/**
	 * The message which is printed into the console if the scene couldn't be loaded.
	 */
	private static final String SCENE_NOT_LOADED_MSG = "The scene-resource \"{0}\" couldn't load.";


	private static final String TILE = "Tile";


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private ResourceLoader () {}


	/**
	 * Loads an image from the supplied resourcePath.
	 *
	 * @param resourcePath The path from which the resource (the image) is loaded.
	 *
	 * @return An instance of {@link MetaDataImage}.
	 */
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


	/**
	 * Loads a scene from the supplied fxmlResourcePath.
	 * <br>
	 * The class is required to be provided to find the path to the view by using {@link Class#getResource(String)}.
	 *
	 * @param <T>              The datatype of the class instance. No boundaries, as there's no class that bundles all classes
	 *                         that can be scenes to one datatype.
	 * @param clazz            The class that corresponds to the view (fxml).
	 * @param fxmlResourcePath The path from which the resource (the scene) is loaded.
	 *
	 * @return An instance of {@link Scene}.
	 */
	public static <T> Scene loadScene (final Class<T> clazz, final String fxmlResourcePath)
	{

		try
		{
			final Object x = clazz.getResource(fxmlResourcePath);
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


	/**
	 * Returns a new instance of {@link File} for the provided path.
	 *
	 * @param filePath The path of the file.
	 *
	 * @return An instance {@link File}.
	 */
	public static File getDirectory (final String filePath)
	{
		return new File(filePath);
	}


	/**
	 * Collects all files in the supplied directory and returns them as a {@link List}.
	 *
	 * @param directoryPath The path to the directory.
	 *
	 * @return The {@link List} of files.
	 */
	public static List<File> collectFiles (final String directoryPath)
	{
		final File[] files = getDirectory(directoryPath).listFiles();
		if (files == null)
		{
			return new ArrayList<>();
		}

		return new ArrayList<>(List.of(files));
	}


	public static MapObject[][] readMapFile (final String filePath)
	{
		final char accessibleTileChar = 'n';
		final char obstacleTileChar = 'h';
		final MapObject[][] mapObjectArray = new MapObject[12][12];

		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)))
		{
			for (int i = 0; i < 12; i++)
			{
				final String line = reader.readLine();
				if (line.length() != 12)
				{
					throw new RuntimeException(); // TODO: EIGENE EXCEPTION
				}
				final char[] charArray = line.toCharArray(); // TODO: char[] laenge ueberpruefen
				for (int j = 0; j < 12; j++)
				{
					if (charArray[j] == accessibleTileChar)
					{
						mapObjectArray[i][j] = new AccessibleTile();
					}
					else if (charArray[j] == obstacleTileChar)
					{
						mapObjectArray[i][j] = new Obstacle();
					}
				}
			}
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
		return mapObjectArray;
	}


	public static Tile[][] createGameBoardFromFile (final String filePath)
	{
		final char accessibleTileChar = 'n';
		final char obstacleTileChar = 'h';


		final Tile[][] gameBoard =
			new Tile[GameBoardConstants.DEFAULT_NUBER_OF_ROWS][GameBoardConstants.DEFAULT_NUBER_OF_COLUMS];

		try (
			final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),
				StandardCharsets.UTF_8)))
		{
			for (int i = 0; i < GameBoardConstants.DEFAULT_NUBER_OF_ROWS; i++)
			{
				final String line = reader.readLine();
				if (line.length() != GameBoardConstants.DEFAULT_NUBER_OF_ROWS)
				{
					throw new RuntimeException(); // TODO: EIGENE EXCEPTION
				}
				final char[] charArray = line.toCharArray(); // TODO: char[] laenge ueberpruefen
				for (int j = 0; j < GameBoardConstants.DEFAULT_NUBER_OF_COLUMS; j++)
				{
					if (charArray[j] == accessibleTileChar)
					{
						gameBoard[i][j] = new Tile(TILE + i + j, i, j, new Placeholder());
					}
					else if (charArray[j] == obstacleTileChar)
					{
						gameBoard[i][j] = new Tile(TILE + i + j, i, j, new Blocked());
					}
				}
			}
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
		return gameBoard;
	}

}
