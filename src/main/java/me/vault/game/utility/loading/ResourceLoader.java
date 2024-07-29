package me.vault.game.utility.loading;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import me.vault.game.model.arena.Position;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.gameboard.tiles.*;
import me.vault.game.model.player.Player;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.vault.game.utility.constant.GameBoardConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * This class is a utility class that provides methods to load Resources such as images and scenes.
 * <br>
 * After the loading process is complete, an instance of a Java object is returned to the method invoker.
 * This instance can be used to give JavaFX the proper data structure that it requires to load the image or scene.
 *
 * @author Vincent Wolf, Timothy Hoegen-Jupp
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
	 *
	 * @precondition
	 * @postcondition the specified Image is returned; null if the resourcePath is not valid
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
	 *
	 * @precondition The specified resource Path has to point to a valid FXML-File (not null)
	 * @postcondition The specified Scene is returned
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
	 * @param directoryPath The path of the file.
	 * @return An instance {@link File}.
	 *
	 * @precondition The directoryPath has to point to a valid directory (not null)
	 * @postcondition The directory is returned as a {@link File} Object
	 */
	public static File getDirectory (final String directoryPath)
	{
		return new File(directoryPath);
	}


	/**
	 * Collects all files in the supplied directory and returns them as a {@link List}.
	 *
	 * @param directoryPath The path to the directory.
	 * @return The {@link List} of files.
	 *
	 * @precondition the directoryPath has to point to a valid directory (not null)
	 * @postcondition all files in the directory are returned
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


	/**
	 * Collects all file in the supplied directory that have the specified file-name ending and returns them as a
	 * {@link List}.
	 *
	 * @param directoryPath The path to the directory
	 * @param fileEnding The ending of the files that should be returned
	 * @return A {@link List} of all files that have the specified ending
	 *
	 * @precondition The directoryPath has to point to a valid directory (not null) and the fileEnding cannot be null
	 * @postcondition All files with the specified ending are returned
	 */
	public static List<File> collectFilesWithSpecifiedEnding (final String directoryPath, String fileEnding)
	{
		final File[] allFiles = getDirectory(directoryPath).listFiles();
		List<File> validFiles = new ArrayList<>();

		//checks the file ending of all files in the directory.
		for (File file: allFiles)
		{
			if (file.getName().endsWith(fileEnding))
			{
				validFiles.add(file);
			}
		}
		return validFiles;
	}


	/**
	 * Collects all files in the supplied directory that contain the specified pattern in the file name and returns
	 * them as a {@link List}.
	 *
	 * @param directoryPath The path to the directory
	 * @param pattern The pattern that should be contained within the filename
	 * @return A {@link List} containing all files with the specified pattern in their filename
	 *
	 * @precondition The directoryPath has to point to a valid directory (not null) and the specified pattern cannot
	 * be null
	 * @postcondition All files with the specified pattern in the filename are returned
	 */
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


	/**
	 * Retuns the specified {@link File}.
	 *
	 * @param directoryPath The path to the directory
	 * @param fileName The name of the desired File
	 * @return The File with the specified fileName from the specified directory
	 *
	 * @precondition The directoryPath has to point to a valid directory (not null).
	 * @postcondition The File with the specified fileName; null if there is no file with the corresponding fileName
	 */
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


	/**
	 * Creates a Tile-Array (Gameboard) from the specified File.
	 * <br>
	 * The file has to follow certain rules in order for this method to be able to properly read it. The number of
	 * lines in the file has to match {@link me.vault.game.utility.constant.GameBoardConstants#GAME_BOARD_ROW_COUNT}
	 * and the number of characters in each line have to match
	 * {@link me.vault.game.utility.constant.GameBoardConstants#GAME_BOARD_COLUMN_COUNT}. Furthermore, the file has
	 * to contain valid Tile representations such as
	 * {@link me.vault.game.utility.constant.GameBoardConstants#OBSTACLE_TILE}.
	 *
	 * @param filePath The path to the file from which the Tile-Array should be constructed
	 * @return TileArray that represents the content of the specified file
	 *
	 * @see me.vault.game.utility.constant.GameBoardConstants
	 * @see BufferedReader
	 * @see Tile
	 *
	 * @precondition The filePath has to point to a vaild file (not null) that is the right size and contains the
	 * allowed characters and does not exceed the UTF-8 character range
	 * @postcondition The Tile-Array representation of the file content is returned with the character-representations
	 * having been exchanged for the Tile-Objects
	 */
	public static Tile[][] createTileArrayFromFile (final String filePath)
	{
		final Tile[][] gameBoard = new Tile[GAME_BOARD_ROW_COUNT][GAME_BOARD_COLUMN_COUNT];
		final BufferedReader reader = createBufferedReaderFromFile(filePath);

		//Throws an error if the number of lines in the file does not match the number of rows of the Gameboard
		if (getNumberOfLinesInFile(filePath) != GAME_BOARD_ROW_COUNT)
		{
			throw new RuntimeException(); //TODO: Eigene Exception
		}


		for (int row = 0; row < GAME_BOARD_ROW_COUNT; row++)
		{
			final String line;

			try
			{
				line = reader.readLine();
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}

			//Throws an exception if the number of characters in a line does not match the number of columns of the
			// Gameboard
			if (line.length() != GAME_BOARD_ROW_COUNT)
			{
				throw new RuntimeException(); // TODO: EIGENE EXCEPTION
			}

			final char[] charArray = line.toCharArray();

			//goes through each column of the gameboard
			for (int column = 0; column < GAME_BOARD_COLUMN_COUNT; column++)
			{
				// TODO: bundle these classes into an enum or sth
				//determines the tile that is added to the gameboard from the file with the help of characters
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
						new Tile(new Position(column, row), new AccessibleTileAppearance());
				}
			}
		}
		return gameBoard;
	}


	/**
	 * Determines and returns the number of Lines that are in a given File.
	 *
	 * @param filePath The path to the file
	 * @return number of lines in the specified file
	 *
	 * @precondition filePath must point to a valid file (not null)
	 * @postcondition number of lines in the file are returned
	 */
	public static int getNumberOfLinesInFile (String filePath)
	{
		int numberOfLines;
		try
		{
			numberOfLines = (int) Files.lines(new File(filePath).toPath(), StandardCharsets.UTF_8).count();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		 return numberOfLines;
	}

	/**
	 * Creates a {@link BufferedReader} from the specified file
	 *
	 * @param filePath The Path to the file that should be converted to a {@link BufferedReader}
	 * @return {@link BufferedReader} of the specified File
	 *
	 * @precondition The filePath has to point to a valid file (not null); The file must contain only characters in
	 * the UTF-8
	 * characterset
	 * @postcondition A BufferedReader of the specifiedFile
	 */
	public static BufferedReader createBufferedReaderFromFile (String filePath)
	{
		try
		{
			return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
}
