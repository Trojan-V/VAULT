import me.vault.vaultgame.view.CityView;
import me.vault.vaultgame.controller.CityBuildingController;
import me.vault.vaultgame.model.CityBuilding;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public class TestCity
{
	public static void main (String[] args)
	{
		CityView.onBuildingButtonClick();
		CityBuildingController.upgrade(CityBuilding.WORKSHOP);
	}
}
