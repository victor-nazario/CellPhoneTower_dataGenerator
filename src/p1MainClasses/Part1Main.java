
package p1MainClasses;

/**
*
* @author Víctor A. Nazario Morales 843-15-4984 S-050
* @author Jairo Rosado Soto 844-12-7240 S-070
*
*/

import java.io.FileNotFoundException;
import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutions.P1_P2Approach;
import solutions.P3Approach;
import solutions.P4Approach;


public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 1)
			System.out.println("Parameter number must equal one");
		
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
			finalSet[j] = new Set2();                               //initializes the set as Set2
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
