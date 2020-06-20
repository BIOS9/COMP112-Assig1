 

// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP112 - 2018T1, Assignment 1
 * Name: Matthew Corfiatis
 * Username: CorfiaMatt
 * ID: 300447277
 */
import java.util.*;
import ecs100.*;

/** Program for calculating amount of paint required to paint a room */

public class PaintCalculator extends Door{

    public static final double DOOR_HEIGHT = 2.1;        // Height of the doors
    public static final double DOOR_WIDTH = 0.8;         // Width of the doors
    public static final double SQ_METERS_PER_LITRE = 15.0; // Area covered by 1 litre of paint

    double doorArea = DOOR_HEIGHT * DOOR_WIDTH;
    
    /** Calculates and prints litres of paint needed to paint
     *  - the four walls of a room (excluding the doors and windows)
     *  - the ceiling (different type of paint)
     */
    public void calculatePaintCore()
    {
    	Room room = askRoom();
    	PaintCalcResult result = calculatePaint(room);
        UI.printf("Paint required:\n\tCeiling: %.2fL\n\tWalls: %.2fL\n\tTotal: %.2fL\n", result.CeilingPaint, result.WallPaint, result.TotalPaint());
    }

    /** Determine the most economical selections of tins.
     */
    public void calculatePaintCompletion()
    {
    	Room room = askRoom();
    	PaintCalcResult result = calculatePaint(room);
    	
    	TinCalcResult wallTins = calculateTins(result.WallPaint);
    	TinCalcResult ceilingTins = calculateTins(result.CeilingPaint);
    	
        UI.printf("Paint required:\n\tCeiling: %.2fL\n\tWalls: %.2fL\n\tTotal: %.2fL\n", result.CeilingPaint, result.WallPaint, result.TotalPaint());
        UI.printf("Most economical paint tins:\n\tWall paint: %s\n\tCeiling paint: %s\n", generateTinString(wallTins), generateTinString(ceilingTins));
    }

    /**
     * Generates a string to display a TinCalcResult object.
     * @param tins Collection of tins to format
     * @return Formatted string containing number and type of paint tins
     */
    private String generateTinString(TinCalcResult tins)
    {
    	String str = "";
    	if(tins.TenL > 0)
    		str += tins.TenL + "x10L, ";
    	if(tins.FourL > 0)
    		str += tins.FourL + "x4L, ";
    	if(tins.TwoL > 0)
    		str += tins.TwoL + "x2L, ";
    	if(tins.OneL > 0)
    		str += tins.OneL + "x1L, ";
    	return str.substring(0, str.length() - 2);
    }	
    
    /**
     * Calculates the most economical set of tins that will achieve the required volume of paint.
     * @param paint Paint volume in litres
     * @return Most economical set of paint tins
     */
    private TinCalcResult calculateTins(double paint) //Assumes each size is 20% cheaper per litre than the next smaller size.
    {
    	TinCalcResult result = new TinCalcResult();
    	
    	result.TenL = (int)paint / 10;
        double remainder = paint % 10; //Makes remainder 0-<10

        if (remainder >= 8)
            result.TenL++;
        else
        {
        	result.FourL = (int)remainder / 4;
            remainder %= 4; //Makes remainder 0-<4

            if (remainder > 2)
            	result.FourL++;
            else if (remainder > 1)
            	result.TwoL++;
            else if (remainder > 0)
            	result.OneL++;
        }
        
        return result;
    }
    
    /**
     * Calculates the paint volume required for a room
     * @param room Dimensions of room + windows and doors
     * @return Object containing separate wall and ceiling paint volumes
     */
    private PaintCalcResult calculatePaint(Room room)
    {
    	double wallSurfaceArea = 2 * room.width * room.height; //2 opposite walls;        
        wallSurfaceArea += 2 * room.length * room.height; //2 other walls
        
        double ceilingSurfaceArea = room.length * room.width; //Ceiling
        
        for (Window window : room.windows) //Remove area of windows from surface area
        	wallSurfaceArea -= window.Area();
        
    	wallSurfaceArea -= room.doorNum * doorArea; //Remove area of doors from surface area
        
        double wallPaint = wallSurfaceArea / SQ_METERS_PER_LITRE;
        double ceilingPaint = ceilingSurfaceArea / SQ_METERS_PER_LITRE;
        
        return new PaintCalcResult(wallPaint, ceilingPaint);
    }
    
    
    /**
     * Parses user input for room dimensions, doors and windows.
     * -Handles format checking.
     * @return Room object created from user specifications.
     */
    private Room askRoom()
    {
    	String roomSize = "";
    	while(true)
    	{
    		roomSize = UI.askString("Enter room dimensions (metres) in the format: Width X Length X Height");
    		if(roomSize.matches("(?i:^((\\d|\\.\\d)+ x ){2}(\\d|\\.\\d)+$)")) //Decimal RegEx for "l x w x h" format. Allows decimals as ".123", "123" and "123.123"
    			break;
    		else
    			UI.print("Invalid room format!\n");
    	}
    	
    	String[] vals = roomSize.split("(?i: x )"); //Case insensitive split to get each number
    	Double[] doubleVals = new Double[vals.length];
    	for(int i = 0; i < vals.length; i++)
    		doubleVals[i] = Double.parseDouble(vals[i]); //Convert to double for room class
    	
    	int doorNum = UI.askInt("Enter number of doors in room: ");
    	
    	return new Room(
    			doubleVals[0], //Width
    			doubleVals[1], //Length
    			doubleVals[2], //Height
    			doorNum,	   //Doors
    			askWindows()); //Windows
    }
    
    /**
     * Parses user input for number and dimensions of windows.
     * -Handles format checking.
     * @return Array of window objects created from user input.
     */
    private Window[] askWindows()
    {
    	String windowStr = "";
    	while(true)
    	{
    		windowStr = UI.askString("For each window, enter it in the format: Number @ Width X Height (Press enter for no windows)");
    		
    		if(windowStr.matches("(^\\s+$)|(^$)")) //Empty string or whitespace
    			return new Window[0];
    		else if(windowStr.matches("(?i:^((\\d+ @ (\\d|\\.\\d)+ x (\\d|\\.\\d)+ )+)?(\\d+ @ (\\d|\\.\\d)+ x (\\d|\\.\\d)+)$)")) //Decimal RegEx for "a @ b x c" format. Allows decimals as ".123", "123" and "123.123"
    			break;
    		else
    			UI.print("Invalid window list format!\n");
    	}
    	String[] windowsStrArr = windowStr.split("(?=\\d+ @ (\\d|\\.\\d)+ [x|X] (\\d|\\.\\d)+)"); //Positive RegEx lookahead to split string into array of 1 @ b x c
    	ArrayList<Window> windows = new ArrayList<Window>(); //List of windows. Used list because the the number of total windows is not known initially
    	
    	for(int i = 0; i < windowsStrArr.length; i++) 
    	{
    		String[] wnd = windowsStrArr[i].replaceAll("(?i:@ |x )", "").split(" "); //removes @ and X from string. so string is just in format "a b c"
			int count = Integer.parseInt(wnd[0]); //Get first number to use in loop
    		
			for(int j = 0; j < count; j++) //For each window
				windows.add(new Window(Double.parseDouble(wnd[1]), Double.parseDouble(wnd[2])));
    	}
    	
    	return windows.toArray(new Window[0]); //Convert list to array and return it.
    }
}
