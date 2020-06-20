import java.awt.Color;

/**
 * Symbol storage class for scalable vector graphic symbols
 * -Each symbol is scaled to 1 unit wide by default
 * @author Matthew Corfiatis
 */
public class Symbols {
	private static Vector2[] mitsubishiDiamond = new Vector2[] { //
			new Vector2(0, 0),
			new Vector2(-5, -9),
			new Vector2(0, -18),
			new Vector2(5, -9)};
	
	public static Vector2[] star = new Vector2[] { //Star vertices with a circular diameter of 1 unit
			new Vector2(0, 0.5),
			new Vector2(-0.112257, 0.1545085),
			new Vector2(-0.4755283, 0.1545085),
			new Vector2(-0.1816356, -0.059017),
			new Vector2(-0.2938926, -0.4045085),
			new Vector2(1.707521E-08, -0.190983),
			new Vector2(0.2938927, -0.4045085),
			new Vector2(0.1816356, -0.05901698),
			new Vector2(0.4755282, 0.1545086),
			new Vector2(0.112257, 0.1545085),
	};
	
	public static final Symbol HOSPITAL = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] {//background
					new Vector2(0, 0),
					new Vector2(0, 8),
					new Vector2(8, 8),
					new Vector2(8, 0),
			}, Color.blue),
			
			new IrregularPolygon(new Vector2[] {//Letter H
					new Vector2(2, 1.5),
					new Vector2(3, 1.5),
					new Vector2(3, 3.5),
					new Vector2(5, 3.5),
					new Vector2(5, 1.5),
					new Vector2(6, 1.5),
					new Vector2(6, 6.5),
					new Vector2(5, 6.5),
					new Vector2(5, 4.5),
					new Vector2(3, 4.5),
					new Vector2(3, 6.5),
					new Vector2(2, 6.5),
			}, Color.white),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 8),
					new Vector2(8, 8),
					new Vector2(8, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/8d, 0, 0, 1d/8d)); //Divide by 8 to scale to 1;
	
	public static final Symbol UAE = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] { //Red stripe
					new Vector2(0, 0),
					new Vector2(0, 6),
					new Vector2(3, 6),
					new Vector2(3, 0),
			}, Color.decode("0xFE0000")),
			
			new IrregularPolygon(new Vector2[] { //Green strip
					new Vector2(3, 0),
					new Vector2(3, 2),
					new Vector2(12, 2),
					new Vector2(12, 0),
			}, Color.decode("0x00732E")),
			
			new IrregularPolygon(new Vector2[] { //White strip
					new Vector2(3, 2),
					new Vector2(3, 4),
					new Vector2(12, 4),
					new Vector2(12, 2),
			}, Color.white),
			
			new IrregularPolygon(new Vector2[] { //Black strip
					new Vector2(3, 4),
					new Vector2(3, 6),
					new Vector2(12, 6),
					new Vector2(12, 4),
			}, Color.black),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 6),
					new Vector2(12, 6),
					new Vector2(12, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/12d, 0, 0, 1d/12d)); //Divide by 12 to scale width to 1
	
	public static final Symbol LAOS = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] { //Red background
					new Vector2(0, 0),
					new Vector2(0, 20),
					new Vector2(30, 20),
					new Vector2(30, 0),
			}, Color.RED),
			
			new IrregularPolygon(new Vector2[] { //Blue strip
					new Vector2(0, 5),
					new Vector2(0, 15),
					new Vector2(30, 15),
					new Vector2(30, 5),
			}, Color.decode("0x000099")),
			
			new Elipse(							//White circle
					new Vector2(11, 6),
					new Vector2(8, 8),
					Color.white),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 20),
					new Vector2(30, 20),
					new Vector2(30, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/30d, 0, 0, 1d/30d)); //Divide by 30 to scale width to 1;
	
	public static final Symbol GREENLAND = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] { //White strip
					new Vector2(0, 0),
					new Vector2(0, 6),
					new Vector2(18, 6),
					new Vector2(18, 0),
			}, Color.white),
			
			new IrregularPolygon(new Vector2[] { //Red strip
					new Vector2(0, 6),
					new Vector2(0, 12),
					new Vector2(18, 12),
					new Vector2(18, 6),
			}, Color.red),
			
			new Arc(							//Red arc
					new Vector2(3, 2),
					new Vector2(8, 8),
					new Vector2(0, 180),
					Color.red),
			
			new Arc(							//White arc
					new Vector2(3, 2),
					new Vector2(8, 8),
					new Vector2(0, -180),
					Color.white),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 12),
					new Vector2(18, 12),
					new Vector2(18, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/18d, 0, 0, 1d/18d)); //Divide by 18 to scale to 1;
	
	public static final Symbol MITSUBISHI = new Symbol(new IShape[] {
			new IrregularPolygon(mitsubishiDiamond, Color.red),	
			
			new IrregularPolygon(mitsubishiDiamond, Color.red).getTransformed(Transform.rotationMatrix(120)), //Rotate diamond by 120 degrees
			
			new IrregularPolygon(mitsubishiDiamond, Color.red).getTransformed(Transform.rotationMatrix(-120)), //Rotate diamond by -120 degrees
			
			/*new IrregularPolygon(new Vector2[] { //Outline
					new Vector2(-15.588, -18),
					new Vector2(15.588, -18),
					new Vector2(15.588, 9),
					new Vector2(-15.588, 9),
			}, Color.black, true)*/
	}).getTransformed(new Transform(1, 0, 0, 1, new Vector2(15.588, 18))) //Move offset from centre to top left
			.getTransformed(new Transform(1d/31.176, 0, 0, 1d/31.176)); //Divide by 18 to scale width to 1

	public static final Symbol KORU = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] { //Red strip
					new Vector2(0, 0),
					new Vector2(0, 10),
					new Vector2(10, 10),
					new Vector2(10, 0),
			}, Color.decode("0xEA1B23")),
			
			new IrregularPolygon(new Vector2[] { //Blue background
					new Vector2(10, 0),
					new Vector2(10, 10),
					new Vector2(20, 10),
					new Vector2(20, 0),
			}, Color.decode("0x1B3276")),
			
			new Arc(							//Arc between bottom edge of flag and koru
					new Vector2(4.5, -0.5),
					new Vector2(11, 11),
					new Vector2(295, 65),
					Color.white),
			
			new Elipse(							//Blue circle to cut radial path
					new Vector2(11.05, 2.4),
					new Vector2(5, 5),
					Color.decode("0x1B3276")),
			
			new Arc(							//Arc between koru end and top edge of flag
					new Vector2(4.5, -0.5),
					new Vector2(11, 11),
					new Vector2(0, 65),
					Color.white),
			
			new Arc(							//Arc between top and bottom edges of flag
					new Vector2(4.5, -0.5),
					new Vector2(11, 11),
					new Vector2(115, 130),
					Color.white),
			
			new IrregularPolygon(new Vector2[] { //Circle top and bottom fix
					new Vector2(7.7, 0),
					new Vector2(7.7, 10),
					new Vector2(12.34, 10),
					new Vector2(12.34, 0),
			}, Color.white),
			
			new Elipse(							//Blue circle fill
					new Vector2(6, 1),
					new Vector2(8, 8),
					Color.decode("0x1B3276")),
			
			new Elipse(							//White koru end circle
					new Vector2(11.5, 2.9),
					new Vector2(4, 4),
					Color.white),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 10),
					new Vector2(20, 10),
					new Vector2(20, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/20d, 0, 0, 1d/20d)); //Divide by 20 to scale width to 1;
	
	public static final Symbol CHINA = new Symbol(new IShape[] {
			new IrregularPolygon(new Vector2[] { //Red background
					new Vector2(0, 0),
					new Vector2(0, 20),
					new Vector2(30, 20),
					new Vector2(30, 0),
			}, Color.decode("0xDE2910")),
			
			new IrregularPolygon(star, Color.decode("0xFFDE00"))
			.getTransformed(Transform.X(
					Transform.rotationMatrix(36), 	//Rotate star by 36 degrees to make star correct orientation
					new Transform(6, 0, 0, 6, new Vector2(5, 5)))), //Scale star by 6 to make main star size and move it to be in correct position
			
			new IrregularPolygon(star, Color.decode("0xFFDE00"))
			.getTransformed(Transform.X(
					Transform.rotationMatrix(59.036),
					new Transform(2, 0, 0, 2, new Vector2(10, 2)))),
			
			new IrregularPolygon(star, Color.decode("0xFFDE00"))
			.getTransformed(Transform.X(
					Transform.rotationMatrix(81.869),
					new Transform(2, 0, 0, 2, new Vector2(12, 4)))),
			
			new IrregularPolygon(star, Color.decode("0xFFDE00"))
			.getTransformed(Transform.X(
					Transform.rotationMatrix(-38.055),
					new Transform(2, 0, 0, 2, new Vector2(12, 7)))),
			
			new IrregularPolygon(star, Color.decode("0xFFDE00"))
			.getTransformed(Transform.X(
					Transform.rotationMatrix(-15.34),
					new Transform(2, 0, 0, 2, new Vector2(10, 9)))),
			
			new IrregularPolygon(new Vector2[] { //Flag outline
					new Vector2(0, 0),
					new Vector2(0, 20),
					new Vector2(30, 20),
					new Vector2(30, 0),
			}, Color.black, true),
	}).getTransformed(new Transform(1d/30d, 0, 0, 1d/30d)); //Divide by 30 to scale width to 1;
}
