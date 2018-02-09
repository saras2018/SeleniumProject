package LearnMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class operationOnIntegersForDuplicates {
	int numbers[] = {8,9,4,3,3,4,8};
	int j=1;


	public static void main(String[] args) {

		operationOnIntegersForDuplicates obj = new operationOnIntegersForDuplicates();
		obj.removeDuplicates();
		obj.printNumbers();

	}

	public void removeDuplicates(){
		Map<Integer,Integer> map = new LinkedHashMap<>();
		for ( int i : numbers) {
			if(map.containsKey(i)){
				map.remove(i);
			}
			map.put(i, 1);
		}

		System.out.println(map);


	}

	public void printNumbers(){
		Map<Integer,Integer> map = new LinkedHashMap<>();
		int j = 1;
		for ( int i : numbers) {
			if(map.containsKey(i)){
				j = map.get(i)+1;
			}
			map.put(i, j);
			j=1;
		}
			for (Entry<Integer, Integer> map1 : map.entrySet()) {
				if(map1.getValue()>1)
				{
					System.out.println("Printing the duplicate values only  "+ map1.getKey());
				}else 
					if(map1.getValue()==1) {
						System.out.println("Printing the unique values only  "+ map1.getKey());
					}

			}



		}
	}

