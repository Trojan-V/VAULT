package me.vault.vaultgame.model.citybuilding;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


// TODO: Rename properties to attributes to remove unclear wording due to GUI properties
public class CityBuildingProperties
{
	private final String name;


	private final Image image;


	private final Scene scene;


	public CityBuildingProperties (final String name, final Image image, final Scene scene)
	{
		this.name = name;
		this.image = image;
		this.scene = scene;
	}


	public String getName ()
	{
		return this.name;
	}


	public Image getImage ()
	{
		return this.image;
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
		       ", imageView=" + this.image +
		       ", scene=" + this.scene +
		       '}';
	}
}
