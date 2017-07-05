package ru.tesoft.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Konstantin on 08.02.2016.
 */

public class CalculatorBeanTest {

    @Test
    public void testAddition(){
        WakeOnLanBean calculator = new WakeOnLanBean();
        String result = calculator.add("2", "3");
        assertEquals("5", result);
    }

    @Test
    public void testSubtraction(){
        WakeOnLanBean calculator = new WakeOnLanBean();
        String result = calculator.subtract("10", "5");
        assertEquals("5", result);
    }

    @Test
    public void testMultiplication(){
        WakeOnLanBean calculator = new WakeOnLanBean();
        String result = calculator.multiply("10", "10");
        assertEquals("100", result);
    }

    @Test
    public void testDivision(){
        WakeOnLanBean calculator = new WakeOnLanBean();
        String result = calculator.divide("10", "2");
        assertEquals("5", result);
    }

}
