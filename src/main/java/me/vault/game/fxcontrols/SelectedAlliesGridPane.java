package me.vault.game.fxcontrols;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import me.vault.game.model.troop.Troop;


public final class SelectedAlliesGridPane extends GridPane
{

	private static final int WIDTH = 565;

	private static final int HEIGHT = 340;

	private static final int DIMENSIONS = 3;

	private static final int Y_OFFSET = 250;

	private static final int FIRST_ROW_Y = 50;

	private static final int SECOND_ROW_Y = 200;

	private static final int THIRD_ROW_Y = 50;


	private static final String PLACEHOLDER_STRING = "Nichts ausgew\u00E4hlt.";


	private final Label firstTroopLabel = new Label(PLACEHOLDER_STRING);

	private final Label secondTroopLabel = new Label(PLACEHOLDER_STRING);

	private final Label thirdTroopLabel = new Label(PLACEHOLDER_STRING);


	private final ImageView firstTroopImageView = new SelectedTroopImageView();

	private final ImageView secondTroopImageView = new SelectedTroopImageView();

	private final ImageView thirdTroopImageView = new SelectedTroopImageView();


	private final TroopUnselectButton firstTroopButton = new TroopUnselectButton();

	private final TroopUnselectButton secondTroopButton = new TroopUnselectButton();

	private final TroopUnselectButton thirdTroopButton = new TroopUnselectButton();


	private final Troop[] selectedTroops = new Troop[3];

	private int counter;


	public SelectedAlliesGridPane ()
	{
		this.counter = 0;
		this.setLayout();
		this.addControls();
	}


	public boolean addTroop (final Troop troop)
	{
		switch (this.counter)
		{
			case 0:
				this.selectedTroops[0] = troop;
				this.firstTroopLabel.setText(troop.getName());
				this.firstTroopImageView.setImage(troop.getSprite());
				this.counter++;
				return true;

			case 1:
				this.selectedTroops[1] = troop;
				this.secondTroopLabel.setText(troop.getName());
				this.secondTroopImageView.setImage(troop.getSprite());
				this.counter++;
				return true;

			case 2:
				this.selectedTroops[2] = troop;
				this.thirdTroopLabel.setText(troop.getName());
				this.thirdTroopImageView.setImage(troop.getSprite());
				this.counter++;
				return true;

			default:
				this.counter = 0;
				return this.addTroop(troop);
		}

	}


	public void removeTroop (final int index)
	{

		switch (index)
		{
			case 0:
				this.selectedTroops[index] = null;
				this.firstTroopLabel.setText(PLACEHOLDER_STRING);
				this.firstTroopImageView.setImage(SelectedTroopImageView.getPlaceholderImage());
				break;

			case 1:
				this.selectedTroops[index] = null;
				this.secondTroopLabel.setText(PLACEHOLDER_STRING);
				this.secondTroopImageView.setImage(SelectedTroopImageView.getPlaceholderImage());
				break;

			case 2:
				this.selectedTroops[index] = null;
				this.thirdTroopLabel.setText(PLACEHOLDER_STRING);
				this.thirdTroopImageView.setImage(SelectedTroopImageView.getPlaceholderImage());
				break;

			default:
		}
	}


	public Troop[] getSelectedTroops ()
	{
		return this.selectedTroops;
	}


	private void addControls ()
	{
		this.add(this.firstTroopLabel, 0, 0);
		this.add(this.secondTroopLabel, 1, 0);
		this.add(this.thirdTroopLabel, 2, 0);

		this.add(this.firstTroopImageView, 0, 1);
		this.add(this.secondTroopImageView, 1, 1);
		this.add(this.thirdTroopImageView, 2, 1);

		this.add(this.firstTroopButton, 0, 2);
		this.add(this.secondTroopButton, 1, 2);
		this.add(this.thirdTroopButton, 2, 2);
	}


	private void setLayout ()
	{
		this.setGridLinesVisible(true);
		this.setMinSize(HEIGHT, WIDTH);
		this.setPrefSize(HEIGHT, WIDTH);
		this.setMaxSize(HEIGHT, WIDTH);
		this.setLayoutY(Y_OFFSET);

		final ColumnConstraints columnConstraints = new ColumnConstraints((double) WIDTH / DIMENSIONS);
		for (int i = 0; i < DIMENSIONS; i++)
		{
			this.getColumnConstraints().add(this.getColumnConstraints().size(), columnConstraints);
		}

		this.getRowConstraints().add(this.getRowConstraints().size(), new RowConstraints(FIRST_ROW_Y));
		this.getRowConstraints().add(this.getRowConstraints().size(), new RowConstraints(SECOND_ROW_Y));
		this.getRowConstraints().add(this.getRowConstraints().size(), new RowConstraints(THIRD_ROW_Y));
	}

}
