/**
 * Object to store different room parameters such as size, doors and windows.
 * @author Matthew Corfiatis
 */
public class Room {
	public double width;
	public double height;
	public double length;
	
	public int doorNum;
	public Window[] windows;
	
	public Room() {}
	public Room(double width, double length, double height, int doorNum, Window[] windows)
	{
		this.doorNum = doorNum;
		this.height = height;
		this.length = length;
		this.width = width;
		this.windows = windows;
	}
}