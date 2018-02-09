package week1.day1;

import java.util.Scanner;

public class PrintNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //AddNumbers obj = new AddNumbers();
         /*System.out.println(obj.getNumber(2, 8));
         
         System.out.println(obj.checkNumber(8));
         //System.out.println(obj.palCheck(453));*/
         
         int reversedNum = 0;

 	    int num = 12345;
 	    int reversedNum1 = num;

 	    while (num != 0)
 	    {
 	        reversedNum = reversedNum * 10 + num % 10;
 	        num = num / 10;
 	    }
 	    
 	    if (reversedNum1 == reversedNum){
 	    	System.out.println("palindrome");
 	    }else 
 	    System.out.println(  " is not palindrome");
         //System.out.println(obj.reverseInt());
		
		
	}

}
