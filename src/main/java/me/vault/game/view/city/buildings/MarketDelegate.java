package me.vault.game.view.city.buildings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketDelegate extends CityBuildingController implements Initializable
{
	@FXML
	private ImageView backgroundImageView;

	@FXML
	private Label compositeAmountLabel;

	@FXML
	private ImageView compositeImageView;

	@FXML
	private Label creditAmountLabel;

	@FXML
	private ImageView creditImageView;

	@FXML
	private Label foodAmountLabel;

	@FXML
	private ImageView foodImageView;

	@FXML
	private Label scienceAmountLabel;

	@FXML
	private ImageView scienceImageView;

	@FXML
	private Label steelAmountLabel;

	@FXML
	private ImageView steelImageView;


	@FXML
	void onBackToCityView (final ActionEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{

	}

}
