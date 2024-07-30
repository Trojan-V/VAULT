package me.vault.game.interfaces;


import javafx.beans.property.SimpleStringProperty;

// TODO: Pre und post

/**
 * Any class that's a nameable object should implement this interface.
 * It provides getters to access the name
 * property and the name of the nameable object.
 * <br>
 * This is especially important to ensure the model view controller paradigm can be implemented correctly, as the
 * controller is responsible for updating the values of the properties and therefore the controller needs a method to
 * be able to access these inner properties of the nameable object.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 06.06.2024
 */
public interface Nameable
{

	/**
	 * Returns the name stored within the property of the nameable object as a {@link String}.
	 *
	 * @return The name of the nameable object.
	 */
	String getName ();


	/**
	 * Sets the name of the nameable object to the supplied name.
	 *
	 * @param name The new name for the nameable object.
	 */
	void setName (final String name);


	/**
	 * Returns the name property of the nameable object.
	 *
	 * @return The name property of the nameable object.
	 */
	SimpleStringProperty getNameProperty ();

}
