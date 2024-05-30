import me.vault.game.model.citybuilding.CityBuilding;


/**
 * Tests the instantiation of every CityBuilding in the {@link CityBuilding} enum.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 27.05.2024
 */
public class CityBuildingTest
{
	private CityBuildingTest () {}


	public static void main (final String[] args)
	{
		for (final CityBuilding cityBuilding : CityBuilding.values())
		{
			System.out.println(cityBuilding.toString());
			// Assertions.assertEquals(EXPECTED_COMMAND_CENTER, cityBuilding.toString(), "Command center CityBuilding
		}
	}
}
