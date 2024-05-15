package me.vault.vaultgame.city.model;

/**
 * The {@code Record "Position"} represents the position of an element on the screen and holds an x- and y-coordinate
 * . The x- and y-coordinate are
 * saved as integers and don't allow floating point numbers. They're primarily used by the {@code Building}
 * -enumeration, since the location/position
 * of each building is locked and never changes.
 *
 * @param xPos
 * @param yPos
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see Building
 * @see Record
 * @since 02.05.2024
 */
public record Position(int xPos, int yPos)
{
	/**
	 * The format, which is used when the {@link Position#toString()} method is called
	 */
	private static final String FORMAT = "Pos{x: %d, y:%d}";

	/**
	 * Compares the object with another object and returns a boolean values of the comparison.
	 *
	 * @param anotherObject the reference object with which to compare.
	 * @return Returns {@code true}, if the compared object is an instance of {@link Position} and its attribute
	 * values are the same.
	 */
	@Override
	public boolean equals (Object anotherObject)
	{
		if (anotherObject == null) // Null-Akzeptanz
		{
			return false;
		}

		if (this == anotherObject) // Reflexivität
		{
			return true;
		}

		if (this.getClass() != anotherObject.getClass()) // ungleiche Typen
		{
			return false;
		}
		Position anotherPosition = (Position) anotherObject;
		return this.xPos == anotherPosition.xPos && this.yPos == anotherPosition.yPos;
	}

	/**
	 * Returns a String, which is representative of the respective object and its attributes.
	 *
	 * @return A String of the objects attributes.
	 */
	@Override
	public String toString ()
	{
		return String.format(FORMAT, this.xPos, this.yPos);
	}

}
