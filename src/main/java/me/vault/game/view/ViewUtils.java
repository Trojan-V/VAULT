package me.vault.game.view;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

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

}
