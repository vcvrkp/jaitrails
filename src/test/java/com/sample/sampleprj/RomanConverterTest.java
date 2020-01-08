package com.sample.sampleprj;

import org.junit.Assert;
import org.junit.Test;


public class RomanConverterTest {
    /*
    I
    II
    V
    VI
    IV
    X
    XIX
    C
    M
    */
    
    @Test
    public void testSingleNumber() throws Exception {
        RomanConverter converter = new RomanConverter();
        Assert.assertEquals(1, converter.convert("I"));
        Assert.assertEquals(5, converter.convert("V"));
        Assert.assertEquals(10, converter.convert("X"));
        Assert.assertEquals(1000, converter.convert("M"));
    }
}
