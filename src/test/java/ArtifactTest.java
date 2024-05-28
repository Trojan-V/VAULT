import me.vault.vaultgame.controller.ArtifactController;
import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.utility.Logger;

import static me.vault.vaultgame.utility.constant.CharacterConstants.WHITESPACE;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public final class ArtifactTest
{
	private static final Logger LOGGER = new Logger(ArtifactTest.class.getName());


	private ArtifactTest () {}


	public static void main (final String[] args)
	{
		for (final Artifact artifact : Artifact.values())
		{
			LOGGER.logDebug(artifact.name() + WHITESPACE + artifact.getLevel());
			ArtifactController.getInstance().upgrade(artifact);
			LOGGER.logDebug(artifact.name() + WHITESPACE + artifact.getLevel());
			LOGGER.logDebug(String.valueOf(Character.LINE_SEPARATOR));
		}
	}
}
