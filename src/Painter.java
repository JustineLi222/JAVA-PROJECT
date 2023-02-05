/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package painter;

/**
 *
 * @author JustineLI222
 */


// imports for BufferedImage, Graphics, Color, Random, etc.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Painter application for drawing things in a dialog
 * Practice: declaring a class with constructor and instance fields and methods
 * declaring and invoking methods with parameters
 * random number generation
 * looping and branching
 * user interaction with JOptionPane
 *
 * CSCI1130 Java Assignment 3 Painter
 *
 *
 */
public class Painter {
    
    // ALL static and instance fields are given, DO NOT MODIFY
    
    /* fixed image width for this assignment */
    public static final int IMAGE_WIDTH  = 480;
    /* fixed image height for this assignment */
    public static final int IMAGE_HEIGHT = 320;

    /** we need to draw an image using its Graphics context object, a drawing pen */
    private Graphics pen;
    
    /** an ImageIcon object to display in JOptionPane dialog */
    private ImageIcon icon;
   
    /**
     * Constructor is given, DO NOT MODIFY
     */
    public Painter() {
        /* create a new image of designed dimensions; with AlphaRedGreenBlue colors */
        BufferedImage img = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        /* create an ImageIcon for display in dialog */
        icon = new ImageIcon(img);

        /* create a pen for drawing, the pen is to be used by paint methods */
        pen = img.createGraphics();
    }

    /**
     * Paint method controlled by user through JOptionPane dialog
     * Students shall finish the rest of this given method
     */
    public void paintByUser()
    {
        clearCanvas();

        /* given paint example */
        paintExample();
        
        /* test patterns at the four corners, DO NOT MODIFY */
        paintStar(0, 0);
        paintStar(IMAGE_WIDTH-1, IMAGE_HEIGHT-1);
        paintRing(0, IMAGE_HEIGHT-1, 3);
        paintRing(IMAGE_WIDTH-1,  0, 3);
        
        /* forever loop is given */
        for ( ; ; )
        {
            // given JOptionPane code
            String title   = "Painter";
            String message = "Pick";
            Object[] options = {"Star", "Ring", "Clear"};
            int response;
            response = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, null);
            System.out.println("Response = " + response);

            
            
            // STUDENT WORK HERE
            Random num = new Random() ;
            int width ;
            int height;
            if(response==0){
                
                for(int j=1;j<=5;j++){
                  width = num.nextInt(480-1);
                 height= num.nextInt(320-1);
                    
                    this.paintStar(width, height);
                    
                }
                
                
            }
            if(response==1){
                
                  
                  
                  //loop for 5 times
                 for(int i=1;i<=5;i++){
                     
                     width = num.nextInt(480-1);
                  height= num.nextInt(320-1);
                     this.paintRing(width,height,i);
                     
                 }
                 
                
                  
            }
           if(response==2){
              
               this.clearCanvas();
               
           }
           if(response==-1){
               System.exit(0);
            
        }
    }
    }

    /**
     * Paint example method is given, DO NOT MODIFY
     */
    public void paintExample()
    {
        /* a Graphics pen object can be used to draw a lot of color things */
        pen.setColor(Color.RED);
        pen.fillOval(130, 120, 20, 7); // draw an oval with top-left corner at (130, 120)
        
        pen.setColor(Color.GREEN);
        pen.fillOval(100-1, 50-1, 3, 3); // draw an oval "dot" centered at (100, 50) of size 3 x 3

        // draw an oval (circle) center at (30, 170) of size 20 x 20
        // top-left corner shall be at (30-20/2, 170-20/2), i.e., (20, 160)
        int centerX = 30;
        int centerY = 170;
        pen.setColor(Color.BLUE);
        pen.fillOval(centerX-10, centerY-10, 20, 20);
    }
    
    /**
     * Paint a Star (crossing of two ovals) of dimensions 20 x 20
     * Paint a WHITE oval of size 20 x 7
     * Paint a YELLOW oval of size 7 x 20
     * Adjust location of the ovals properly
     * @param centerX indicates center X-coordinate
     * @param centerY indicates center Y-coordinate
     */
    public void paintStar(int centerX, int centerY)
    {
        // STUDENT WORK HERE
        
        pen.setColor(Color.white);
        pen.fillOval(centerX -10, centerY -7/2, 20, 7);
        //we minus centerX by 10 because we need to adjust the location of stars to corners
        pen.setColor(Color.yellow);
        pen.fillOval(centerX+7 -10, centerY-7-7/2, 7, 20);
        
        
    }
    
    /**
     * Paint a Ring color pattern of outer dimensions (size * 20, size * 20)
     * Max dimensions: 100 x 100 if size is 5
     * Min dimensions:  20 x  20 if size is 1
     * Fill 10 concentric equidistance ovals (circles) with changing solid colors
     * from outside to inside in sequence R-G-B-R-G-B-R-G-B-R
     * @param centerX indicates center X-coordinate
     * @param centerY indicates center Y-coordinate
     * @param size is an int of value 1, 2, 3, 4 or 5
     */
    public void paintRing(int centerX, int centerY, int size)
    {
        // STUDENT WORK HERE
        //middlex and middley are the center of the circle but not upper top left corner of the rectangle
        int middlex = centerX+size*10;
        int middley = centerY+size*10;
       
       pen.setColor(Color.red);
       //we minus centerX by 30 because we need to adjust the ring to upper left corner and lower right corner
      pen.fillOval(centerX-30, centerY-30, size*20, size*20);
       pen.setColor(Color.green);
       
      pen.fillOval(middlex-size*18/2-30, middley-size*18/2-30, size*18, size*18);
      
      pen.setColor(Color.blue);
      pen.fillOval(middlex-(size*16)/2-30, middley-(size*16)/2-30, size*16, size*16);
      
           pen.setColor(Color.red);
         pen.fillOval(middlex-(size*14)/2-30,  middley-(size*14)/2-30, size*14, size*14);
     pen.setColor(Color.green);
        pen.fillOval(middlex-(size*12)/2-30,  middley-(size*12)/2-30, size*12, size*12);
      
       pen.setColor(Color.blue);
       pen.fillOval(middlex-(size*10)/2-30,  middley-(size*10)/2-30, size*10, size*10);
 pen.setColor(Color.red);
         pen.fillOval(middlex-(size*8)/2-30, middley-(size*8)/2-30, size*8, size*8);
     pen.setColor(Color.green);
        pen.fillOval(middlex-(size*6)/2-30,  middley-(size*6)/2-30, size*6, size*6);
      
       pen.setColor(Color.blue);
       pen.fillOval(middlex-(size*4)/2-30,  middley-(size*4)/2-30, size*4, size*4);
        pen.setColor(Color.red);
         pen.fillOval(middlex-(size*2)/2-30,  middley-(size*2)/2-30, size*2, size*2);
     
       
      
      
     
         
      
       
      

        
      
      

   
    
      
        
    }

    /**
     * Clear canvas to BLACK
     * DO NOT MODIFY
     */
    public void clearCanvas()
    {
        pen.setColor(Color.BLACK);
        pen.clearRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }    
    
    /**
     * main method is given, DO NOT MODIFY
     * @param args is a String array keeping command line arguments 
     */
    public static void main(String[] args) {
        Painter obj;
        
        // construct a new Painter object
        obj = new Painter();
        
        // send message to the new Painter object to kick start actions
        obj.paintByUser();
    }

}
