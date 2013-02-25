package mediatordesignpatternmba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>A set of unit tests to check the states of the robots.</p>
 *
 * <p>This program is part of the solution for the first ICA for AJP in Teesside
 * University.</p>
 *
 * <p>AJP-P5-2012-2013-SOLUTION is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.</p>
 *
 * <p>This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.</p>
 *
 * <p>You should have received a copy of the GNU General Public License along
 * with this program. If not, see http://www.gnu.org/licenses/.</p>
 *
 * <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk 13-Dec-2012 </p>
 */
public class RobotTest {

    /**
     * Do this before any tests have run.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing RobotPressurizedRover class");
    }

    /**
     * robotExploration() is responsible for testing the robots.
     *
     * Using the handleRobots() method to check the return String  of the robots
     */
    @Test
    public void robotExploration() {
        System.out.print("Testing simple robotExploration");
        final Mediator mediator = new Mediator();
        final String robotReportDanger = "Huston we have a problem!, big danger comming.";
        final String robotExplore = "Robot exploring the environment.";
        final String robotReport = "Robot report to the headquarters.";
        final String robotSearch = "Robot searching.";
        final String robotIsLazy = "Robot being lazy.";

        assertEquals(robotReportDanger, mediator.handleRobots(RobotStates.DANGER));
        System.out.println("Robots reporting danger OK");

        assertEquals(robotExplore, mediator.handleRobots(RobotStates.EXPLORE));
        System.out.println("Robots exploring OK");

        assertEquals(robotReport, mediator.handleRobots(RobotStates.REPORT));
        System.out.println("Robots reporting OK");

        assertEquals(robotSearch, mediator.handleRobots(RobotStates.SEARCH));
        System.out.println("Robots searching OK");

        assertFalse(robotIsLazy.equals(mediator.handleRobots(null)));
        System.out.println("Robots being lazy  OK");
    }

    /**
     * testRobotStates() is responsible for testing the state of the robots.
     *
     * Using the getState() and setState() methods to check the state of the
     * robots
     */
    @Test
    public void testRobotStates() {
        System.out.print("Testing the states of the robots");
        final Mediator mediator = new Mediator();
        final RobotPressurizedRover robot = new RobotPressurizedRover(mediator);
        
        robot.setState(RobotStates.DANGER);
        assertEquals(RobotStates.DANGER, robot.getState());
        System.out.println("Robot state danger OK");

        robot.setState(RobotStates.EXPLORE);
        assertEquals(RobotStates.EXPLORE, robot.getState());
        System.out.println("Robot state explore OK");

        robot.setState(RobotStates.REPORT);
        assertEquals(RobotStates.REPORT, robot.getState());
        System.out.println("Robot state report OK");

        robot.setState(RobotStates.SEARCH);
        assertEquals(RobotStates.SEARCH, robot.getState());
        System.out.println("Robot state search OK");

        assertFalse(RobotStates.DANGER.equals(mediator.handleRobots(null)));
        System.out.println("Robot state null OK");

    }

    /**
     * Do this after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing RobotPressurizedRover class");
    }
}
