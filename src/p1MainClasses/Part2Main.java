package p1MainClasses;

import java.io.FileNotFoundException;

import ExperimentalClasses.ExperimentController;
import ExperimentalClasses.StrategiesTimeCollection;
import solutions.P1_P2Approach;
import solutions.P3Approach;
import solutions.P4Approach;

/**
 * @author Víctor A. Nazario Morales 843-15-4984 S-050
 * @author Jairo Rosado Soto 844-12-7240 S-070
 */

public class Part2Main {

	static int[] values = {10,50,1000,50000,1000,200};

	public static void main(String[] args) throws CloneNotSupportedException{
	
		
		if (args.length > 6)
			System.out.println("Unexpected parameter lenght. Number should not be greater than six.");
		for (int i=0; i<args.length; i++)
			values[i] = Integer.parseInt(args[i]); 

		// Value 1: initial size
		// Value 2: last size to consider for the instance
		// Value 3: incremental gap
		// Value 4: trials on each size
		ExperimentController theController = new ExperimentController(values[0], values[1], values[2], values[3], 
				values[4],  values[5]); 
	
		theController.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2Approach<Integer>("1")));
		theController.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2Approach<Integer>("2")));
		theController.addStrategy(new StrategiesTimeCollection<Integer>(new P3Approach<Integer>("3")));
		theController.addStrategy(new StrategiesTimeCollection<Integer>(new P4Approach<Integer>("4")));

		theController.run();    

		// creates a txt file with the results
		try {
			theController.saveResults();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

}