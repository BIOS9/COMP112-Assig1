/**
 * Door object for convinient area calculation
 * @author Matthew Corfiatis
 */
public class Door {
	public double width;
	public double height;
	
	public Door() {}
	public Door(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	public double Area()
	{
		return width * height;
	}
}