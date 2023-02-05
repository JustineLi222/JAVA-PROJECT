/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.util.Scanner;

/**
 *
 * @justine222
 */
//this is a simple calculator that operate simple operations.
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int x;
        double y;
        char operator;
        Scanner keyboard = new Scanner(System.in);
     /* here is the demonstration how to use the calculator:
      first: type in the first number(it must be integer) e.g 1 then press enter
      then enter the operator(only allow +.-,*,^) and then press enter
    finally , enter the second input(must be integer) and then press enter
        if you want to calculate squart root use decimal number don't enter fractions
        e.g sqrt(2) = 2^0.5 not 2^1/2
        */
   

        System.out.println("what do you want to calcuate?");
        //you need to enter the input one by one

        x=keyboard.nextInt();
       
        //because there are no keyboard.char() in java so we need to collect the char as a string and then use charAt(0) to obtain the operator
        operator=keyboard.next().charAt(0);
     
        y=keyboard.nextDouble();
     
      switch(operator){
          case '+':
              System.out.printf("%d+%f = %f\n",x,y,x+y);
            break;
          case'-':
              System.out.printf("%d-%f = %f\n",x,y,x-y);
              break;
          case'*':
              System.out.printf("%d x %f = %f\n",x,y,x*y);
              break;
          case'/':
              try{
                  //exception handling in case the denominator is 0
              System.out.printf("%d / %f= %f\n",x,y,x/y);
              }catch(Exception e){
                  System.out.println("error!!! ");
              }
              break;
          case'^':
              System.out.printf("%d ^ %f = %f", x,y,Math.pow(x, y));
              break;
          default:
              System.out.printf("SORRY WE CAN'T DO %c operation",operator);
           break;
      }
        
    }
    
}
