package LearnMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class countOfEachCharacter {

	public static void main(String[] args) {
		String str = "sea shells on the sea shore";
		str = str.replaceAll("\\s+", "");
		char[] ch = str.toCharArray();
		int j=1,i=1;
		Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		for (char c : ch) {
			if(map.containsKey(c)){
				j = map.get(c)+1;

			}
			map.put(c, j);
			j=1;
		}

		System.out.println(map);

	}
}

















