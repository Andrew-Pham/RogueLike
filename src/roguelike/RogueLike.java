/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike;

import com.googlecode.blacken.colors.ColorNames;
import com.googlecode.blacken.colors.ColorPalette;
import com.googlecode.blacken.swing.SwingTerminal;
import com.googlecode.blacken.terminal.BlackenKeys;
import com.googlecode.blacken.terminal.CursesLikeAPI;
import com.googlecode.blacken.terminal.FontNotFoundException;
import com.googlecode.blacken.terminal.TerminalInterface;
import com.googlecode.blacken.terminal.TerminalCellLike;
import com.googlecode.blacken.terminal.TerminalCell;

/**
 *
 * @author Andrew
 */
public class RogueLike {

    private ColorPalette palette;
    private CursesLikeAPI term = null;
    
    public void init() {
        
        TerminalInterface swing = new SwingTerminal();
        term = new CursesLikeAPI(swing);
        term.init("Simple", 25, 80);
        
        palette = new ColorPalette();
        palette.addAll(ColorNames.XTERM_256_COLORS, false);
        palette.putMapping(ColorNames.SVG_COLORS);
         
        term.setPalette(palette);
        
        term.setCurBackground("Black");
        term.setCurForeground("White");
        
        term.puts("@");
        
        int x = 0, y= 0;
        TerminalCellLike space = new TerminalCell(" ");
        TerminalCellLike player = new TerminalCell("@");
        
        while (true) {
            int ch = term.getch();
            
            if (ch == 115) {
                term.set(y, x, space);
                y++;
                term.set(y, x, player);
            }
            
            if (ch == 119) {
                term.set(y, x, space);
                y--;
                term.set(y, x, player);
            }
            
            if (ch == 97) {
                term.set(y, x, space);
                x--;
                term.set(y, x, player);
            }
            
            if (ch == 100) {
                term.set(y, x, space);
                x++;
                term.set(y, x, player);
            }
            System.out.println("character was: " + ch);
            term.refresh();
        }

    }   
 
    public static void main(String[] args) {
        
       RogueLike rl = new RogueLike();
       rl.init(); 
    }
}
