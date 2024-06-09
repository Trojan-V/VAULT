/**
 * Exports all required modules to the JavaFX framework, so JavaFX is able to use these classes.
 */
module me.vault.game {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;
	requires java.desktop;

	opens me.vault.game to javafx.fxml;
	opens me.vault.game.utility.loading to javafx.fxml;
	opens me.vault.game.artifact to javafx.fxml;
	opens me.vault.game.city to javafx.fxml;
	opens me.vault.game.city.building to javafx.fxml;

	exports me.vault.game;
	exports me.vault.game.artifact;
	exports me.vault.game.interfaces;
	exports me.vault.game.city;
	exports me.vault.game.city.building;
	exports me.vault.game.currency;
	exports me.vault.game.troop.troop;
	exports me.vault.game.utility.struct;
	exports me.vault.game.exception;
	exports me.vault.game.player;
	exports me.vault.game.troop.unit;
	exports me.vault.game.utility.constant;
	exports me.vault.game.utility.jvm;
	exports me.vault.game.utility.logging;
	exports me.vault.game.utility.loading;

	opens me.vault.game.city.commandcenter to javafx.fxml;
	exports me.vault.game.city.commandcenter;
	opens me.vault.game.currency to javafx.fxml;
	exports me.vault.game.artifact.impl;
	opens me.vault.game.artifact.impl to javafx.fxml;
	exports me.vault.game.city.workshop;
	opens me.vault.game.city.workshop to javafx.fxml;
	exports me.vault.game.city.docks;
	opens me.vault.game.city.docks to javafx.fxml;
	exports me.vault.game.city.barracks;
	opens me.vault.game.city.barracks to javafx.fxml;
	exports me.vault.game.city.spacebar;
	opens me.vault.game.city.spacebar to javafx.fxml;
	exports me.vault.game.city.trainingfacility;
	opens me.vault.game.city.trainingfacility to javafx.fxml;
}