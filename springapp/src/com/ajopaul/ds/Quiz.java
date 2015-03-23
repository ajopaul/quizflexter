package com.ajopaul.ds;

import java.util.Arrays;
import java.util.HashMap;
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

	public static void main(String... args){
	//System.out.println(isStringUnique2("london"));
		//System.out.println(reverse("tomcat"));
	System.out.println(isStringPermutation3("london", "ldonnno"));
	}
}
