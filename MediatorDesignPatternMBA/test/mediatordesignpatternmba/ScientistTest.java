package mediatordesignpatternmba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>A set of unit tests to check the states of the scientist.</p>
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
public class ScientistTest {

    /**
     * Do this before any tests have run.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Scientist class");
    }

    /**
     * doScience() is responsible for testing the Scientist.
     *
     * Using the handleScientist() method to check the return  String of the Scientist
     */
    @Test
    public void doScience() {
        System.out.print("Testing simple doScience");
        final Mediator mediator = new Mediator();
        
        final String adviceJedis = "Jedi calm down and listen to me!";
        final String programDrones = "Program drones to do that.";
        final String programRobot = "Program robot to do this.";
        final String eat = "Scientist eating don't disturb.";

        assertEquals(adviceJedis, mediator.handleScientist(ScientistStates.ADVICEJEDI));
        System.out.println("Scientist advice OK");

        assertEquals(programDrones, mediator.handleScientist(ScientistStates.PROGRAMDRONE));
        System.out.println("Scientist advice OK");

        assertEquals(programRobot, mediator.handleScientist(ScientistStates.PROGRAMROBOT));
        System.out.println("Scientist advice OK");

        assertFalse(eat.equals(mediator.handleRobots(null)));
        System.out.println("Scientist eat  OK");
    }

    /**
     * testScientistStates() is responsible for testing the state of the scientist.
     *
     * Using the getState() and setState() methods to check the state of the
     * scientist
     */
    @Test
    public void testScientistStates() {
        System.out.print("Testing the states of the Scientist");
        final Mediator mediator = new Mediator();
        final Scientist scientist = new Scientist(mediator);

        scientist.setState(ScientistStates.ADVICEJEDI);
        assertEquals(ScientistStates.ADVICEJEDI, scientist.getState());
        System.out.println("Scientist advice jedis state OK");

        scientist.setState(ScientistStates.PROGRAMDRONE);
        assertEquals(ScientistStates.PROGRAMDRONE, scientist.getState());
        System.out.println("Scientist program drones state OK");

        scientist.setState(ScientistStates.PROGRAMROBOT);
        assertEquals(ScientistStates.PROGRAMROBOT, scientist.getState());
        System.out.println("Scientist program robotos state OK");

        assertFalse(ScientistStates.ADVICEJEDI.equals(mediator.handleScientist(null)));
        System.out.println("Scientist state null OK");

    }

    /**
     * Do this after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing Scientist class");
    }
}
