package com.syne.subtitle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;

public class SubtitleToTxtFile {
	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		System.out.println("--------------------");
		String path = "C:\\subtitle";
		String srtfileName = path+ "\\dan-in-real-life_english-483181\\Dan in Real Life[2007]DvDrip[Eng]-FXG.srt";
		String txtFileName = path+ "\\dan-in-real-life_english-483181\\Dan in Real Life[2007]DvDrip[Eng]-FXG.txt";
		File name = new File(srtfileName);
		FileInputStream fils = new FileInputStream(name);
		DataInputStream dis = new DataInputStream(fils);
		String str = "";
		StringBuffer sbf = new StringBuffer();
		while ((str = dis.readLine()) != null) {
			if (str.indexOf(":") > 0) {
			} else if (str.equals("\n")) {				
				// int x = Integer.parseInst(str);
			} else {
				sbf.append(str);
			}
		}
		str = sbf.toString();
		//str = str.replace('.', '\n');
		System.out.println(str);
		FileOutputStream fos = new FileOutputStream(new File(txtFileName));
		fos.write(str.getBytes());
		// fferedReader bf = new BufferedReader(fils);

	}
}
