package me.vault.game.view;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import me.vault.game.VaultApplication;
import me.vault.game.interfaces.UpgradableNew;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.constant.NewLoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class ViewUtils
{

	private static final ILogger LOGGER = new Logger(ViewUtils.class.getSimpleName());

	private static final String UPGRADE_DIALOG_FXML = "upgradeDialog.fxml";


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


	public static void show (final Scene scene, final Class<? extends Initializable> clazz)
	{
		final Stage stage = VaultApplication.getStage();
		stage.setScene(scene);
		stage.show();

		// Logging the display of the view on the main stage.
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, clazz.getSimpleName()));
	}


	public static void showUpgradeDialog (final UpgradableNew upgradableNew)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(UPGRADE_DIALOG_FXML));
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
