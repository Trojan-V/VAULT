package me.vault.vaultgame.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static utility.constant.Constants.EMPTY_STRING;
import static utility.constant.Constants.WHITESPACE;

/**
 * All methods found in this class are related to input or output in some way.
 * <p>
 *     Mostly, this class can be used to print data into the console window.
 * </p>
 *
 * @author Prof. Dr. Ing. Heiko Mosemann
 * @author Vincent Wolf
 */
public class MyIO
{

    public static final String CLASS_SENDER_MESSAGE_PREFIX = "From ";

    /**
     * As this class is solely a collection of static methods, there is no use-case where an instantiation of this
     * class would be beneficial, hence why a private constructor is used here to prohibit that.
     */
    private MyIO ()
    {
        ;
    }


    /**
     * The date/time format.
     * Can be used by {@link DateTimeFormatter#ofPattern(String)} to format the date and time accordingly.
     */
    private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss:SSS";


    /**
     * String which is being appended if {@link MyIO#shouldPrefixWithTimestamp} is enabled
     * to display that the timestamp ends and the message starts.
     */
    private static final String PROMPT = "-> ";


    /**
     * Determines if every message that will be printed into the console with the {@link MyIO#print(String)} method
     * should be prefixed with the current timestamp.
     * <p>
     *     Pass {@code -timestampprefix} as JVM argument to enable the verbose mode.
     * </p>
     */
    private static boolean shouldPrefixWithTimestamp = false;


    /**
     * Determines if the program should print a ton of debugging information into the console.
     * If disabled, almost no information will be printed into the console.
     * <p>
     *     Pass {@code -verbose} as JVM argument to enable the verbose mode.
     * </p>
     */
    private static boolean isVerboseMode = false;


