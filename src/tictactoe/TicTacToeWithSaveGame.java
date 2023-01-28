package tictactoe;


import java.io.File;
import java.io.PrintStream;


public class TicTacToeWithSaveGame extends TicTacToe {
    
    private PrintStream ps;
    
    /**
     * Constructor prepares an object that is from subclass of TicTacToe.
     * This constructor simply redirects System.out to file "ttt.txt"
     * It shall use simple try-catch to silent all PrintStream related Exceptions.
     */
    public TicTacToeWithSaveGame()
    {
        /* Students' work here */
       
        /* Just a few lines of code; all the rest are handled in the superclass */
       
        try{
           
            ps = new PrintStream(new File("ttt.txt.txt"));      
            System.setOut(ps);
            ps.print(new TicTacToe());
        }catch(Exception e){
           
        }
        




    }
    
    /**
     * GUI Application main thread starts here.
     * Underlying there is another AWT-EventQueue thread running.
     * The GUI system internally will "listen" to user actions and invoke relevant Listener methods.
     * @param args is a String array of command line arguments 
     */
    public static void main(String[] args) {
        new TicTacToeWithSaveGame();
        // After executing the constructor, the program is still running.
        // This is NOT the end of the whole application.
        // Java AWT GUI stuff will take over.
    }        
}
