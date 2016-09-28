import java.util.ArrayList;
import java.util.Arrays;

public class Tester extends Matcher{
	
	//checks if pairing is satisfactory-basically the reverse of canSwap
	public static boolean isSatisfactory(String C1, String P1, String C2, String P2){
		int rankP1C1 = getRank(P1,C1);
		int rankC2P2 = getRank(C2,P2);
		int rankC2P1 = getRank(C2,P1);
		int rankP1C2 = getRank(P1,C2);
		
		if ((rankP1C2 < rankP1C1) && (rankC2P1 < rankC2P2)){
			return false;
		}
		return true;
	}

	
	//checks all pairs for satisfaction and prints the result
	public static void checkForSatisfaction(){
		int counter = 0;
		
		for (int i = 1;i <=numOfPairs;i++){
			String Ci = "C" + i;
			for (int j = 1; j <= numOfPairs; j++){
				String Cj = "C" + j;
				if (isSatisfactory(Ci,currentState.get(Ci),Cj,currentState.get(Cj))){
					counter++;
				}
				if (isSatisfactory(Cj,currentState.get(Cj),Ci,currentState.get(Ci))){
					counter++;
				}
			}
		}
		if (counter != 2 * numOfPairs*numOfPairs){
			System.out.println("There is unsatisfaction");
		}
		else 
			System.out.println("Satisfaction guaranteed");
	}
	
	//method for printing the initially generated hashmap
	public static void printHashMap(){
		ArrayList<String> listOfKeys = new ArrayList<String>();

		for (String key : linkedInP.keySet()){
			ArrayList<String> temp = linkedInP.get(key);
			System.out.print(key + " ");
			System.out.println(Arrays.toString(temp.toArray()));
			listOfKeys.add(key);
		}
		System.out.println("*************************************");
		for (String key : linkedInC.keySet()){
			ArrayList<String> temp = linkedInC.get(key);
			System.out.print(key + " ");
			System.out.println(Arrays.toString(temp.toArray()));
			listOfKeys.add(key);
		}
		System.out.println("*************************************");
	}
	
	//prints the pairs of companies and programmers
	public static void printState(){
		for (int i = 1; i <= numOfPairs; i++){
			System.out.println("C" + i + " " + currentState.get("C" + i));
		}
		System.out.println("*************************************");
	}

	//main
	public static void main(String [] args){
		for(int i = 0; i<3; i++){
			System.out.println("Testing " + (i+5) + " Companies and Programmers");
			generateHash(i+5);
			generateStartState();
			printHashMap();
			//printState();
			match();
			printState();
			checkForSatisfaction();
			System.out.println("*************************************");
		}
	}

}
