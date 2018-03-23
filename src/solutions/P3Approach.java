package solutions;

import java.util.ArrayList;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3Approach<E> extends AbstractIntersectionFinder<E>{

	public P3Approach(String name) {
		super(name);
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		ArrayList<E> allElements = new ArrayList<E>();
		int m = t.length;
		for(int j=0; j<m; j++) {
			for(E e : t[j]) {
				allElements.add(e);
			}
		}
		
		allElements.sort(null); 		
		MySet<E> s2 = new Set2<E>();  // sets in P3's solution are of type Set2
		E e = allElements.get(0); 
		Integer count = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       count++;
		    else { 
		       if (count == m) 
		          s2.add(e);
		       e = allElements.get(i); 
		       count = 1; 
		    } 
		}
		if (count == m)
		    s2.add(allElements.get(allElements.size()-1));

		return s2;
	}
	
		
}
