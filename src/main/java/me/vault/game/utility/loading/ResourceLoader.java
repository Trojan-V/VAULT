package me.vault.game.utility.loading;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.vault.game.model.arena.*;
import me.vault.game.model.player.Player;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.vault.game.utility.constant.GameBoardConstants.*;
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
	 * @param <T>              The datatype of the class instance. No boundaries, as there's no class that bundles all
	 *                         classes
	 *                         that can be scenes to one datatype.
	 * @param clazz            The class that corresponds to the view (fxml).
	 * @param fxmlResourcePath The path from which the resource (the scene) is loaded.
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

	public static List<File> collectFilesWithSpecifiedEnding (final String directoryPath, String fileEnding)
	{
		final File[] allFiles = getDirectory(directoryPath).listFiles();
		List<File> validFiles = new ArrayList<>();

		for (File file: allFiles)
		{
			if (file.getName().endsWith(fileEnding))
			{
				validFiles.add(file);
			}
		}
		return validFiles;
	}

	public static List<File> collectFilesContaining (final String directoryPath, String pattern)
	{
		final File[] allFiles = getDirectory(directoryPath).listFiles();
		List<File> validFiles = new ArrayList<>();

		for (File file: allFiles)
		{
			if (file.getName().contains(pattern))
			{
				validFiles.add(file);
			}
		}
		return validFiles;
	}

	public static File getFile (final String directoryPath, String fileName)
	{
		final File[] files = getDirectory(directoryPath).listFiles();

		for (File currentFile: files)
		{
			if (currentFile.getName().equals(fileName))
			{
				return currentFile;
			}
		}
		return null;
	}


	public static Tile[][] createGameBoardFromFile (final String filePath)
	{
		final Tile[][] gameBoard = new Tile[GAME_BOARD_ROW_COUNT][GAME_BOARD_COLUMN_COUNT];

		try (
			final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),
				StandardCharsets.UTF_8)))
		{
			for (int row = 0; row < GAME_BOARD_ROW_COUNT; row++)
			{
				final String line = reader.readLine();
				if (line.length() != GAME_BOARD_ROW_COUNT)
				{
					throw new RuntimeException(); // TODO: EIGENE EXCEPTION
				}

				final char[] charArray = line.toCharArray();
				for (int column = 0; column < GAME_BOARD_COLUMN_COUNT; column++)
				{
					// TODO: bundle these classes into an enum or sth
					switch (charArray[column])
					{
						case OBSTACLE_TILE ->
							gameBoard[column][row] = new Tile(new Position(column, row), new BlockedTileAppearance());
						case RESOURCE_TILE ->
							gameBoard[column][row] = new Tile(new Position(column, row), new ResourceTileAppearance());
						case ARENA_TILE -> gameBoard[column][row] = new Tile(new Position(column, row),
							new ArenaStartTileAppearance());
						case MISSION_FINISH_TILE -> gameBoard[column][row] = new Tile(new Position(column, row),
							new MissionFinishTileAppearance());
						case PLAYER_START_TILE -> gameBoard[column][row] = new Tile(new Position(column, row),
							Player.getInstance());
						// any char besides the preceding reserved ones are accepted as placeholders.
						default -> gameBoard[column][row] =
							new Tile(new Position(column, row), new PlaceholderTileAppearance());
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
