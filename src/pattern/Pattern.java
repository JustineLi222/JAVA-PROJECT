/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pattern;

import java.io.File;
import java.io.PrintStream;

/**
 *
 * @author ASUS
 */
public class Pattern {

    /**
     * @param args the command line arguments
     */
    public void printPattern(String filename, int N){
          int counter=1;
          int counter2=0;
          int counter3=1;
        try{
        File file = new File(filename);
        PrintStream p = new PrintStream(file);
        if(N<=0||N%2==0){
            
            
        }
        else{
           
            for(int i=1;i<=N+2;i++){
              
                if(i==1){
                for(int f=1;f<=N+2;f++){
                    
                  p.print("X");
                    
                }
                
                }
                if(i>1&&i<N+2){
                    
                    if(N>1&&i>=2&&i<=(N/2+1)){
                        for(int m=1;m<=N/2-i+2;m++){
                        p.print("X");
                    }
                        p.print("/");
                     for(int a=1;a<=counter-2;a++){
                         
                         p.print("*");
                     }
                        
                         p.print("\\");
                          for(int m=1;m<=N/2-i+2;m++){
                        p.print("X");
                    }
                 
                        
                    }
      
                    if(i==(N/2)+2){
                       p.print("X");
                        for(int a=1;a<=N;a++){
                            p.print("#");
                        } 
                  
                         p.print("X");
                     
                           
                    }
              
                    if(N>1&&i>(N/2+2)){
                        
                        for(int a=1;a<=counter3;a++){
                         
                         p.print("X");
                     }

                        p.print("\\");
                        for(int j=N-2-counter2;j>=1;j--){
                           p.print("*");
                        } 
                       p.print("/");
                         for(int a=1;a<=counter3;a++){
                         
                         p.print("X");
                     }
                        
                        counter2=counter2+2;
                         counter3++;
                   
                    
                   
                    }
                    
                    
                    
                    
                    
                    
                    
                }
                if(i==N+2){
                
                for(int f=1;f<=N+2;f++){
                
                    p.print("X");
                    
                }
                }
                p.println();
                counter=counter+2;
  
            }
               
            
            
            
        }
        
        
    }
        catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Pattern().printPattern("hi",9);
    }
    
}
