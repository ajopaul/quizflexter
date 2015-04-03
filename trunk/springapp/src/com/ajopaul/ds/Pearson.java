package com.ajopaul.ds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pearson
{
  public static void main(String... args){
   /* Pattern p = Pattern.compile("xy");
    Matcher m = p.matcher("xyxyxy");
    while(m.find()){
      System.out.println(m.start()+ " ");
    }*/
    
   /*  Pearson p = new Pearson();
     p.check();
    */
    
    
    /*String a= "whizlab";
    String b = "whizlabs";
    int la = a.length();
    int lb = b.length();
    for(int i=0;i<la||i<lb;i++){
      if(a.charAt(i)!=b.charAt(i)){
        System.out.println(a.charAt(i));
      }
    }*/
    
    
    StringBuffer s = new StringBuffer("hello");
    if((s.length() < 10) | s.append(" world").equals("the end")){
      System.out.println(s+":"+s.length());
    }
    System.out.println("Value is "+s);
  }
  
  public void check(){
    Animal a = new Cat();
    System.out.println(a instanceof Animal);
  }
  class Animal{}
  class Cat extends Animal{}
  class MyClass{
    public  void main(String... args){
    
    }
  }
}
