package me.vault.game.utility.fx;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import me.vault.game.model.Mission;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.interfaces.Placeable;


/**
 * The {@link CurrencyTransactionGridPane} represents one {@link CurrencyTransaction} as a grid in various places of the application.
 * It extends the standard {@link GridPane} and automatically initializes the right graphic and design based
 * on the {@link CurrencyTransaction} object which is parsed into the constructor.
 * The {@code CurrencyTransactionGridPane} is mainly used in combination with the {@link Mission}s to display their rewards.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Button
 * @see CurrencyTransaction
 * @see Placeable
 * @since 25.06.2024
 */
public final class CurrencyTransactionGridPane extends GridPane
{

	/**
	 * The horizontal gap between the different fields in the grid.
	 */
	private static final int H_GAP = 40;

	/**
	 * The vertical gap between the different fields in the grid.
	 */
	private static final int V_GAP = 8;

	/**
	 * The column index of the image views in the grid.
	 */
	private static final int COLUMN_IMAGE_VIEW = 0;

	/**
	 * The column index of the name labels in the grid.
	 */
	private static final int COLUMN_NAME_LABEL = 1;

	/**
	 * The column index of the amount labels in the grid.
	 */
	private static final int COLUMN_AMOUNT_LABEL = 2;

	/**
	 * The fit size of the image views in the grid.
	 */
	private static final int IMAGE_VIEW_FIT_SIZE = 32;


	/**
	 * Constructs a new instance of {@link CurrencyTransactionGridPane} based on the passed CurrencyTransaction.
	 *
	 * @param currencyTransaction The {@link CurrencyTransaction} which is the template for the new instance.
	 *
	 * @precondition The {@link CurrencyTransaction} parameter is != null.
	 * @postcondition A new instance of {@link CurrencyTransactionGridPane} was created.
	 */
	public CurrencyTransactionGridPane (final CurrencyTransaction currencyTransaction)
	{
		this.setHgap(H_GAP);
		this.setVgap(V_GAP);
		for (int row = 0; row < Currency.values().length; row++)
		{
			final Currency currency = Currency.values()[row];
			final ImageView currencyImageView = new ImageView(currency.getSprite());
			currencyImageView.fitHeightProperty().set(IMAGE_VIEW_FIT_SIZE);
			currencyImageView.fitWidthProperty().set(IMAGE_VIEW_FIT_SIZE);
			this.add(currencyImageView, COLUMN_IMAGE_VIEW, row);
			this.add(new Label(currency.name()), COLUMN_NAME_LABEL, row);
			this.add(new Label(String.valueOf(currencyTransaction.getAmount(currency))), COLUMN_AMOUNT_LABEL, row);
		}
	}

}
