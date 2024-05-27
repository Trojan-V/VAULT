import me.vault.vaultgame.model.artifact.Artifact;

import java.util.logging.Logger;


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
	private static final Logger LOGGER = Logger.getLogger(ArtifactTest.class.getName());


	private ArtifactTest () {}


	public static void main (final String[] args)
	{
		for (final Artifact artifact : Artifact.values())
		{
			LOGGER.info(artifact.toString());
		}
	}
}
