package munna.ds;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
	
	public static void main(String[] args) {
		Object[] obj = new Object[11];
		obj[0] = 1;
		obj[1] = 2;
		obj[2] = 3;
		obj[3] = 4;
		obj[4] = 5;
		obj[5] = 6;
		obj[6] = 7;
		obj[7] = 8;
		obj[8] = 9;
		for(Object x : obj)
			System.out.print(x+",");
		System.out.println();
		System.arraycopy(obj, 2, obj, 1,8 );
		for(Object x : obj)
			System.out.print(x+",");
		//obj[2]=9999;
		//System.out.println();
		//for(Object x : obj)
			//System.out.print(x+",");
		System.out.println("\n"+obj.length);
		obj = Arrays.copyOf(obj, 20);
		System.out.println(obj.length);	
		
		//HashMap<K, V>
	}

}
