package mediatordesignpatternmba;

/**
 * <p>RobotPressurizedRover represent a pressurized rover which is responsible
 * for the the exploration on the Mars territory.</p>
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
public class RobotPressurizedRover implements Command {
    /**
     * mediator is an object of type Mediator which is responsible for
     * communication between the Robots and the Mediator.
     */
    private Mediator mediator;
    /**
     * state is enum type of possible DANGER/EXPLORE/REPORT/SEARCH.
     */
    private RobotStates state;
    /**
     * RobotPressurizedRover(Mediator mediator) is constructor responsible for
     * initializing the mediator object.
     *
     * @param mediator initialize the local variable mediator.
     */
    public RobotPressurizedRover(Mediator mediator) {
        this.mediator = mediator;
    }
    /**
     * getState() gets the state of the robot.
     *
     * @return state
     */
    public RobotStates getState() {
        return state;
    }
    /**
     * setState(RobotStates state) sets the state of the robot.
     *
     * @param state set the current state with the passed value.
     */
    public void setState(RobotStates state) {
        this.state = state;
    }
    @Override
    public void handle() {
        mediator.handleRobots(state);
    }
}
