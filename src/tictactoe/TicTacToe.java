package tictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

 
public class TicTacToe extends JFrame implements ActionListener, TTTGamePlayMethods {
            
    /**
     * GUI Application main thread starts here.
     * Underlying there is another AWT-EventQueue thread running.
     * The GUI system internally will "listen" to user actions and invoke relevant Listener methods.
     * @param args is a String array of command line arguments 
     */
    public static void main(String[] args) {
        new TicTacToe();
        // After executing the constructor, the program is still running.
        // This is NOT the end of the whole application.
        // Java AWT GUI stuff will take over.
    }    


    
    /** given instance field declarations */
    
    /** tttBoard is a 2D array of TTTButton (that is a subclass of JButton) */
    protected TTTButton[][] tttBoard;
    /** moveCount starts from 0, increment by one on each valid move, max is 9 */
    protected int moveCount;
    /** turn indicates current player, either 'X' or 'O'; first player is always 'X' */
    protected char turn;


    
    /**
     * Constructor prepares an object that is from subclass of JFrame.
     * Given, students need NOT modify.
     */
    public TicTacToe()
    {
        // basic JFrame properties
        setTitle(getClass().getSimpleName());
        setSize(300, 350);
        setLocation(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TicTacToe board user interface
        setLayout(new GridLayout(3, 3));
        tttBoard = new TTTButton[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                String coord = "" + row + "," + col;
                tttBoard[row][col] = new TTTButton();
                tttBoard[row][col].setText(coord);
                tttBoard[row][col].setActionCommand(coord);
                tttBoard[row][col].addActionListener(this);
                add(tttBoard[row][col]);
            }
        
        setVisible(true);
        
        // fields initialization
        moveCount = 0;
        turn = 'X';

        // initial screen output
        System.out.println(getClass().getSimpleName());
        System.out.println("Initial empty board on screen:");
        System.out.println(this);
        System.out.println("Turn: " + turn + '\n');
    }

    /**
     * Implementation of abstract method in ActionListener interface.
     * This method is invoked by the Java GUI system internally (in an AWT thread.)
     * Given code, students need NOT modify.
     * @param event is encapsulating details of the button click
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String coord = event.getActionCommand();
        int row = coord.charAt(0) - '0';
        int col = coord.charAt(2) - '0';
        
        // send message to student's makeMove() method, providing row and col of the move
        makeMove(row, col);
    }
    
    /**
     * Overridden toString() method to represent the game as a String.
     * @return String representation of the board
     * Given, need not modify
     */
    @Override
    public String toString()
    {
        String result = "";
        for (int row = 0; row < 3; row++, result += '\n')
            for (int col = 0; col < 3; col++, result += " ")
                if (tttBoard[row][col].getPiece() == ' ')
                    result += "_";
                else
                    result += tttBoard[row][col].getPiece();
        return result;
    }
    
    
    
    /**
     * User of current "turn" clicked on a TTTButton at (row, col), trying to make a move.
     * 0) echo user action on console screen
     * 1) setPiece 'X' or 'O' at the target button on the 2D array tttBoard;
     *    if failed (target occupied,) return without action
     * 2) update moveCount and PRINT(this) TicTacToe game
     * 3) if checkWin() got a winner, print "X Win" or "O Win"
     * 4) if no winner but draw game, print "Draw Game"
     * 5) on end game, disableTTTBoard(); otherwise changeTurn()
     * 6) return;
     * @param row of the clicked button
     * @param col of the clicked button
     */
    public void makeMove(int row, int col)
    {
        // Given, echo user action on console screen
        if(tttBoard[row][col].getPiece()!='O'&&tttBoard[row][col].getPiece()!='X'){
        System.out.println((moveCount+1) + ") Player " + turn + " clicked button at (" + row + ", " + col + ")");

        // STUDENT'S WORK HERE
        tttBoard[row][col].setPiece(turn);
        moveCount++;
         System.out.println(this);
     
        if(this.checkWin(row,col)==true){
            System.out.println(turn+" Won");
            this.disableTTTBoard();
        }else{
            if(this.checkDrawGame()){
            System.out.println("Draw Game");
            this.disableTTTBoard();
        }else{
                 this.changeTurn();
            }
     
        }
        
        }else{
             System.out.println((moveCount+1) + ") Player " + turn + " clicked button at (" + row + ", " + col + ")");
        }
        


    }
    
    // STUDENT'S WORK HERE

   
    
    
    
    /**
     * Check draw game condition based on moveCount.
     * @return true on draw game
     */
    public boolean checkDrawGame(){
        return moveCount==9;
        
    }
    
    /**
     * Check winner based on connect-3 condition.
     * @param row of the latest move
     * @param col of the latest move
     * @return true if current turn is a winner
     */
    @Override
    public boolean checkWin(int row, int col){
         if(row==0&&col==0){
             if(tttBoard[0][0]==tttBoard[1][1]&&tttBoard[1][1]==tttBoard[2][2]){
              return true; }
             if(tttBoard[0][0]==tttBoard[0][1]&&tttBoard[0][1]==tttBoard[0][2]){
              return true; }
             if(tttBoard[0][0]==tttBoard[1][0]&&tttBoard[1][0]==tttBoard[2][0]){
              return true; }
         
    }else if(row==0&&col==1){
         if(tttBoard[0][1].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][1].getPiece()){
              return true; }
             if(tttBoard[0][0].getPiece()==tttBoard[0][1].getPiece()&&tttBoard[0][1].getPiece()==tttBoard[0][2].getPiece()){
              return true; }        
    }else if(row==0&&col==2){
            if(tttBoard[0][2].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][0].getPiece()){
              return true; }
             if(tttBoard[0][0].getPiece()==tttBoard[0][1].getPiece()&&tttBoard[0][1].getPiece()==tttBoard[0][2].getPiece()){
              return true; }
             if(tttBoard[0][2].getPiece()==tttBoard[1][2].getPiece()&&tttBoard[1][2].getPiece()==tttBoard[2][2].getPiece()){
              return true; }

    }else if(row==1&&col==0){
          if(tttBoard[0][0].getPiece()==tttBoard[1][0].getPiece()&&tttBoard[1][0].getPiece()==tttBoard[2][0].getPiece()){
              return true; }
            if(tttBoard[1][0].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[1][2].getPiece()){
              return true; }   

        
    }else if(row==1&&col==1){
        if(tttBoard[1][0].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[1][2].getPiece()){
              return true; } 
        if(tttBoard[0][1].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][1].getPiece()){
              return true; }
        if(tttBoard[0][0].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
        
        if(tttBoard[0][2].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][0].getPiece()){
              return true; }
     }else if(row==1&&col==2){
        if(tttBoard[1][0].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[1][2].getPiece()){
              return true; } 
        if(tttBoard[0][0].getPiece()==tttBoard[1][2].getPiece()&&tttBoard[1][2].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
        
    }else if(row==2&&col==0){
        if(tttBoard[0][0].getPiece()==tttBoard[1][0].getPiece()&&tttBoard[1][0].getPiece()==tttBoard[2][0].getPiece()){
              return true; }
        if(tttBoard[2][0].getPiece()==tttBoard[2][1].getPiece()&&tttBoard[2][1].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
        if(tttBoard[0][2].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][0].getPiece()){
              return true; }
        
    }else if(row==2&&col==1){
           if(tttBoard[2][1].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[0][1].getPiece()){
              return true; } 
           if(tttBoard[2][0].getPiece()==tttBoard[2][1].getPiece()&&tttBoard[2][1].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
        
    }else if(row==2&&col==2){
         if(tttBoard[2][0].getPiece()==tttBoard[2][1].getPiece()&&tttBoard[2][1].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
          if(tttBoard[0][2].getPiece()==tttBoard[1][2].getPiece()&&tttBoard[1][2].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
           if(tttBoard[0][0].getPiece()==tttBoard[1][1].getPiece()&&tttBoard[1][1].getPiece()==tttBoard[2][2].getPiece()){
              return true; }
        
    }
        return false;
    
        
    }

    /*
     * Change turn AND print turn information.
     */
    @Override
    public void changeTurn()
    {
        if(moveCount<9){
        if(turn=='X'){
             turn='O';
             System.out.println("Turn: "+turn);
        } else{
         turn='X';
          System.out.println("Turn: "+turn);
        }
        
        }
       
        
    }

    /**
     * Disable all buttons one-by-one in the tttBoard array using the inherited JButton method setEnabled().
     */
    public void disableTTTBoard(){
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                
                tttBoard[row][col].setEnabled(false);
            }
            
           
        }
        
        
    }

    
    
    
    
    

} // end of class TicTacToe
