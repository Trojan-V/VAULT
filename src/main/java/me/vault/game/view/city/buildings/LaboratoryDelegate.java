package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.control.CityBuildingController;

import java.net.URL;
import java.util.ResourceBundle;


public class LaboratoryDelegate extends CityBuildingController implements Initializable
{

	@FXML
	private Label compositeAmountLabel;

	@FXML
	private ImageView compositeImageView;

	@FXML
	private Label creditAmountLabel;

	@FXML
	private ImageView creditImageView;

	@FXML
	private Label damageArtifactDamageModifierLabel;

	@FXML
	private Label damageArtifactDefenseModifierLabel;

	@FXML
	private Label damageArtifactHealthModifierLabel;

	@FXML
	private ImageView damageArtifactImageView;

	@FXML
	private Label damageArtifactLabel;

	@FXML
	private Button damageArtifactUpgradeButton;

	@FXML
	private Label defenseArtifactDamageModifierLabel;

	@FXML
	private Label defenseArtifactDefenseModifierLabel;

	@FXML
	private Label defenseArtifactHealthModifierLabel;

	@FXML
	private ImageView defenseArtifactImageView;

	@FXML
	private Label defenseArtifactLabel;

	@FXML
	private Button defenseArtifactUpgradeButton;

	@FXML
	private Label foodAmountLabel;

	@FXML
	private ImageView foodImageView;

	@FXML
	private Label healthArtifactDamageModifierLabel;

	@FXML
	private Label healthArtifactDefenseModifierLabel;

	@FXML
	private Label healthArtifactHealthModifierLabel;

	@FXML
	private ImageView healthArtifactImageView;

	@FXML
	private Label healthArtifactLabel;

	@FXML
	private Button healthArtifactUpgradeButton;

	@FXML
	private Label scienceAmountLabel;

	@FXML
	private ImageView scienceImageView;

	@FXML
	private Label steelAmountLabel;

	@FXML
	private ImageView steelImageView;

	@FXML
	private ImageView workshopBackgroundImageView;


	@FXML
	void onBackToCityView (final ActionEvent event)
	{

	}


	@FXML
	void onDamageArtifactUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onDefenseArtifactUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onHealthArtifactUpgrade (final ActionEvent event)
	{

	}


	/**
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{

	}

}
