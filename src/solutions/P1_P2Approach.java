package solutions;

/**
*
* @author Víctor A. Nazario Morales 843-15-4984 S-050
* @author Jairo Rosado Soto 844-12-7240 S-070
*
*/

import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1_P2Approach<E> extends AbstractIntersectionFinder<E>{

	public P1_P2Approach(String name) {
		super(name);
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		int m = t.length;
		MySet<E> s1 = null;
		MySet<E> s2 = null;
		
		if(this.getName() == "1") {
			s1 = (Set1<E>) t[0];
			for(int i=1; i<m; i++) {
				Iterator<E> iter1 = s1.iterator();
				while(!(iter1.hasNext() == false)) {
						if(!t[i].contains(iter1.next())) {
							iter1.remove();
						}
				}
			}
			return s1;
			
		} else if(this.getName() == "2") {
			s2 = (Set2<E>) t[0];
			for(int j=1; j<m; j++) {
				Iterator<E> iter2 = s2.iterator();
				while(!(iter2.hasNext() == false)) {
						if(!t[j].contains(iter2.next())) {
							iter2.remove();
						}
				}
			}
			return s2;
		}
		
		return null;
	}

}