/*
 * Rodger Byrd
 * 11/8/17
 * Homework 3 part 1
 * CS5720
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;


public class selectionProblem {
	
	
	public static void main(String[] args) 
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
	

		
		int n = 1000000;
		int k = 10;
		
		//create array of random  numbers 
		Random rand = new Random();
		int[] inputArray = new int[n];
		int[] sortedArray = new int[n];

		
		for (int i = 0; i < n; i++){
			inputArray[i] =  rand.nextInt(1000)+1;
		}

		

		for (int i =0; i < 4; i++){
			
			//report time
			long startTime = System.currentTimeMillis();
			
			k = rand.nextInt(n);
			sortedArray = sort(inputArray);
			
			//for (int j = 0; j < n; j++)
				//System.out.print(sortedArray[j]+ " ");
			//System.out.print("\n");
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			
			//text based for reading
			//String analysis = "Input size: " + n +
			//		"\nk: " + k + 
			//		"\nkth value: " + sortedArray[k] + 
			//		"\nTotal Runtime: " + totalTime + "\n";
			
			//print chart data onlyu to file
			String analysis = n + "\t" + totalTime + "\n";
			printAnalysisToFile("output.txt",analysis);
			
			//System.out.println("Total runtime = " + totalTime +"ms");
			
		}
	}
	public static void printAnalysisToFile(String filename, String text) throws UnsupportedEncodingException, FileNotFoundException, IOException{
		
		try (FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
			{
			out.print(text);


			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			} 

	}
	//selection sort
	public static int[] sort(int a[]){
		//sort array using selection sort
		int min = 0;
		for (int i = 0; i < a.length-1; i++){
			min = i;
			for (int j = i+1; j < a.length; j ++ ){
				if (a[j] < a[min]){
					int temp = a[j];
					a[j] = a[min];
					a[min] = temp;
				}
					
			}
			
		}
		return a;
		
	}
	//debugging, print to console
	public static void printArray(int a[]){
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]+ " ");
		}
		System.out.print("\n");
	}
}
