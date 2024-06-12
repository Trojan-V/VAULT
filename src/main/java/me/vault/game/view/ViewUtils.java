package me.vault.game.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.interfaces.UpgradableNew;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;

import static me.vault.game.utility.constant.NewLoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class ViewUtils
{

	/**
	 * @param text  the text
	 * @param color
	 */
	public static void setButtonColor (final Text text, final Color color)
	{
		text.setFill(Paint.valueOf(color.toString()));
	}


	public static void setImage (final ImageView imageView, final Image image)
	{
		imageView.setImage(image);
	}


	public static void setText (final Text textElement, final String text)
	{
		textElement.setText(text);
	}


	public static void setTabPaneStyle (final TabPane tabPane, final String style)
	{
		tabPane.getStyleClass().add(style);
	}


	public static void setButtonInactive (final Button button)
	{
		button.setDisable(true);
	}


	public static void setButtonActive (final Button button)
	{
		button.setDisable(false);
	}


	public static void setMenuItemInactive (final MenuItem menuItem)
	{
		menuItem.setDisable(true);
	}


	public static void setMenuItemActive (final MenuItem menuItem)
	{
		menuItem.setDisable(false);
	}


	public static void show (final Stage stage, final Scene scene)
	{
		// Loading the FXML-File and creating a scene from the loaded components


		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
		//logger.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, className));
	}


	public static void showUpgradeDialog (final UpgradableNew upgradableNew)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource("upgradeDialog.fxml"));
			final Parent root = fxmlLoader.load();
			final UpgradeDialogDelegate controller = fxmlLoader.getController();
			controller.setUpgradable(upgradableNew);
			controller.show(new Scene(root));
		}
		catch (final IOException e)
		{
			new Logger(ViewUtils.class.getSimpleName()).logf(WARNING, UPGRADE_DIALOG_FAIL, upgradableNew.toString());
		}
	}

}
