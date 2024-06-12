package me.vault.game.interfaces;


import javafx.beans.property.SimpleStringProperty;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 06.06.2024
 */
public interface Nameable
{

	String getName ();


	SimpleStringProperty getNameProperty ();

}
