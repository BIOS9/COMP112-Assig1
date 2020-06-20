// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP112 - 2018T1, Assignment 1
 * Name: Matthew Corfiatis
 * Username: CorfiaMatt
 * ID: 300447277
 */

import ecs100.*;

/**
 * Draws various symbols: flags, signs, and car logos
 *
 * You can find lots of flag details (including the correct dimensions and colours)
 * from  http://www.crwflags.com/fotw/flags/    
 */
public class SymbolDrawer extends Symbols{
    /**   CORE
     * Draw the hospital sign - a blue square with a big white centred H.
     * The H is made of 3 rectangular strips
     */
    public void drawHospitalSign(double left, double top, double size) {
    	Transform transform = new Transform(
    			size, 0, 
    			0, size,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.HOSPITAL.getTransformed(transform));
    } 

    /**   CORE
     * Draw the flag of Laos.
     * The flag has three horizontal stripes with a white circle in the centre;
     * See the assignment for the dimensions.
     */
    public void drawLaosFlag(double left, double top, double width) {
    	Transform transform = new Transform(
    			width, 0, 
    			0, width,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.LAOS.getTransformed(transform));
    }

    /**   CORE
     * Draw the flag of the United Arab Emirates.
     * The flag has a vertical red stripe on the left, and
     * three horizontal stripes (green, white, black) on the right.
     * See the assignment for dimensions and details.
     */
    public void drawUaeFlag(double left, double top, double width) {
    	Transform transform = new Transform(
    			width, 0,
    			0, width,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.UAE.getTransformed(transform));
    }

    /**   CORE
     * Draw the flag of Greenland.
     * The top half of the flag is white, and the bottom half is red.
     * There is a circle in the middle (off-set to left)  which is
     * also half white/red but on the opposite sides.
     * See the assignment for dimensions
     */
    public void drawGreenlandFlag(double left, double top, double width) {
    	Transform transform = new Transform(
    			width, 0, 
    			0, width,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.GREENLAND.getTransformed(transform));
    }

    /**   COMPLETION
     * Draw the Misubishi Logo.
     */
    public void drawMitsubishiLogo(double left, double top, double size) {
    	Transform transform = new Transform(
    			size, 0, 
    			0, size,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.MITSUBISHI.getTransformed(transform));
    }

    /**   COMPLETION
     * Draw the Koru Flag.
     * It was one of the new flag designs for the 2016 referendum,
     * designed by Sven Baker from Wellington
     * The flag is 1/2 as high as it is wide (ratio 1:2).
     */
    public void drawKoruFlag(double left, double top, double width) {
    	Transform transform = new Transform(
    			width, 0, 
    			0, width,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.KORU.getTransformed(transform));
    }

    /**   CHALLENGE
     * Draw the flag of China.
     */
    public void drawChinaFlag(double left, double top, double width) {
    	Transform transform = new Transform(
    			width, 0, 
    			0, width,
    			new Vector2(left,top));
    	
        drawSymbol(Symbols.CHINA.getTransformed(transform));
    }

    /**
     * Draws each individual shape inside the specified symbol in the correct order and colour
     * @param symbol to draw
     */
    public void drawSymbol(Symbol symbol)
    {
    	for(int i = 0; i < symbol.shapes.length; i++)
    		drawShape(symbol.shapes[i]);
    }
    
    /**
     * Draws or fills multiple types of shape including arcs, ellipses and any irregular polygons
     * @param shape to draw
     */
    public void drawShape(IShape shape) 
    {
    	Vector2[] points = shape.getPoints();
    	UI.setColor(shape.getColor());
		switch(shape.getType())
		{
			case IrregularPolygon:
				double[] xP = new double[points.length];
				double[] yP = new double[points.length];
				for(int i = 0; i < points.length; i++)
				{
					xP[i] = points[i].X;
					yP[i] = points[i].Y;
				}
				if(shape.getOutline())
					UI.drawPolygon(xP, yP, points.length);
				else
					UI.fillPolygon(xP, yP, points.length);
				break;
			case Elipse:
				if(shape.getOutline())
					UI.drawOval(points[0].X, points[0].Y, points[1].X, points[1].Y);
				else
					UI.fillOval(points[0].X, points[0].Y, points[1].X, points[1].Y);
				break;
			case Arc:
				if(shape.getOutline())
					UI.drawArc(points[0].X, points[0].Y, points[1].X, points[1].Y, points[2].X, points[2].Y);
				else
					UI.fillArc(points[0].X, points[0].Y, points[1].X, points[1].Y, points[2].X, points[2].Y);
				break;
			default:
				break;
		}
	}
}
