/**
 * Graphics symbol object to store multiple, ordered shapes for drawing.
 * @author Matthew Corfiatis
 */
public class Symbol {
	public IShape[] shapes = new IShape[0];
	
	public Symbol(){}
	public Symbol(IShape[] shapes)
	{
		this.shapes = shapes;
	}
	
	public Symbol getTransformed(Transform transform)
	{
		IShape[] tempShapes = new IShape[shapes.length];
		for(int i = 0; i < shapes.length; i++)
			tempShapes[i] = shapes[i].getTransformed(transform);
		return new Symbol(tempShapes);
	}
}
