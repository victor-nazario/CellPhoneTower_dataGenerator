package solutions;

/**
 *
 * @author Víctor A. Nazario Morales 843-15-4984 S-050
 * @author Jairo Rosado Soto 844-12-7240 S-070
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import interfaces.MySet;
import mySetImplementations.Set2;

public class P4Approach<E> extends P3Approach<E>{
    
    /**
     * Constructor for the solution instance
     * @param name the given name for the specific solution
     */
    
    public P4Approach(String name) {
        super(name);
    }
    
    
    /**
     * This method processes an array of crimes and companies to produce an array of sets that is the intersection of all numbers.
     * @param t the given MySet array to find the intersection
     */
    
    
    @Override
    public MySet<E> intersectSets(MySet<E>[] t) {
        ArrayList<E> allElements = new ArrayList<E>();
        int m = t.length;
        for(int j= 0 ; j<m ; j++){
            for (E e : t[j]){
                allElements.add(e);
            }
        }
        
        HashMap<E, Integer> map = new HashMap<>();
        MySet<E> s2 = new Set2<>();
        for (E e : allElements) {
            Integer count = map.getOrDefault(e, 0);
            map.put(e, count+1);
        }
        
        for (Entry<E, Integer> entry : map.entrySet())
            if (entry.getValue() == m)
                s2.add(entry.getKey());
        return s2;
    }
    
}
