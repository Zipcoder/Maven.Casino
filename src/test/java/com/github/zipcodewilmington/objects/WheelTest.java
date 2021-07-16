package com.github.zipcodewilmington.objects;

import com.github.zipcodewilmington.casino.objects.Wheel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WheelTest {

    @Test
    public void spinValueTest(){
        //given
        int numOfSlots = 37;
        Wheel testWheel = new Wheel();

        //when
        Integer testSpin = testWheel.getSpinValue();

        //then
        Assertions.assertTrue(testSpin < 37 && testSpin >= 0);
    }
}
