package com.syne.Z.go.core.thr;

import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReq {
	
	public static void main(String[] args) {

		String streReq = "One , Two , Three ,   four four ,five";
		StringTokenizer stk = new StringTokenizer(streReq, ",");		
		while(stk.hasMoreTokens())
		{
			System.out.println(stk.nextToken());
		}
		System.out.println("\n");
		
		String reqEx= "\\s*,\\s*";
		String[] strAry = streReq.split(reqEx);
		for(String strsplit : strAry)
			System.out.println(strsplit+ ":"+strsplit.length());		
		
		streReq.split(reqEx);		
		java.util.regex.Pattern.compile(reqEx).split(streReq);
		
		streReq.matches(reqEx);
		java.util.regex.Pattern.matches(reqEx, streReq);		
		java.util.regex.Pattern.compile(reqEx).matcher(streReq).matches();
		System.out.println(StringReq.class.getName()+".class");
		System.out.println(StringReq.class.getName().replace("o", "/")+".class");
		System.out.println(StringReq.class.getName().replaceAll(".", "/")+".class");
		System.out.println(StringReq.class.getName().replaceAll("\\.", "/")+".class");
		System.out.println(StringReq.class.getName().replaceAll(Pattern.quote("."), "/")+".class");
		System.out.println(StringReq.class.getName().replaceAll(Pattern.quote("."), Matcher.quoteReplacement("\\"))+".class");
		System.out.println(StringReq.class.getName().replaceAll(Pattern.quote("."), Matcher.quoteReplacement(File.separator))+".class");
		
		System.out.print("Hell");
		System.out.println("o world");
		
		
		
	}

}
