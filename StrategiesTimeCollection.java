package part2StrategiesTimeCollection;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

import java.util.ArrayList;
import java.util.Map;


/**
 * An object of this type will contain the results of random experiments
 * to estimate the average execution time per size of a particular strategy. 
 * It also stores the partial sum of the times that the particular strategy
 * has taken during the experimental trials. 
 * 
 * An object of this type will embed a particular strategy. When that particular
 * strategy is executed from an ExperimentController object, this object will 
 * contain the computed average execution times for each input size that it
 * has experimented with. 
 * 
 * Notice that this is implemented as a subclass of 
 * ArrayList<Matp.Entry<Integer, Float>>
 * 
 * @author pedroirivera-vega
 * 
 * 
 * Adjusted for project1 by:
 * @author Víctor A. Nazario Morales 843-15-4984 S-050
 * @author Jairo Rosado Soto 844-12-7240 S-070
 *
 */

public class StrategiesTimeCollection<E> 
extends ArrayList<Map.Entry<Integer, Float>> { 
    private IntersectionFinder<Integer> strategy;    // the strategy
    private float sum;   
    // variable to accumulate the sum of times that different
    // executions for the same time take. It is eventually used
    // to determine the average execution time for a particular 
    // size.....
    
    public StrategiesTimeCollection(IntersectionFinder<Integer> strategy) { 
        this.strategy = strategy; 
    } 
    
    public String getStrategyName() { 
        return strategy.getName(); 
    }
    
    public void runTrial(Object[][][] dataSet) { 
		int m = dataSet[0].length;
		MySet[] s = new MySet[m];

		if(strategy.getName().equals("1")){
			for(int j = 0; j < m; j++) {
				s[j] =  new Set1<>();
				for(int i = 0; i < dataSet.length; i++) {
					for(int z = 0; z < dataSet[i][j].length; z++)
						s[j].add(dataSet[i][j][z]); // add to set t[j] the element dataset[i][j][z]
				}
			}
		}
		else {
			for(int j = 0; j < m; j++) {
				s[j] =  new Set2<>();
				for(int i = 0; i < dataSet.length; i++) {
					for(int z = 0; z < dataSet[i][j].length; z++)
						s[j].add(dataSet[i][j][z]); // add to set t[j] the element dataset[i][j][z]
				}
			}
		}
		strategy.intersectSets(s);
    	
    }
    
    public void resetSum() { 
    	sum = 0.0f; 
    }
    
    public void incSum(float t) { 
    	sum += t; 
    }
    
    public float getSum() { 
    	return sum; 
    }
    
}