    /**
     * Convenience method to invoke {@link java.io.PrintStream#println()} easily.
     * <p>
     *     Also provides other convenience options,
     *     such as only sending misc.messages if {@link MyIO#isVerboseMode} is enabled
     *     and optional timestamp prefixes in front of each message.
     * </p>
     *
     * @param text The text which should be printed into the console.
     */
    public static void print (String text)
    {
        if (!isVerboseMode)
        {
            return;
        }

        if (shouldPrefixWithTimestamp)
        {
            text = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)) + PROMPT + text;
        }

        System.out.println(text);
    }


    /**
     * Solely prints a console into the console.
     *
     * @param consoleColor The color which should be printed into the console.
     */
    public static void print (ConsoleColor consoleColor)
    {
        if (isVerboseMode)
        {
            System.out.print(consoleColor);
        }
    }


    /**
     * Convenience method to print out any object's string representation
     * directly by invoking {@link Object#toString()} on the supplied object.
     *
     * @param object The object which string representation should be printed out.
     */
    public static void print (Object object)
    {
        print(object.toString());
    }


    /**
     * @param object The object which string representation should be printed out.
     * @param color The color of the font.
     */
    public static void print (Object object, ConsoleColor color)
    {
        print(object.toString(), color);
    }


    /**
     * @param object The object which string representation should be printed out.
     * @param color The color of the font.
     * @param backgroundColor The background color which is displayed behind the text.
     */
    public static void print (Object object, ConsoleColor color, ConsoleColor backgroundColor)
    {
        print(object.toString(), color, backgroundColor);
    }


    /**
     * Uses string formatting to replace the passed object ellipse with their actual values.
     * @param text The text which should be printed into the console.
     * @param args The objects which will be replaced within the text.
     */
    public static void printf (String text, Object... args)
    {
        System.out.printf(text,  args);
        print(EMPTY_STRING);
    }


    /**
     * Has an extra argument to set the color of the font.
     * @param text The text which should be printed into the console.
     * @param color The color in which the font should appear.
     * @param args The objects which will be replaced within the text.
     */
    public static void printf (String text, ConsoleColor color, Object... args)
    {
        print(color);
        printf(text, args);
        print(ConsoleColor.RESET);
    }


    /**
     * Has an extra argument to set the color of the background.
     * @param text The text which should be printed into the console.
     * @param color The color in which the font should appear.
     * @param backgroundColor The color which should be displayed as the background.
     * @param args The objects which will be replaced within the text.
     */
    public static void printf (String text, ConsoleColor color, ConsoleColor backgroundColor, Object... args)
    {
        print(color);
        print(backgroundColor);
        printf(text, args);
        print(ConsoleColor.RESET);
    }


    /**
     * Convenience method to print out any object's string representation
     * directly by invoking {@link Object#toString()} on the supplied object.
     *
     * @param object The object which string representation should be printed out.
     * @param color The color in which the font should appear.
     * @param args The objects which will be replaced within the text.
     */
    public static void printf (Object object, ConsoleColor color, Object... args)
    {
        printf(object.toString(), color, args);
    }


    /**
     * Convenience method to print out any object's string representation
     * directly by invoking {@link Object#toString()} on the supplied object.
     *
     * @param object The object which string representation should be printed out.
     * @param color The color in which the font should appear.
     * @param backgroundColor The color which should be displayed as the background.
     * @param args The objects which will be replaced within the text.
     */
    public static void printf (Object object, ConsoleColor color, ConsoleColor backgroundColor, Object... args)
    {
        printf(object.toString(), color, backgroundColor, args);
    }


    /**
     * Additionally provides a parameter to set the color in which the text should appear in the console.
     * <p>
     * After the color and text have been printed out,
     * the reset color code is being printed out
     * to reset the color to default for the next time the print method gets invoked.
     * </p>
     *
     * Check {@link MyIO#print(String)} for more information.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     */
    public static void print (String text, ConsoleColor color)
    {
        print(color);
        print(text);
        print(ConsoleColor.RESET);
    }


    /**
     * Additionally provides a parameter to set the color in which the background should be displayed.
     * Check {@link MyIO#print(String, ConsoleColor)} for more information.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param backgroundColor The background color which should be displayed behind the text.
     */
    public static void print (String text, ConsoleColor color, ConsoleColor backgroundColor)
    {
        print(color);
        print(backgroundColor);
        print(text);
        print(ConsoleColor.RESET);
    }


    /**
     * Another convenience method
     * which applies a default color palette of red font color and a black background color to the text
     * that is going to be printed out.
     * Check {@link MyIO#print(String, ConsoleColor, ConsoleColor)} for more information.
     *
     * @param text The text which should be printed into the console.
     * @param applyDefaultColors If true, the default color palette will be applied.
     */
    public static void print (String text, boolean applyDefaultColors)
    {
        if (applyDefaultColors)
        {
            print(text, ConsoleColor.RED, ConsoleColor.BLACK_BACKGROUND);
        }
        else
        {
            print(text);
        }
    }


    /**
     * Prints the text into the console but adds the name of the class who invoked this method.
     * <p>
     * Especially useful for debugging if it's unsure where certain misc.messages are being sent from.
     * </p>
     *
     * @param text The text which should be printed into the console.
     * @param senderClazz The class which invoked this method.
     */
    public static void print (String text, Class<?> senderClazz)
    {
        text = CLASS_SENDER_MESSAGE_PREFIX + senderClazz.getSimpleName() + WHITESPACE + PROMPT + WHITESPACE + text;
        print(text);
    }


    /**
     * Check {@link MyIO#print(String, Class)} and {@link MyIO#print(String, ConsoleColor)} for more information.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param senderClazz The class which invoked this method.
     */
    public static void print (String text, ConsoleColor color, Class<?> senderClazz)
    {
        print(color);
        print(text, senderClazz);
    }


    /**
     * Check {@link MyIO#print(String, Class)} and {@link MyIO#print(String, ConsoleColor, ConsoleColor)} for more information.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param backgroundColor The background color which should be displayed behind the text.
     * @param senderClazz The class which invoked this method.
     */
    public static void print (String text, ConsoleColor color, ConsoleColor backgroundColor, Class<?> senderClazz)
    {
        print(color);
        print(backgroundColor);
        print(text, senderClazz);
    }


    /**
     * Reprint supplies a method to overwrite a message which has been sent in the line the cursor is currently at.
     * <p>
     * That works by printing the carriage return character '\r' before the text,
     * as carriage return sets the cursor back at the beginning of the current line without swapping to a new line.
     * </p>
     *
     * @param text The text which should be printed into the console.
     */
    public static void reprint (String text)
    {
        System.out.print("\r" + text);
        System.out.flush();
    }


    /**
     * Additionally provides a parameter to set the color in which the text should appear in the console.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     */
    public static void reprint (String text, ConsoleColor color)
    {
        print(color);
        reprint(text);
        print(ConsoleColor.RESET);
    }


    /**
     * Additionally provides a parameter to set the color in which the background should be displayed.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param backgroundColor The background color which should be displayed behind the text.
     */
    public static void reprint (String text, ConsoleColor color, ConsoleColor backgroundColor)
    {
        print(backgroundColor);
        reprint(text, color);
    }


    /**
     * Reprints the supplied text into the console but adds the name of the class who invoked this method.
     * Additionally, it provides an option to set the color of the font.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param senderClazz The class which invoked this method.
     */
    public static void reprint (String text, ConsoleColor color, Class<?> senderClazz)
    {
        text = "From " + senderClazz.getSimpleName() + " " + PROMPT + " " + text;
        reprint(text, color);
    }


    /**
     * Reprints the supplied text into the console but adds the name of the class who invoked this method.
     * Additionally, it provides an option to set the color of the font as well as the background.
     *
     * @param text The text which should be printed into the console.
     * @param color The color in which the text should appear in the console.
     * @param backgroundColor The background color which should be displayed behind the text.
     * @param senderClazz The class which invoked this method.
     */
    public static void reprint (String text, ConsoleColor color, ConsoleColor backgroundColor, Class<?> senderClazz)
    {
        print(backgroundColor);
        reprint(text, color, senderClazz);
    }


    /**
     * Attempts to read the file at the supplied path and appends each line into a {@link List}.
     *
     * @param filePath The path of the file which is going to be read.
     * @return A {@link List} of {@link String} where every list entry represents one line of the file.
     */
    public static List<String> readAllLines (Path filePath)
    {
        try
        {
            return Files.readAllLines(filePath);
        }
        catch (IOException e)
        {
            MyIO.print(e.getMessage(), ConsoleColor.RED_BOLD_BRIGHT, ConsoleColor.BLACK_BACKGROUND);
        }
        return null;
    }


    /**
     * Convenience wrapper method for {@link MyIO#readAllLines(Path)}
     * which handles {@link String} to {@link Path} conversion.
     *
     * @param filePath The path of the file which is going to be read.
     * @return A {@link List} of {@link String} where every list entry represents one line of the file.
     */
    public static List<String> readAllLines (String filePath)
    {
        return readAllLines(Path.of(filePath));
    }


    /**
     * Setter method for the {@link MyIO#shouldPrefixWithTimestamp} configuration option.
     * This setter is only invoked if the {@code -timestampprefix} JVM argument is supplied to the program on startup.
     *
     * @param shouldPrefixWithTimestamp If true, every message sent by {@link MyIO#print(String)} is prefixed with a timestamp.
     */
    public static void setShouldPrefixWithTimestamp (boolean shouldPrefixWithTimestamp)
    {
        MyIO.shouldPrefixWithTimestamp = shouldPrefixWithTimestamp;
    }


    /**
     * Setter method for the {@link MyIO#isVerboseMode} configuration option.
     * This setter is only invoked if the {@code -verbose} JVM argument is supplied to the program on startup.
     *
     * @param isVerboseMode If false, no message will be sent by {@link MyIO#print(String)}, otherwise misc.messages will be sent.
     */
    public static void setVerboseMode (boolean isVerboseMode)
    {
        MyIO.isVerboseMode = isVerboseMode;
    }


    /**
     * @return True if verboseMode is enabled, otherwise false.
     */
    public static boolean isVerboseMode ()
    {
        return isVerboseMode;
    }


    /**
     * @return True if shouldPrefixWithTimestamp is enabled, otherwise false.
     */
    public static boolean getShouldPrefixWithTimestamp ()
    {
        return shouldPrefixWithTimestamp;
    }
}
