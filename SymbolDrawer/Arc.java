import java.awt.Color;

/**
 * Scalable vector based arc graphic object.
 * -For use mainly with two dimensional matrix transformations to form images
 * @author Matthew Corfiatis
 */
public class Arc implements IShape {
	public Color color = Color.black;
	public Vector2 position = new Vector2();
	public Vector2 size = new Vector2();
	public Vector2 angles = new Vector2();
	public boolean outline = false;
	
	public Arc(){

	}
	public Arc(Vector2 position, Vector2 size, Vector2 angles){
		this.position = position;
		this.size = size;
		this.angles = angles;
	}
	public Arc(Vector2 position, Vector2 size, Vector2 angles, Color color){
		this.position = position;
		this.size = size;
		this.angles = angles;
		this.color = color;
	}
	public Arc(Vector2 position, Vector2 size, Vector2 angles, Color color, boolean outline){
		this.position = position;
		this.size = size;
		this.angles = angles;
		this.color = color;
		this.outline = outline;
	}
	
	@Override
	public ShapeType getType() {
		return ShapeType.Arc;
	}

	@Override
	public Vector2[] getPoints() {
		return new Vector2[] { position, size, angles };
	}

	@Override
	public IShape getTransformed(Transform transform) {
		Vector2 tempPosition = transform.multiplyVector(position);
		Vector2 tempSize = Vector2.subtract( //Remove new position from size after transform.
				transform.multiplyVector(Vector2.add(size, position)), //Add position to size before transform
						tempPosition);
		return new Arc(tempPosition, tempSize, angles, color, outline); //Retains same angles
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	@Override
	public boolean getOutline() {
		return outline;
	}
}
