
/*
 * Katelyn Dever
 * ITEC 4264
 * 
 * 1. a) T(n) = 1 + 2 + 3 + 4 + (5 + 6 + 7)^n + 8 + 9
 * 	  b) I think this expression is of quadratic complexity 0(N^2)
 * 		The number of items in the array determine how many times the loop
 * 		iterates, so it increases at a magnitude of N^2.
 * 2. a) I think binary search would be the most efficient.  If you were 
 * 		looking for the word "social", you wouldn't want to start with a 
 * 		linear search at 'A' and work your way all of the way through the 
 * 		alphabet.  Instead, this would divide the words in half (since they
 * 		are sorted) and decide before/after, then repeat.
 * 	  b) The Big O complexity would be O(logn) because the choices get
 * 		smaller and smaller with each iteration, making the user closer
 * 		to finding their given word.
 * 
 */


package deverKatelynA5;

import java.util.*;

public class deverKatelynA5 {

	public static int part1(int[] array, int n, int x) {
		
		//algorithmic complexity is linear
		//this algorithm compares every element to the search
		//term until its found or the entire array has been searched
		for (int i = 0; i < n; i++) {
			if(array[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	public static int part2(int[] array, int f, int l, int x) {
		
		//algorithmic complexity is logarithmic 
		//each time, search results are divided by two
		//decreases search time
		if (l >= f) {  
			//find midpoint of array
            int mid = f + (l - f) / 2; 
            
            //if number is the center number, 
            if (array[mid] == x) {
            	return mid;  
            }  
            else if (array[mid] > x) {  
            	//search in left half
            	return part2(array, f, mid-1, x);  
            }
            else  { 
            	//search in right half
            	return part2(array, mid+1, l, x);  
            }  
        }  
        return -1;  
		
	}
	
	public static void printResult(int x) {
		if (x == -1 ) {
			System.out.println("Element is not present in array.");
		}
		else {
			System.out.println("Element is present at index " + x);
		}
	}
	
	public static void main(String[] args) {
		int[] myArray = {24, 50, 10, 16, 13, 46, 33, 31, 27, 29, 12, 9, 14};
		int n = myArray.length;
		
		//variables for numbers to search for as examples
		int x = 46;
		int y = 21;
		int r;
		
		//calls part 1 method with one true and one false search
		//sends result to printResult function that prints to user
		printResult(r = part1(myArray, n, x));
		printResult(r = part1(myArray, n, y));
		
		//sorts array, then calls part 2 method with one true and one false search
		//sends result to printResult function that prints to user
		Arrays.sort(myArray);
		int lastIndex = n - 1;
		printResult(r = part2(myArray, 0, lastIndex, x));
		printResult(r = part2(myArray, 0, lastIndex, y));

	}

}
