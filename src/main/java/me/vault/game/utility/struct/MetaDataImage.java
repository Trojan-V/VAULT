package me.vault.game.utility.struct;

import javafx.scene.image.Image;

import java.io.File;
import java.io.InputStream;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Image
 * @since 07.06.2024
 */
public class MetaDataImage extends Image
{
	private final File file;


	public MetaDataImage (final InputStream imageInputStream, final File file)
	{
		super(imageInputStream);
		this.file = file;
	}


	@Override
	public String toString ()
	{
		return this.file.getName();
	}

}
