package learnStringClass;

public class CountTheOccurences {

	public static void main(String[] args) {
		String str1 = "Wipro India Limited";
		int len1=str1.length();
		
		
		int j= 0;
		for(int i=0;i<=len1-1;i++)
		{
			char c = str1.toLowerCase().charAt(i);
			if(c=='i')
			{
				j++;
			}
			
		}
		System.out.println(j);
	}


	}


