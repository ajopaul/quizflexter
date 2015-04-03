package com.ajopaul.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
	
	static boolean isStringUnique(String word){
		boolean isStringUnique = true;
		if(null != word && word.trim().length() > 0){
			char[] strArry = word.toCharArray();
			//System.out.println(strArry.);
			for(int i=0;i<word.length() && isStringUnique;i++){
				for(int j=i+1;j<word.length();j++){
					System.out.println(strArry[i] +":"+strArry[j]);
					if(strArry[i] == strArry[j]){
						isStringUnique = false;
						break;
					}
				}
			}
		}


		return isStringUnique;
	}
	
	static String reverse(String word){
		StringBuffer revString = new StringBuffer();	
		if(null != word && word.trim().length() > 0){
			char[] strArry = word.toCharArray();
			for(int i=word.length()-1;i>=0;i--){
				revString.append(strArry[i]);
			}
		}
		return revString.toString();
	}
	
	static boolean isStringPermutation(String firstStr,String secondStr){
		boolean isStringPerm = false;
		if(null != firstStr && null != secondStr){
			if(firstStr.length() == secondStr.length()){
				Map<Character,Integer> charCountMap1= getCharCountMap(firstStr);
				Map<Character,Integer> charCountMap2= getCharCountMap(secondStr);
				isStringPerm = charCountMap1.equals(charCountMap2);
			}
		}
		return isStringPerm;
	}
	
	static boolean isStringPermutation2(String firstStr,String secondStr){
		boolean isStringPerm = false;
		if(null != firstStr && null != secondStr){
			if(firstStr.length() == secondStr.length()){
				/*Map<Character,Integer> charCountMap1= getCharCountMap(firstStr);
				Map<Character,Integer> charCountMap2= getCharCountMap(secondStr);
				isStringPerm = charCountMap1.equals(charCountMap2);*/
				
				char[] s1 = firstStr.toCharArray();
				Arrays.sort(s1);
				char[] s2 = secondStr.toCharArray();
				Arrays.sort(s2);
				
				isStringPerm = new String(s1).equals(new String(s2));
			}
		}
		return isStringPerm;
	}
	
	static boolean isStringPermutation3(String firstStr,String secondStr){
		boolean isStringPerm = false;
		if(null != firstStr && null != secondStr){
			if(firstStr.length() == secondStr.length()){
				/*Map<Character,Integer> charCountMap1= getCharCountMap(firstStr);
				Map<Character,Integer> charCountMap2= getCharCountMap(secondStr);
				isStringPerm = charCountMap1.equals(charCountMap2);*/
				
				/*char[] s1 = firstStr.toCharArray();
				Arrays.sort(s1);
				char[] s2 = secondStr.toCharArray();
				Arrays.sort(s2);
				
				isStringPerm = s1.equals(s2);*/
				
				int letters[] = new int[256];
				char[] s_array = firstStr.toCharArray();
				for(char s:s_array){
					letters[s]++;
				}
				
				for(int i=0;i<secondStr.length();i++){
					char c = secondStr.charAt(i);
					if(--letters[c] < 0){
						isStringPerm = false;
						break;
					}else{
						isStringPerm = true;
					}
				}
			}
		}
		return isStringPerm;
	}
	
	private static Map<Character, Integer> getCharCountMap(String firstStr) {
		 Map<Character, Integer> charCntMap = new HashMap<Character,Integer>();
		char[] strArray = firstStr.toCharArray();
		
		for(int i=0;i<firstStr.length();i++){
			charCntMap.put(strArray[i], 1);
		}
		
		for(int i=0;i<firstStr.length();i++){
			int count = charCntMap.get(strArray[i]);
			for(int j=i+1;j<firstStr.length();j++){
				if(strArray[i] == strArray[j]){
				count++;	
				}
			}
			charCntMap.put(strArray[i], count);
		}
		
		return charCntMap;
	}
	
	static boolean isStringUnique2(String word){

		if (word.length() > 256) return false;
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < word.length(); i++) {
			int val = word.charAt(i);
			if (char_set[val]) { // Already found this char in string

				return false;
			}
			char_set[val] = true;
		}
		return true;

	}
	
	
/*
 
 Given three arrays sorted in non-decreasing order, print all common elements in these arrays. 
Examples:
ar1[] = {1, 5, 10, 20, 40, 80} 
ar2[] = {6, 7, 20, 80, 100} 
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
Output: 20, 80 
ar1[] = {1, 5, 5} 
ar2[] = {3, 4, 5, 5, 10} 
ar3[] = {5, 5, 10, 20} 
Outptu: 5, 5
 
 */
 
	/*
	 * Compare one array to another, for the first time compary first two arrays 
	 * and find the common elements. Next time onwards use this common array to compare
	 * the next array, repeat this till the last array.
	 */
	public static void printCommonElements(List<Integer[]> intArrays){
	  if(null != intArrays){
	    Integer commonArray[] = null;
	    for(int i=0;i<intArrays.size();i++){
	      if(null == commonArray){
	        commonArray = intArrays.get(i);
	      }
	      if(i+1 != intArrays.size()){
	        commonArray = getCommonElements(commonArray, intArrays.get(i+1));
	      }
	    }
	    //Print the result.
	    for(Integer val:commonArray){
	      System.out.print(" "+val);
	    }
	  }
	}

	/*
	 *Compare the two arrays and return the common elements amongst them.  
	 */
	public static Integer[] getCommonElements(Integer ar1[],Integer ar2[]){
	  List<Integer> intArry = new ArrayList<Integer>();
	  
	  for(int i=0;i<ar1.length;i++){
	    for(int j=0;j<ar2.length;j++){
	      if(ar1[i] == ar2[j]){
	        intArry.add(ar1[i]);	       
	      }
	    }
	  }
	  
	  return intArry.toArray(new Integer[intArry.size()]);
	}
	
	static void printReverse(int... array){
	  for(int i=0;i<array.length/2;i++){
	    int temp  = array[i];
	    array[i]=array[array.length-(i+1)];
	    array[array.length-(i+1)] = temp;
	  }
	  System.out.println("Result");
	  for(int i=0;i<array.length;i++){
	    System.out.print(array[i]+" ");
	  }
	}
	
	static void sortArray(int...array){
	  for(int i=0;i<array.length;i++){
	    for(int j=i+1;j<array.length;j++){
	      if(array[i] > array[j]){
	        int temp = array[i];
	        array[i]=array[j];
	        array[j]=temp;
	      }
	    }
	  }
	  
	  System.out.println("Result");
    for(int i=0;i<array.length;i++){
      System.out.print(array[i]+" ");
    }
	}

	public static void main(String... args){
	//System.out.println(isStringUnique2("london"));
		//System.out.println(reverse("tomcat"));
	//System.out.println(isStringPermutation3("london", "ldonnno"));
	/* List<Integer[]> list = new ArrayList<>();
	 list.add(new Integer[] {1, 5, 10, 20, 40, 80});
	 list.add(new Integer[] {6, 7, 20, 80, 100,10});
	 list.add(new Integer[] {3, 4, 15, 20, 30, 70, 80,10, 120} );
	 list.add(new Integer[] {10,30,40,50,80,20} );
	 printCommonElements(list);*/
	  //printReverse(new int[] {3, 4, 15, 20, 30, 70, 80,10, 120});
	  sortArray(new int[] {13, 4, 15, 20, 30, 70, 80,10, 120});
	}
}
