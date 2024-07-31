package me.vault.game.utility.fx;


import javafx.beans.binding.NumberExpression;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import me.vault.game.control.EnergyAbilityController;
import me.vault.game.control.TroopController;
import me.vault.game.utility.loading.ResourceLoader;

import java.text.MessageFormat;


/**
 * An {@link HBox} which is used to display a single statistic.
 * <br>
 * These HBoxes are usually added to a {@link GridPane}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see HBox
 * @see GridPane
 * @see TroopController
 * @see EnergyAbilityController
 * @since 29.07.2024
 */
public final class SingleStatisticHBox extends HBox
{

	/**
	 * Represents the spacing of the statistics in the statistics grid pane.
	 */
	private static final int ATTRIBUTE_SPACING = 10;

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "SingleStatisticHBox'{'spritePath=''{0}'', name=''{1}'', property={2}'}'";

	/**
	 * Te font size of the labels in the {@link SingleStatisticHBox}.
	 */
	private static final int FONT_SIZE = 18;

	/**
	 * The path to the sprite of the statistic that is displayed within this {@link HBox}.
	 */
	private final String spritePath;

	/**
	 * The name of the statistic that is displayed within this {@link HBox}.
	 */
	private final String name;

	/**
	 * The property that is bound to the JavaFX GUI to be able to update the data within the GUI, so it's visible to
	 * the player.
	 */
	private final NumberExpression property;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * Additionally, to the usual assignment of the constructor parameters to the class' attributes, the supplied
	 * data gets directly added to the {@link HBox}.
	 * <br>
	 * The added data consists of the statistic's sprite, name, and property.
	 *
	 * @param spritePath The path to the sprite of the statistic.
	 * @param name       The name of the statistic.
	 * @param property   The property that is bound to the JavaFX GUI.
	 *
	 * @precondition The constructor gets called and all parameters are != null.
	 * @postcondition A new instance of this class was created.
	 */
	SingleStatisticHBox (final String spritePath, final String name, final NumberExpression property)
	{
		this.spritePath = spritePath;
		this.name = name;
		this.property = property;
		this.setAlignment(Pos.CENTER_LEFT);
		this.setSpacing(ATTRIBUTE_SPACING);
		this.addData();
	}


	/**
	 * Adds the supplied data to the {@link HBox}.
	 * <br>
	 * The added data consists of the statistic's sprite, name, and property.
	 *
	 * @precondition The method gets called and the instance of this class is != null.
	 * @postcondition The relevant data of the statistic got added to the instance of this class.
	 */
	private void addData ()
	{
		final Label attributeValueLabel = new Label();
		attributeValueLabel.setFont(new Font(FONT_SIZE));
		attributeValueLabel.textProperty().bind(this.property.asString());

		final Label nameLabel = new Label(this.name);
		nameLabel.setFont(new Font(FONT_SIZE));

		this.getChildren().add(new ImageView(ResourceLoader.loadImage(this.spritePath)));
		this.getChildren().add(nameLabel);
		this.getChildren().add(attributeValueLabel);
	}


	/**
	 * Builds a formatted {@link String} which represents the object, and it's current state using the {@link SingleStatisticHBox#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link SingleStatisticHBox#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link SingleStatisticHBox#TO_STRING_PATTERN} is {@code != null} and both of the instance variables are set.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.spritePath, this.name, this.property);
	}

}
