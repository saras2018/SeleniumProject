package week1.day1;

public class AddNumbers {
	
	public int getNumber(int i,int j){
	 return(i+j);

}
	public String checkNumber(int a){
	  if (a%2==0){
		  return("Even");
	  }else {
		  return("Odd");
	  }
	
	}
	
	public int reverseInt(int input)
	{
	    long reversedNum = 0;

	    long input_long = input;

	    while (input_long != 0)
	    {
	        reversedNum = reversedNum * 10 + input_long % 10;
	        input_long = input_long / 10;
	    }

	    /*if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
	    {
	        throw new IllegalArgumentException();
	    }*/
	    return (int)reversedNum;
	}
	
	 
	}
	
	


