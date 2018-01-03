package com.ddlab.core;

public class MutablExample {
	
		private final double re;
		private final double im;
		public MutablExample(double re, double im) {
			super();
			this.re = re;
			this.im = im;
		}
		//Accessors with no corresponding mutators
		public double realPart()
		{
			return re;
		}
		public double imaginaryPArt()
		{
			return im;
		}
		public MutablExample add(MutablExample c)
		{
			return new MutablExample(re+c.re, im + c.im);			
			
		}
		

}
