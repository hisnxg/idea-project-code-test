package com.nxg.spring.factory02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nxg
 * date 2022/1/20
 * @apiNote
 */
public class Factory02Test {

    @Test
    public  void test02() throws Exception{
        Car car = Factory02.getCarInstance("QQ");
        car.start();
        car.run();
        car.stop();
    }
}