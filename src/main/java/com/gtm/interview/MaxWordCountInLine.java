/**
 * 
 */
package com.gtm.interview;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kumarga
 *
 */
public class MaxWordCountInLine {

	private int currentMaxCount = 0;
    private List<String> lines = new ArrayList<String>();
    
    public void readMaxLineCount(String fileName){
    	FileInputStream fis=null;
    	DataInputStream  dis=null;
    	BufferedReader br=null;
    	
    	try {
			fis=new FileInputStream(fileName);
			dis=new DataInputStream(fis);
			br=new BufferedReader(new InputStreamReader(dis));
			String line=null;
			while ((line=br.readLine())!=null) {
				int count=(line.split("\\s")).length;
				if(count>currentMaxCount){
					lines.clear();
					lines.add(line);
					setCurrentMaxCount(count);
				}else if (count==currentMaxCount) {
					lines.add(line);
					
				}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
    	finally{
    		try {
				if(br!=null || dis!=null || fis!=null){
					br.close();
					dis.close();
					fis.close();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    	}
    	
    	
    }
    
    
	public int getCurrentMaxCount() {
		return currentMaxCount;
	}


	public void setCurrentMaxCount(int currentMaxCount) {
		this.currentMaxCount = currentMaxCount;
	}


	public List<String> getLines() {
		return lines;
	}


	public void setLines(List<String> lines) {
		this.lines = lines;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxWordCountInLine countInLine=new MaxWordCountInLine();
		countInLine.readMaxLineCount("C:/Users/kumarga/Downloads/MyTestFile.txt.txt");
		System.out.println("Max number of words in a line is: "+countInLine.getCurrentMaxCount());
        System.out.println("Line with max word count:");
        List<String> line=countInLine.getLines();
        for (String li : line) {
			System.out.println(li);
		}

	}

}
