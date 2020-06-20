/**
 * Window object for convinient area calculation
 * @author Matthew Corfiatis
 */
public class Window {
	public double width;
	public double height;
	
	public Window() {}
	public Window(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	public double Area()
	{
		return width * height;
	}
}