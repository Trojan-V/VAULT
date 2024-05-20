import me.vault.vaultgame.city.CityController;
import me.vault.vaultgame.city.CityView;
import me.vault.vaultgame.city.building.controller.CityBuildingController;
import me.vault.vaultgame.city.building.model.CityBuilding;


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
