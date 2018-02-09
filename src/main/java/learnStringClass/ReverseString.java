package learnStringClass;

public class ReverseString {

	public static void main(String[] args) {
		String str = "hexaware";
		int len = str.length();
		for (int i=len-1;i>=0;i--){
			//System.out.print(i);
			System.out.print(str.charAt(i));
		}
		


	}

}
