package me.vault.vaultgame.model.citybuilding;


import javafx.scene.Scene;
import javafx.scene.image.ImageView;


public class CityBuildingProperties
{
	private final String name;


	private final ImageView imageView;


	private final Scene scene;


	public CityBuildingProperties (final String name, final ImageView imageView, final Scene scene)
	{
		this.name = name;
		this.imageView = imageView;
		this.scene = scene;
	}


	public String getName ()
	{
		return this.name;
	}


	public ImageView getImageView ()
	{
		return this.imageView;
	}


	public Scene getScene ()
	{
		return this.scene;
	}


	@Override
	public String toString ()
	{
		return "CityBuildingProperties{" +
		       "name='" + this.name + '\'' +
		       ", imageView=" + this.imageView +
		       ", scene=" + this.scene +
		       '}';
	}
}
