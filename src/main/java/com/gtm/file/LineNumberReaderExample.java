package com.gtm.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class LineNumberReaderExample {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("D:\\fileTest.txt"));
		LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(fis));
		System.out.println("Line " + lineNumberReader.getLineNumber());
		//Setting initial line number
		lineNumberReader.setLineNumber(5);

		//Get current line number
		System.out.println("Line " + lineNumberReader.getLineNumber()+ ": "+lineNumberReader.readLine());
		lineNumberReader.setLineNumber(5);
		String line = null;
		while ((line = lineNumberReader.readLine()) != null)
		{
			System.out.println("Line " + lineNumberReader.getLineNumber() + ": " + line);
		}

		lineNumberReader.close();
	}

}
