 
/**
 * Storage class for paint volume calculations
 * @author Matthew Corfiatis
 */
public class PaintCalcResult {
	public double WallPaint;
	public double CeilingPaint;
	public double TotalPaint() { return WallPaint + CeilingPaint; };
	
	public PaintCalcResult(double wallPaint, double ceilingPaint)
	{
		WallPaint = wallPaint;
		CeilingPaint = ceilingPaint;
	}
}
