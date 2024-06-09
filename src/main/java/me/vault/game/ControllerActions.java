package me.vault.game;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class ControllerActions
{
	public static void setButtonColor (final Text text, final Color color)
	{
		text.setFill(Paint.valueOf(color.toString()));
	}

	public static void changeImage (final ImageView imageView, final Image image)
	{
		imageView.setImage(image);
	}

	public static void setText (final Text textElement, final String text)
	{
		textElement.setText(text);
	}
}
