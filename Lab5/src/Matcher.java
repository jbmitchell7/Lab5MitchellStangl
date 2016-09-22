import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;


public class Matcher {

	public static LinkedHashMap<String,ArrayList<String>> generateHash(int n){
		LinkedHashMap<String,ArrayList<String>> linkedIn = new LinkedHashMap(n);
		for (int i=1; i<=n;i++){
			ArrayList<String> temp = new ArrayList<String>(n);
			for (int j=1;j<=n;j++){
				String tempS = "C"+j;
				temp.add(tempS);
			}
			Collections.shuffle(temp);
			linkedIn.put("P" + i, temp);
		}
		for (int i=1; i<=n;i++){
			ArrayList<String> temp = new ArrayList<String>(n);
			for (int j=1;j<=n;j++){
				String tempS = "P"+j;
				temp.add(tempS);
			}
			Collections.shuffle(temp);
			linkedIn.put("C" + i, temp);
		}
		return linkedIn;
	}

	public static void printHashMap(LinkedHashMap<String,ArrayList<String>> hash){
		int numOfPairs = hash.size() / 2;
		ArrayList listOfKeys = new ArrayList();
		for (String key : hash.keySet()){
			listOfKeys.add(key);
		}
		System.out.println(Arrays.toString(listOfKeys.toArray()));
		
	}

	public static void main(String [] args){
		printHashMap(generateHash(5));
	}
}
