/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package image;

/**
 *
 * @author ASUS
 */
public class Image {
    protected int w,h;
    protected Color[][] pixels;
    /**
     * @param args the command line arguments
     */
    public Image(int weight,int height){
      
        w=weight;
        h=height;
        for(int i=0;i<h;i++){
            for(int j =0;j<w;j++){
                
                pixels[h][w]=new Color(255,17,8);
            }

        }

    }
    protected void adjusted(int delta){
        
      
        
    }
    public Image enlargeByDouble(){
        Image U = new Image(this.w*2,this.h*2);
        
  
          return U;
          
      }
        
        
    }



    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    

