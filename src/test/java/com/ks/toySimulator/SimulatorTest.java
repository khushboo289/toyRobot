package com.ks.toySimulator;

import org.junit.Assert;
import org.junit.Test;

public class SimulatorTest {

    @Test
    public void testProceed(){

        Table table = new Table(5, 5);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(robot, table);
        
        // invalid commands
        Assert.assertEquals("Invalid move", simulator.proceed("PLACE12NORTH"));
        
        //invalid location
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        Assert.assertEquals("Invalid move", simulator.proceed("REPORT"));

        simulator.proceed("PLACE 0,0,NORTH");
        simulator.proceed("MOVE");
        Assert.assertEquals("Output: 0, 1, NORTH", simulator.proceed("REPORT"));
        
        simulator.proceed("PLACE 0,0,NORTH");
        simulator.proceed("LEFT");
        Assert.assertEquals("Output: 0, 0, WEST", simulator.proceed("REPORT"));

        
        simulator.proceed("PLACE 1,2,EAST");
        simulator.proceed("MOVE");
        simulator.proceed("MOVE");
        simulator.proceed("LEFT");
        simulator.proceed("MOVE");

        Assert.assertEquals("Output: 3, 3, NORTH", simulator.proceed("REPORT"));
    }

}
