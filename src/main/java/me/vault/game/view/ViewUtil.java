package me.vault.game.view;


import javafx.fxml.Initializable;
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
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class ViewUtil
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ViewUtil.class.getSimpleName());


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


	public static void show (final Stage stage, final Scene scene, final Class<? extends Initializable> clazz)
	{
		stage.setScene(scene);
		stage.show();

		// Logging the display of the view on the main stage.
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, clazz.getSimpleName()));
	}


	public static void setButtonImage (final Button button, final String filePath)
	{
		final ImageView imageView = new ImageView(ResourceLoader.loadImage(filePath));
		imageView.setPreserveRatio(false);
		imageView.setFitWidth(button.getPrefWidth());
		imageView.setFitHeight(button.getPrefHeight());
		button.setGraphic(imageView);
	}


	public static void setButtonTextColor (final Button button, final String textColor)
	{
		button.setTextFill(Color.valueOf(textColor));
	}


	public static void setButtonTextColor (final Button button, final Color color)
	{
		button.setTextFill(color);
	}

}