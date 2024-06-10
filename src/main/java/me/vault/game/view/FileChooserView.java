package me.vault.game.view;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ResourceLoader;

import java.io.File;


public class FileChooserView
{
	public static File show (Stage stage, String initialFolderFilePath, String title)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		fileChooser.setInitialDirectory(ResourceLoader.getDirectory(initialFolderFilePath));
		return fileChooser.showOpenDialog(stage);

	}
}
