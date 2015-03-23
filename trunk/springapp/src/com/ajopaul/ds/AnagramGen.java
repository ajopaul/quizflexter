package com.ajopaul.ds;

public class AnagramGen {
		
	public static String[] anagrams(String word){
		char[] wordChAray = null;

		if(null != word && word.trim().length() > 0){
		 wordChAray = new char[word.length()];
		}
		for(int i=0;i<word.length();i++){
			wordChAray[i]=word.charAt(i);
		}
		getWord(word, wordChAray, 0, 1);
		return null;
	}
	
	public static String getWord(String word,char[] wordChArry,int startIndex,int index){
		
		String anWord = word.replace(wordChArry[startIndex], wordChArry[startIndex + 1]);
		anWord = anWord.replace(wordChArry[startIndex+1], wordChArry[startIndex]);
		System.out.println("An word "+anWord);
		return null;
	}
	
	public static void main(String... args){
		anagrams("banana");
	}
}
