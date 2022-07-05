/**
 * 
 */
package com.gtm.interview;

import java.util.Arrays;

/**
 * @author kumarga
 *
 */
public class MyArrayList {
	
	private Object[] myStore;
    private int actSize = 0;
    

	public MyArrayList() {
		myStore=new Object[10];
	}
	
	public void add(Object obj){
		if(myStore.length-actSize<=5){
			increaseListSize();
		}
		myStore[actSize++]=obj;
	}
	
	public Object get(int index){
		if(index<actSize){
			return myStore[index];
		}else{
		  throw new ArrayIndexOutOfBoundsException();
		}
	}
	public int size(){
	        return actSize;
	    }
	public Object remove(int index){
		if(index<actSize){
			Object obj = myStore[index];
            myStore[index] = null;
            int temp = index;
            while(temp<actSize){
            	myStore[temp]=myStore[temp+1];
            	myStore[temp+1]=null;
            	temp++;
            }
            actSize--;
            return obj;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public void increaseListSize(){
		myStore=Arrays.copyOf(myStore, myStore.length*2);
		System.out.println("\nNew length: "+myStore.length);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyArrayList list=new MyArrayList();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(20);
		System.out.println("Removed element :"+list.remove(1));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
