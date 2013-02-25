package mediatordesignpatternmba;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>A set of unit tests to check the states of the drones.</p>
 *
 * <p>This program is part of the solution for the first ICA for AJP in Teesside University.</p>
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
public class DronesTest {
    
    /**
     * Do this before any tests have run.
     */
    @BeforeClass
    public static void setUpClass() {
         System.out.println("Testing DroneConstruction class");
    }
    
    
    /**droneConstruction() is responsible for testing the drones.
     * 
     * Using the handleDrones() method to check the return String of the drones. 
     */
    @Test
    public void droneConstruction() {
        System.out.print("Testing simple droneConstruction");
        final Mediator mediator = new Mediator();
        
        final String dronesBuildingHouses = "Drones building houses for jedis!";
        final String dronesBuildingLabs = "Drones building a laboratories for scientist.";
        final String dronesBuildingBunkers = "Drones building a bunkers for defence.";
        final String dronesBuildingSomething = "Drones building what they are not supposed to.";
        
        assertEquals(dronesBuildingHouses ,  mediator.handleDrones(DroneStates.BUILDHOUSES));
        System.out.println("Drones building houses OK");
        
        assertEquals(dronesBuildingLabs,  mediator.handleDrones(DroneStates.BUILDLABS));
        System.out.println("Drones building Labs OK");
        
        assertEquals(dronesBuildingBunkers,  mediator.handleDrones(DroneStates.BUILDBUNKERS));
        System.out.println("Drones building bunkers OK");
        
        assertFalse(dronesBuildingSomething.equals(mediator.handleDrones(null)));
        System.out.println("Drones building something else  OK");
        
    }
    
    /**
     * testDronesStates() is responsible for testing the state of the drones.
     *
     * Using the getState() and setState() methods to check the state of the
     * drones
     */
    @Test
    public void testDronesStates() {
        System.out.print("Testing the states of the drones");
        final Mediator mediator = new Mediator();
        final DroneConstruction drones = new DroneConstruction(mediator);

        drones.setState(DroneStates.BUILDBUNKERS);
        assertEquals(DroneStates.BUILDBUNKERS, drones.getState());
        System.out.println("drones building bunkers state OK");

        drones.setState(DroneStates.BUILDHOUSES);
        assertEquals(DroneStates.BUILDHOUSES, drones.getState());
        System.out.println("drones building houses state OK");
        
        drones.setState(DroneStates.BUILDLABS);
        assertEquals(DroneStates.BUILDLABS, drones.getState());
        System.out.println("drones building labs state OK");

        assertFalse(DroneStates.BUILDLABS.equals(mediator.handleDrones(null)));
        System.out.println("drones state null OK");

    }
    
    /**
     * Do this after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing DroneConstruction class");
    }
}
