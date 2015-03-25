package com.ajopaul.ds;


public class NumberDigitalRootTests
    extends junit.framework.TestCase
{
    public void testGetDigitalRoot(){
      int number = 625;
      /**
       * 6+5+2 = 13 = 1+3 = 4;
       */
      number = 625;
      NumberDigitalRoot root = new NumberDigitalRoot();
      assertEquals(4,root.getDigitalRoot(number));
    }
}
