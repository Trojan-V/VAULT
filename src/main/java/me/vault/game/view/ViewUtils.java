package me.vault.game.view;


import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;


public class ViewUtils
{
	public static void setButtonColor (Text text, Color color)
	{
		text.setFill(Paint.valueOf(color.toString()));
	}

	public static void setImage (ImageView imageView, Image image)
	{
		imageView.setImage(image);
	}

	public static void setText (Text textElement, String text)
	{
		textElement.setText(text);
	}

	public static void setTabPaneStyle ( TabPane tabPane, String style)
	{
		tabPane.getStyleClass().add(style);
	}

	public static void setButtonInactive (Button button)
	{
		button.setDisable(true);
	}

	public static void setButtonActive (Button button)
	{
		button.setDisable(false);
	}
}
