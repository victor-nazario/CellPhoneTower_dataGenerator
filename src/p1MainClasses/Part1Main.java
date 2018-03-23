
package p1MainClasses;

import java.io.FileNotFoundException;
import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutions.P1_P2Approach;
import solutions.P3Approach;
import solutions.P4Approach;

/**
 *
 * @author Víctor A. Nazario Morales 843-15-4984 S-050
 * @author Jairo Rosado Soto 844-12-7240 S-070
 *
 */

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 1)
			System.out.println("Unexpected number of parameters. Must be 1.");
		
		//Create an array of intersection finders 
		IntersectionFinder[] intFind = new IntersectionFinder[4]; 
	
		intFind[0] = new P1_P2Approach("1");
		intFind[1] = new P1_P2Approach("2");
		intFind[2] = new P3Approach("3");
		intFind[3] = new P4Approach("4"); 
		
		
		//The user inputs a number regarding which solution to run
		if (args.length!=0) { 
			int strategy = Integer.parseInt(args[0])-1;
			System.out.println("Final set by " + intFind[strategy].getName()+":" + intFind[strategy].intersectSets(unionFinder(args[0])));
		}
		//In the case the user didn't select anything 
		else { 
			for(int i = 0; i<intFind.length ; i++){
				System.out.println("Final set by " + intFind[i].getName()+":" + intFind[i].intersectSets(unionFinder(Integer.toString(i+1))));
			}
		}

	}
	
	/**
	 * Reads all inputed files and finds the union set of the numbers in each rime location for a specific company
	 * @param argumentLine used to determine which strategy receives the set
	 * @return the array of Sets defendant on which strategy 
	 * @throws FileNotFoundException
	 */
	
	private static MySet[] unionFinder(String argumentLine) throws FileNotFoundException {
		DataReader dr = new DataReader();
		Object [][][] dataSet = dr.readDataFiles();
		MySet[] finalSet = new MySet[dataSet[0].length];

		for(int j = 0 ; j<dataSet[0].length ; j++) {
			finalSet[j] = new Set2();                           //initializes the set as Set2
			if(argumentLine.equals("1")) finalSet[j] = new Set1();  //if the args is "1" then it is changed to Set1
			for(int i =0 ; i<dataSet.length ; i++) {
				for( int k=0 ; k< dataSet[i][j].length; k++) {
					finalSet[j].add(dataSet[i][j][k]);
				}
			}
		}
		return finalSet;
	}
}



//package p1MainClasses;
//
//import java.io.FileNotFoundException;
//import dataGenerator.DataReader;
//import interfaces.MySet;
//import mySetImplementations.Set1;
//import mySetImplementations.Set2;
//import solutions.P1_P2Approach;
//import solutions.P3Approach;
//import solutions.P4Approach;
//
//public class Part1Main {
//
//	public static void main(String[] args) {
//		
//		try {
//			DataReader dr = new DataReader();
//			Integer[][][] theArr = (Integer[][][]) dr.readDataFiles(); 
//			int eventNum = theArr[0].length;
//			int companyNum = theArr.length;
//			MySet[] arr1 = new Set1[eventNum]; 
//			MySet[] arr2 = new Set2[eventNum];
//			MySet<Integer>[] theSet = new MySet[eventNum];
//			for (int j = 0; j < eventNum; j++) {
//			
//			
//				if (args[0] == "1") {
//					theSet[j] = new Set1<Integer>(); 
//				}
//				
//				else {
//					theSet[j] = new Set2<Integer>(); 
//				}
//				
//				for (int i = 0; i < companyNum; i++) {
//					for (int k = 0; k < theArr[i][k].length; k++) {
//						theSet[j].add((Integer) theArr[i][j][k]);
//					}
//				}
//				
//	
//			}
//			
//			
//			if (args[0] == "1") {
//				P1_P2Approach P1Trial = new P1_P2Approach("1"); 
//				System.out.println("Final set by P4: " + P1Trial.intersectSets(theSet));
//				
//			}
//			
//			else if (args[0] == "2") {
//				P1_P2Approach P2Trial = new P1_P2Approach("2"); 
//				System.out.println("Final set by P2: " + P2Trial.intersectSets(arr2));
//				
//			}
//			
//			else if(args[0] == "3") {
//				P3Approach P3Trial = new P3Approach("3"); 
//				System.out.println("Final set by P3: " + P3Trial.intersectSets(arr2));
//			}
//			
//			
//			else if(args[0] == "4") {
//				P4Approach  P4Trial = new P4Approach("4");
//				System.out.println("Final set by P4: " + P4Trial.intersectSets(arr2));
//			}
//
//			
//			
//		} catch (FileNotFoundException e1) {
//			
//			e1.printStackTrace();
//		}
//
//		
//	}
//
//	
//}
//	
//	
//	
	
	/** The solutionRuner method switches between the four proposed solutions to apply to each data entry
	 * @param solution, a value ranged from 1-4 to select which person's solution to use.
	 */
	
//	public static void solutonRuner(int solution) {
////		MySet[] t = (MySet[]) new Object[5000];    //verificar para remover
////		int num;
//		
//		try {
//			DataReader dr = new DataReader();
//			Object[][][] theArr = dr.readDataFiles(); 
//			int eventNum = theArr[0].length;
//			int companyNum = theArr.length;
//			MySet[] arr1 = new Set1[eventNum]; 
//			MySet[] arr2 = new Set2[eventNum];
//			
//			for (int j = 0; j < eventNum; j++) {
//				MySet<Integer> theSet1 = new Set1<>(); 
//				MySet<Integer> theSet2 = new Set2<>(); 
//				for (int i = 0; i < companyNum; i++) {
//					for (int k = 0; k < theArr[i][k].length; k++) {
//						theSet1.add((Integer) theArr[i][j][k]);
//						theSet2.add((Integer) theArr[i][j][k]);
//					}
//				}
//				arr1[j] = theSet1;
//				arr2[j] = theSet2; 
//			}
//			
//			
//			if (solution == 1) {
//				P1_P2Approach P1Trial = new P1_P2Approach("1"); 
//				System.out.println("Final set by P4: " + P1Trial.intersectSets(arr1));
//				
//			}
//			
//			else if (solution == 2) {
//				P1_P2Approach P2Trial = new P1_P2Approach("2"); 
//				System.out.println("Final set by P2: " + P2Trial.intersectSets(arr2));
//				
//			}
//			
//			else if(solution == 3) {
//				P3Approach P3Trial = new P3Approach("3"); 
//				System.out.println("Final set by P3: " + P3Trial.intersectSets(arr2));
//			}
//			
//			
//			else if(solution == 4) {
//				P4Approach  P4Trial = new P4Approach("4");
//				System.out.println("Final set by P4: " + P4Trial.intersectSets(arr2));
//			}
//
//			
//			
//		} catch (FileNotFoundException e1) {
//			
//			e1.printStackTrace();
//		}
//
//		
//	}
//
//
//}



//Set[] atr = (Set[]) new Object[5000]; 
//
//if (solution == 1) {
//	P1_P2Approach p1_p2Trial = new P1_P2Approach("1"); 
//	
//}
//
//else if(solution == 2) {
//	P3Approach P3Trial = new P3Approach("2"); 
//}
//
//else if(solution == 3) {
//	P4Approach  P4Trial = new P4Approach("3");
//}



