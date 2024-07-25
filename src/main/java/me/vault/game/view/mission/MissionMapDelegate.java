package me.vault.game.view.mission;


import javafx.fxml.Initializable;
import javafx.scene.Scene;
import me.vault.game.GameApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.ViewUtil;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 25.07.2024
 */
public class MissionMapDelegate implements Initializable
{
	private static final String MISSION_MAP_VIEW_FXML = "mission_map_view.fxml";


	private static final Scene MISSION_MAP_SCENE =
		ResourceLoader.loadScene(MissionMapDelegate.class, MISSION_MAP_VIEW_FXML);


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), MISSION_MAP_SCENE, MissionMapDelegate.class);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{

	}
}
