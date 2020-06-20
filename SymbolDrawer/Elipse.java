import java.awt.Color;

/**
 * Scalable vector based elipse graphic object.
 * -For use mainly with two dimensional matrix transformations to form images
 * @author Matthew Corfiatis
 */
public class Elipse implements IShape {
	public Color color = Color.black;
	public Vector2 position = new Vector2();
	public Vector2 size = new Vector2();
	public boolean outline = false;
	
	public Elipse(){

	}
	public Elipse(Vector2 position, Vector2 size){
		this.position = position;
		this.size = size;
	}
	public Elipse(Vector2 position, Vector2 size, Color color){
		this.position = position;
		this.size = size;
		this.color = color;
	}
	public Elipse(Vector2 position, Vector2 size, Color color, boolean outline){
		this.position = position;
		this.size = size;
		this.color = color;
		this.outline = outline;
	}
	
	@Override
	public ShapeType getType() {
		return ShapeType.Elipse;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public Vector2[] getPoints() {
		return new Vector2[] { position, size };
	}
	
	@Override
	public IShape getTransformed(Transform transform) {
		Vector2 tempPosition = transform.multiplyVector(position);
		Vector2 tempSize = Vector2.subtract( //Remove new position from size after transform.
				transform.multiplyVector(Vector2.add(size, position)), //Add position to size before transform
						tempPosition);
		return new Elipse(tempPosition, tempSize, color, outline);
	}

	@Override
	public boolean getOutline() {
		return outline;
	}
}
