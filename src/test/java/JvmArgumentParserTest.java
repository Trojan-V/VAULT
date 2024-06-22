import me.vault.game.utility.jvm.JvmArgument;
import me.vault.game.utility.jvm.JvmArgumentParser;
import me.vault.game.utility.logging.ILogger.Level;
import me.vault.game.utility.logging.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static me.vault.game.utility.constant.LoggingConstants.JvmArgument.JVM_ARGUMENT_CONSTRUCTION_ERROR;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 30.05.2024
 */
public class JvmArgumentParserTest
{


	private static final String EXPECTED_LOG_DEPTH_ARGUMENT_STRING = "-log_depth";


	private static final String[] TEST_ARGS =
		new String[]{"-invalidArg", "INVALID_ARG_PARAM", JvmArgument.LOG_DEPTH.toString(), "INVALID_ARG_PARAM_AGAIN",
			JvmArgument.LOG_DEPTH.toString(), "DEBUG"};


	public static void main (final String[] args)
	{
		Logger.setDepth(Level.DEBUG);
		testJvmArgumentInstantiation();
		testApply();
	}


	private static void testJvmArgumentInstantiation ()
	{
		Assertions.assertEquals(EXPECTED_LOG_DEPTH_ARGUMENT_STRING, JvmArgument.LOG_DEPTH.toString(),
			JVM_ARGUMENT_CONSTRUCTION_ERROR);
	}


	private static void testApply ()
	{
		System.out.println(Arrays.toString(TEST_ARGS));
		JvmArgumentParser.apply(TEST_ARGS);
	}

}
