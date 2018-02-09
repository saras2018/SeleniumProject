package learnRegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyEmailPattern {

	public static void main(String[] args) {
		String email = "saraswathi.jaikumar@gmail.com";
		String pattern = "[a-zA-Z0-9]+.+[a-zA-Z0-9]+@+[a-z]{2,3}+.+[a-z]{3}+";
		
		Pattern pobj = Pattern.compile(pattern);
		Matcher match = pobj.matcher(email);
		System.out.println(match.matches());

	}

}
