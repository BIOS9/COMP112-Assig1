// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP112 - 2018T1, Assignment 1
 * Name: Matthew Corfiatis
 * Username: CorfiaMatt
 * ID: 300447277
 */

import ecs100.*;
import java.awt.Color;

/** Run SymbolDrawer methods  */
public class RunSymbolDrawer{
    public static void main(String[] arguments){
        SymbolDrawer sd = new SymbolDrawer();
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core: Hospital Sign",
            ()->sd.drawHospitalSign(100,100,UI.askDouble("How wide:")));
        UI.addButton("Core: Flag of Laos",
            ()->sd.drawLaosFlag(100,100,UI.askDouble("How wide:")));
        // COMPLETION
        UI.addButton("Core: Flag of UAE",
            ()->sd.drawUaeFlag(100,100,UI.askDouble("How wide:")));
        UI.addButton("Core: Flag of Greenland",
            ()->sd.drawGreenlandFlag(100,100,UI.askDouble("How wide:")));
        // CHALLENGE
        UI.addButton("Completion: Mitsubishi",
            ()->sd.drawMitsubishiLogo(100,100,UI.askDouble("How wide:")));
        UI.addButton("Completion: Koru Flag",
            ()->sd.drawKoruFlag(100,100,UI.askDouble("How wide:")));
        UI.addButton("Challenge: Chinese Flag",
                ()->sd.drawChinaFlag(100,100,UI.askDouble("How wide:")));
        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.3);
    }
}
