package me.vault.game.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


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
}
