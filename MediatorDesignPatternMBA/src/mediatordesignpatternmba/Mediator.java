package mediatordesignpatternmba;

import javax.swing.JLabel;

/**
 * <p>Mediator represent the mediator which communicate with other objects like
 * Jedi so in case of adding additional object it will be easier to implement it
 * and maintain.</p>
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
public class Mediator {
    /**
     * jedi represent an object of type Jedi who is responsible for protecting
     * the republic.
     */
    private Jedi jedi;
    /**
     * construction is an object of type DroneConstruction who is responsible
     * for building new labs, and defense bases.
     */
    private DroneConstruction construction;
    /**
     * pressuruzedRover is an object of type RobotPressurizedRover who is
     * responsible for exploration of the Mars.
     */
    private RobotPressurizedRover pressuruzedRover;
    /**
     * computerScientist is an object of type Scientist who is responsible for
     * programming the DroneConstruction & RobotPressurizedRover.
     */
    private Scientist computerScientist;
    /**
     * three represent the number 3.
     */
    private final int three = 3;
    /**
     * four represent the number 4.
     */
    private final int four = 4;
    /**
     * five represent the number 5.
     */
    private final int five = 5;
    /**
     * six represent the number 6.
     */
    private final int six = 6;
    /**
     * seven represent the number 7.
     */
    private final int seven = 7;
    /**
     * eight represent the number 8.
     */
    private final int eight = 8;
    /**
     * nine represent the number 9.
     */
    private final int nine = 9;
    /**
     * ten represent the number 10.
     */
    private final int ten = 10;
    /**
     * eleven represent the number 11.
     */
    private final int eleven = 11;
    /**
     * twenlve represent the number 12.
     */
    private final int twenlve = 12;
    /**
     * thirteen represent the number 13.
     */
    private final int thirteen = 13;
    /**
     * fourteen represent the number 14.
     */
    private final int fourteen = 14;
    /**
     * Mediator() is a default constructor that initializes a new mediator.
     *
     */
    public Mediator() {
        jedi = new Jedi(this);
        construction = new DroneConstruction(this);
        pressuruzedRover = new RobotPressurizedRover(this);
        computerScientist = new Scientist(this);
    }
    /**
     * handleDrones(DroneStates state) is a method responsible for handling the
     * drones states.
     *
     * @param state represent the state of the drones
     * @return the state of the robot.
     */
    public String handleDrones(DroneStates state) {
        if (state == DroneStates.BUILDHOUSES) {
            System.out.println("Drones building houses for jedis!");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[nine]);
            return "Drones building houses for jedis!";
        } else if (state == DroneStates.BUILDBUNKERS) {
            System.out.println("Drones building a bunkers for defence:");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[ten]);
            return "Drones building a bunkers for defence.";
        } else if (state == DroneStates.BUILDLABS) {
            System.out.println("Drones building a laboratories for scientist.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[eleven]);
            return "Drones building a laboratories for scientist.";
        } else {
            System.out.println("Specify a state for the drones");
            return "Specify a state for the drones";
        }
    }
    /**
     * handleJedis(JediStates state) is a method responsible for handling the
     * states of the jedis.
     *
     * @param state represent the state of the jedis
     * @return the state of the jedis.
     */
    public String handleJedis(JediStates state) {
        if (state == JediStates.ATTACK) {
            System.out.println("Jedis are charging!");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[five]);
            return "Jedis are charging!";
        } else if (state == JediStates.DEFEND) {
            System.out.println("Jedis are in protection mode.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[six]);
            return "Jedis are in protection mode.";
        } else if (state == JediStates.HOLD) {
            System.out.println("Jedis are in hold position.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[seven]);
            return "Jedis are in hold position.";
        } else if (state == JediStates.NEGOTIATE) {
            System.out.println("Jedis are waiting for advice from the computer scientist to negotiate.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[eight]);
            return "Jedis are waiting for advice from the computer scientist to negotiate.";
        } else {
            System.out.println("Specify a state for the jedis");
            return "Specify a state for the Jedis";
        }
    }
    /**
     * handleRobots(RobotStates state) is a method responsible for the handling
     * the state of the Robots.
     *
     * @param state represent the state of the robots.
     * @return the state of the robot.
     */
    public String handleRobots(RobotStates state) {
        if (state == RobotStates.DANGER) {
            System.out.println("Huston we have a problem!, big danger comming.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[1]);
            return "Huston we have a problem!, big danger comming.";
        } else if (state == RobotStates.EXPLORE) {
            System.out.println("Robot exploring the environment.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[2]);
            return "Robot exploring the environment.";
        } else if (state == RobotStates.REPORT) {
            System.out.println("Robot report to the headquarters");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[three]);
            return "Robot report to the headquarters.";
        } else if (state == RobotStates.SEARCH) {
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[four]);
            System.out.println("Robot searching.");
            return "Robot searching.";
        } else {
            System.out.println("Specify a state for the robots");
            return "Specify a state for the robots";
        }
    }
    /**
     * handleScientist(ScientistStates state) is a method responsible for the
     * handling the state of the scientists.
     *
     * @param state represent the state of the scientists.
     * @return the state of the scientist.
     */
    public String handleScientist(ScientistStates state) {
        if (state == ScientistStates.ADVICEJEDI) {
            System.out.println("Jedi calm down and listen to me!");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[twenlve]);
            return "Jedi calm down and listen to me!";
        } else if (state == ScientistStates.PROGRAMDRONE) {
            System.out.println("Program drones to do that");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[thirteen]);
            return "Program drones to do that.";
        } else if (state == ScientistStates.PROGRAMROBOT) {
            System.out.println("Program robot to do this.");
            MediatorGUI.imgLabel.setIcon(MediatorGUI.image[fourteen]);
            return "Program robot to do this.";
        } else {
            System.out.println("Specify a state for the scientists");
            return "Specify a state for the scientists";
        }
    }
}
