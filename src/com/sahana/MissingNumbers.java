/**
 * 
 */
package com.sahana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sahana Ravikumar
 *
 */
public class MissingNumbers {

	private static List<Integer> listA;
	
	private static List<Integer> listB;
	
	private static List<Integer> resultList;
	
	private static Map<Integer, Integer> numberCountMapA = new HashMap<Integer, Integer>();
	
	private static Map<Integer, Integer> numberCountMapB = new HashMap<Integer, Integer>();
	
	public static void main(String[] args){
		
		captureUserInput();
		
		computeMapA();
		
		computeMapB();
		
		checkForEquality();
		
		Collections.sort(resultList);
		
		displayResult();
		
	}

	@SuppressWarnings("resource")
	private static void captureUserInput() {
		Scanner reader = new Scanner(System.in);
		int listAsize = reader.nextInt();
		
		Scanner reader1 = new Scanner(System.in); 
		int listBsize = reader1.nextInt();
		
		if(listAsize >= 1 && listBsize >= 1 && listAsize <= 1000010 && listBsize <= 1000010){             //Constraint
			
			listA = new ArrayList<Integer>(listAsize);
			listB = new ArrayList<Integer>(listBsize);
			
			for (int i = 0; i < listAsize; i++) {
				Scanner readerA = new Scanner(System.in); 
				listA.add(readerA.nextInt());
			}
			
			for (int i = 0; i < listBsize; i++) {
				
				Scanner readerB = new Scanner(System.in);
				Integer listBItem = readerB.nextInt();
				
				if(listBItem >= 1 && listBItem <= 10000)												//Constraint
					listB.add(listBItem);
			}
		}
	}
	
	private static void computeMapA() {
		for (int i = 0; i < listA.size(); i++) {
			if(numberCountMapA.containsKey(listA.get(i))){
				int prevCount = numberCountMapA.get(listA.get(i));
				numberCountMapA.put(listA.get(i), prevCount + 1);
			}else{
				numberCountMapA.put(listA.get(i),1);
			}
		}
	}

	private static void computeMapB() {
		for (int i = 0; i < listB.size(); i++) {
			if(numberCountMapB.containsKey(listB.get(i))){
				int prevCount = numberCountMapA.get(listB.get(i));
				numberCountMapB.put(listB.get(i), prevCount + 1);
			}else{
				numberCountMapB.put(listB.get(i),1);
			}
		}
	}
	
	private static void checkForEquality() {
		
		Object[] keySetA = numberCountMapA.keySet().toArray();
		Object[] keySetB = numberCountMapB.keySet().toArray();
		
		resultList = new ArrayList<Integer>();
		
		for (int i = 0; i < keySetA.length; i++) {
			for (int j = 0; j < keySetB.length; j++) {
				if(keySetA[i].equals(keySetB[j])){
					if(numberCountMapA.get(keySetA[i]) != numberCountMapB.get(keySetB[j])){
						resultList.add(new Integer((int) keySetA[i]));
						break;
					}
					break;
				}
			}
		}	
	}
	
	private static void displayResult() {
		
		System.out.println();
		for (int i = 0; i < resultList.size(); i++) {
			System.out.print(" " + resultList.get(i));
		}
	}
}
