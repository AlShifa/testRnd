package munna;

import java.util.Collections;
import java.util.LinkedList;

public class A implements Cloneable{
	int x =10;
	public static void main(String[] args) throws CloneNotSupportedException {		
		A a = new A();
		A ob = (A) a.clone();
		System.out.println(ob.toString());
		//Collections.synchronizedList(list)
		LinkedList<String> ll = new LinkedList<String>();
		//ll.add(index, element);
		//ll.get(index)
	}
	

}
