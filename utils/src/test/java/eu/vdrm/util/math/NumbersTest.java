package eu.vdrm.util.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {
    
    @Test (expected = IllegalArgumentException.class)  
    public void testMaxNull(){
       Numbers.getMax(null);
    }
    
    @Test (expected = IllegalArgumentException.class)  
    public void testMaxEmpty(){
        List<Integer> l = new ArrayList<Integer>(); 
        Numbers.getMax(l);
    }

    @Test
    public void testMaxInteger(){
        List<Integer> l = new ArrayList<Integer>();
        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(5));
        l.add(Integer.valueOf(3));
        Object o = Numbers.getMax(l);
        Assert.assertTrue(o instanceof Integer);
        Assert.assertEquals(5,((Integer)o).intValue());
    }

    @Test
    public void testMaxByte(){
        List<Byte> l = new ArrayList<Byte>();
        l.add(Byte.valueOf("1"));
        l.add(Byte.valueOf("5"));
        l.add(Byte.valueOf("3"));
        Object o = Numbers.getMax(l);
        Assert.assertTrue(o instanceof Byte);
        Assert.assertEquals(5,((Byte)o).intValue());
    }

    @Test
    public void testMaxDouble(){
        List<Double> l = new ArrayList<Double>();
        l.add(Double.valueOf("1.3"));
        l.add(Double.valueOf("5.88989"));
        l.add(Double.valueOf("3.7"));
        Object o = Numbers.getMax(l);
        Assert.assertTrue(o instanceof Double);
        Assert.assertEquals(5.88989,((Double)o).doubleValue(),0.0);
    }

    @Test
    public void testMaxBigDecimal(){
        List<BigDecimal> l = new ArrayList<BigDecimal>();
        BigDecimal res = BigDecimal.valueOf(5.88989);
        l.add(BigDecimal.valueOf(1.3));
        l.add(res);
        l.add(BigDecimal.valueOf(3.7));
        Object o = Numbers.getMax(l);
        Assert.assertTrue(o instanceof BigDecimal);
        Assert.assertTrue(res.equals(o));
    }
    
    @Test
    public void testPotent2_negatif(){
        boolean res = Numbers.isPowerOf2(-3);
        Assert.assertFalse("negatief value!",res);
    }
    @Test
    public void testPotent2_0(){
        boolean res = Numbers.isPowerOf2(0);
        Assert.assertFalse("zero",res);
    }
    @Test
    public void testPotent2_1(){
        boolean res = Numbers.isPowerOf2(1);
        Assert.assertFalse("one",res);
    }
    @Test
    public void testPotent2_6(){
        boolean res = Numbers.isPowerOf2(6);
        Assert.assertFalse("six",res);
    }
    @Test
    public void testPotent2_2(){
        boolean res = Numbers.isPowerOf2(2);
        Assert.assertTrue("two",res);
    }
    @Test
    public void testPotent2_32(){
        boolean res = Numbers.isPowerOf2(32);
        Assert.assertTrue("32!",res);
    }
    @Test
    public void testPotent2_BIG(){
        boolean res = Numbers.isPowerOf2(Integer.MAX_VALUE - 22);
        Assert.assertFalse("BIG",res);
    }
}
