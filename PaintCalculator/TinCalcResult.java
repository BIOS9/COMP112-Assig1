/**
 * Storage class for tin optimization calculations
 * @author Matthew Corfiatis
 */
public class TinCalcResult
{
	public int TenL;
	public int FourL;
	public int TwoL;
	public int OneL;
	
	public TinCalcResult() {}
	
	public TinCalcResult(int ten, int four, int two, int one)
	{
		TenL = ten;
		FourL = four;
		TwoL = two;
		OneL = one;
	}
}