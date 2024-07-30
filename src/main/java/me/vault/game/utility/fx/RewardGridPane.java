package me.vault.game.utility.fx;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;

// TODO: Complete JavaDoc needed

public final class RewardGridPane extends GridPane
{

	private static final int H_GAP = 40;

	private static final int V_GAP = 8;

	private static final int COLUMN_IMAGE_VIEW = 0;

	private static final int COLUMN_NAME_LABEL = 1;

	private static final int COLUMN_AMOUNT_LABEL = 2;

	private static final int IMAGE_VIEW_FIT_SIZE = 32;


	public RewardGridPane (final CurrencyTransaction currencyTransaction)
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
