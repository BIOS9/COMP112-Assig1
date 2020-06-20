import java.awt.Color;

/**
 * Interface for managing multiple type of shapes when stored as a symbol
 * @author Matthew Corfiatis
 */
public interface IShape {
	
	public enum ShapeType
	{
		Undefined,
		IrregularPolygon,
		Elipse,
		Arc,
	}
	
	public ShapeType getType();
	public Color getColor();
	public Vector2[] getPoints();
	public IShape getTransformed(Transform transform);
	public boolean getOutline();
}