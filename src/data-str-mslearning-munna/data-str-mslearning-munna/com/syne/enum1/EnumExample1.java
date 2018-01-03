package com.syne.enum1;
import java.util.EnumSet;
public class EnumExample1 {
	
	public enum Season {WINTER,SPRNG;}
	public enum Day {SUNDAY,MONDAY}
	
	public static void main(String[] args) {		
		Day day = Day.MONDAY;
		System.out.println(day+"[][]"+day.MONDAY);
	}
	

}
