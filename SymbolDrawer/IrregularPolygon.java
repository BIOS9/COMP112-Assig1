import java.awt.Color;

/**
 * Scalable vector based irregular polygon graphic object.
 * -For use mainly with two dimensional matrix transformations to form images
 * @author Matthew Corfiatis
 */
public class IrregularPolygon implements IShape {
	public Color color = Color.black;
	public Vector2[] points = new Vector2[0];
	public boolean outline = false;
	
	public IrregularPolygon(){

	}
	public IrregularPolygon(Vector2[] points){
		this.points = points;
	}
	public IrregularPolygon(Vector2[] points, Color color){
		this.points = points;
		this.color = color;
	}
	public IrregularPolygon(Vector2[] points, Color color, boolean outline){
		this.points = points;
		this.color = color;
		this.outline = outline;
	}
	
	@Override
	public ShapeType getType() {
		return ShapeType.IrregularPolygon;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Vector2[] getPoints() {
		return points;
	}

	@Override
	public IShape getTransformed(Transform transform) {
		Vector2[] tempPoints = new Vector2[points.length];
		for(int i = 0; i < points.length; i++)
		{
			tempPoints[i] = transform.multiplyVector(points[i]);
		}
		return new IrregularPolygon(tempPoints, color, outline);
	}
	
	@Override
	public boolean getOutline()
	{
		return outline;
	}
}
