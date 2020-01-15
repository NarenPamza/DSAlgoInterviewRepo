package designPatterns;

/* We can use Java inbuilt Deque as a double 
ended queue to store the cache keys, with 
the descending time of reference from front 
to back and a set container to check presence 
of a key. But remove a key from the Deque using 
remove(), it takes O(N) time. This can be 
optimized by storing a reference (iterator) to 
each key in a hash map. */
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
	static Deque<Integer> dq;
	static HashMap<Integer, Integer> map;
	static int csize;
	int i;

	LRUCache(int n) {
		dq = new LinkedList<>();
		map = new HashMap<>();
		csize = n;
		i = 0;
	}

	/* Refers key x with in the LRU cache */
	public void refer(int x) {
		if (!map.containsKey(x)) {
			if (dq.size() == csize) {
				int last = dq.removeLast();
				map.remove(last);
			}
		} else {
			dq.remove(map.get(x)+1);
		}
		dq.push(x);
		map.put(x, i > csize-1 ? i = 0 : i);
		i++;
	}

	// display contents of cache
	public void display() {
		Iterator<Integer> itr = dq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();
	}
}
// This code is contributed by Gaurav Tiwari
