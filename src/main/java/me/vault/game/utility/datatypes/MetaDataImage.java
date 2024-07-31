package me.vault.game.utility.datatypes;


import javafx.scene.image.Image;
import me.vault.game.utility.loading.ResourceLoader;

import javax.lang.model.element.Name;
import java.io.File;
import java.io.InputStream;


/**
 * The sole purpose of this class is to be able to add metadata to the images that are loaded by the
 * {@link ResourceLoader} and displayed in the GUI as sprite.
 * <br>
 * This metadata is useful for logging messages in the console.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Image
 * @since 07.06.2024
 */
public class MetaDataImage extends Image
{

	/**
	 * The file that corresponds to the image.
	 */
	private final File file;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param imageInputStream The input stream from which the image gets loaded.
	 * @param file             The corresponding file to the image.
	 */
	public MetaDataImage (final InputStream imageInputStream, final File file)
	{
		super(imageInputStream);
		this.file = file;
	}


	/**
	 * Returns the image in a human-readable format by its name.
	 *
	 * @return The image in a human-readable format by its name.
	 *
	 * @precondition The {@link Name} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return this.file.getName();
	}

}
