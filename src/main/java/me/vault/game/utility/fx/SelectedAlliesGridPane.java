package me.vault.game.utility.fx;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.interfaces.Placeable;


/**
 * The {@link SelectedAlliesGridPane} represents one {@link Figure}s as a grid in the {@link Arena}.
 * It extends the standard {@link GridPane} and automatically initializes the right graphic and design based
 * on the {@link Figure} object which is parsed into the constructor.
 * The {@code SelectedAlliesGridPane} is mainly used in combination with the {@link Arena} to display the
 * {@link Figure}s in an encounter.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Button
 * @see CurrencyTransaction
 * @see Placeable
 * @since 31.07.2024
 */
public final class SelectedAlliesGridPane extends GridPane
{

	/**
	 * The width of the {@link SelectedAlliesGridPane}.
	 */
	private static final int WIDTH = 565;


	/**
	 * The height of the {@link SelectedAlliesGridPane}.
	 */
	private static final int HEIGHT = 340;


	/**
	 * The number of columns in the {@link SelectedAlliesGridPane}.
	 */
	private static final int COLUMN_AMOUNT = 3;


	/**
	 * The y offset of the {@link SelectedAlliesGridPane}.
	 */
	private static final int Y_OFFSET = 250;


	/**
	 * The height of the first row in the {@link SelectedAlliesGridPane}.
	 */
	private static final int FIRST_ROW_Y = 50;


	/**
	 * The height of the second row in the {@link SelectedAlliesGridPane}.
	 */
	private static final int SECOND_ROW_Y = 200;


	/**
	 * The placeholder string for the name labels of the selected troops.
	 */
	private static final String PLACEHOLDER_STRING = "Nothing chosen so far";


	/**
	 * The index of the row which contains the name labels of the selected troops.
	 */
	private static final int LABEL_ROW_INDEX = 0;


	/**
	 * The index of the row which contains the image views of the selected troops.
	 */
	private static final int IMAGE_VIEW_ROW_INDEX = 1;


	/**
	 * The index of the third column.
	 */
	private static final int THIRD_COLUMN_INDEX = 2;


	/**
	 * The first name label of the selected troops.
	 */
	private final Label firstTroopLabel = new Label(PLACEHOLDER_STRING);


	/**
	 * The second name label of the selected troops.
	 */
	private final Label secondTroopLabel = new Label(PLACEHOLDER_STRING);


	/**
	 * The third name label of the selected troops.
	 */
	private final Label thirdTroopLabel = new Label(PLACEHOLDER_STRING);


	/**
	 * The first image view of the selected troops.
	 */
	private final ImageView firstTroopImageView = new SelectedTroopImageView();


	/**
	 * The second image view of the selected troops.
	 */
	private final ImageView secondTroopImageView = new SelectedTroopImageView();


	/**
	 * The third image view of the selected troops.
	 */
	private final ImageView thirdTroopImageView = new SelectedTroopImageView();


	/**
	 * A counter used for swapping between the selected troops.
	 */
	private int counter;


	/**
	 * Constructs a new instance of this class.
	 *
	 * @precondition The constructor gets called.
	 * @postcondition A new instance of this class was created.
	 */
	public SelectedAlliesGridPane ()
	{
		this.counter = LABEL_ROW_INDEX;
		this.designAppearance();
		this.add(this.firstTroopLabel, LABEL_ROW_INDEX, LABEL_ROW_INDEX);
		this.add(this.secondTroopLabel, IMAGE_VIEW_ROW_INDEX, LABEL_ROW_INDEX);
		this.add(this.thirdTroopLabel, THIRD_COLUMN_INDEX, LABEL_ROW_INDEX);

		this.add(this.firstTroopImageView, LABEL_ROW_INDEX, IMAGE_VIEW_ROW_INDEX);
		this.add(this.secondTroopImageView, IMAGE_VIEW_ROW_INDEX, IMAGE_VIEW_ROW_INDEX);
		this.add(this.thirdTroopImageView, THIRD_COLUMN_INDEX, IMAGE_VIEW_ROW_INDEX);
	}


	/**
	 * Designs the appearance of this class by setting its properties.
	 *
	 * @precondition The instance of this class is != null and inherits from {@link GridPane}.
	 * @postcondition The appearance of the instance of this class was designed.
	 */
	private void designAppearance ()
	{
		this.setGridLinesVisible(true);
		this.setMinSize(HEIGHT, WIDTH);
		this.setPrefSize(HEIGHT, WIDTH);
		this.setMaxSize(HEIGHT, WIDTH);
		this.setLayoutY(Y_OFFSET);

		final ColumnConstraints columnConstraints = new ColumnConstraints((double) WIDTH / COLUMN_AMOUNT);
		for (int i = LABEL_ROW_INDEX; i < COLUMN_AMOUNT; i++)
		{
			this.getColumnConstraints().add(this.getColumnConstraints().size(), columnConstraints);
		}

		this.getRowConstraints().add(this.getRowConstraints().size(), new RowConstraints(FIRST_ROW_Y));
		this.getRowConstraints().add(this.getRowConstraints().size(), new RowConstraints(SECOND_ROW_Y));
	}


	/**
	 * Adds the properties of a troop to the grid.
	 *
	 * @param troop The troop whose properties should be added to the grid.
	 *
	 * @precondition The labels and views on the control have already been initialized.
	 * @postcondition The properties of the troop were added to the grid.
	 */
	public void addTroop (final Troop troop)
	{
		switch (this.counter)
		{
			case LABEL_ROW_INDEX:
				this.firstTroopLabel.setText(troop.getName());
				this.firstTroopImageView.setImage(troop.getSprite());
				this.counter++;
				break;

			case IMAGE_VIEW_ROW_INDEX:
				this.secondTroopLabel.setText(troop.getName());
				this.secondTroopImageView.setImage(troop.getSprite());
				this.counter++;
				break;

			case THIRD_COLUMN_INDEX:
				this.thirdTroopLabel.setText(troop.getName());
				this.thirdTroopImageView.setImage(troop.getSprite());
				this.counter++;
				break;

			default:
				this.counter = LABEL_ROW_INDEX;
				this.addTroop(troop);
				break;
		}

	}

}
