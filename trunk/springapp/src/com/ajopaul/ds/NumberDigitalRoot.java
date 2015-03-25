package com.ajopaul.ds;

public class NumberDigitalRoot
{
  public int getDigitalRoot(Integer number){
    
    int sum = 0;
    int tempNumber = number.intValue();
    int mod = 0;
    while(tempNumber > 0){
      mod = tempNumber %10;
      sum+=mod;
      tempNumber=tempNumber/10;
    }
    if(sum/10 != 0){
      return getDigitalRoot(sum);
    }
    return sum;
  }
}
