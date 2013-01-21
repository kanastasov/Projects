package mediatordesignpatternmba;

/**
 * <p>DroneStates is a enum type which represent the possible states of the
 * Drones which are BUILDHOUSES/BUILDLABS/BUILDBUNKERS,</p>
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
public enum DroneStates {
    /**
     * BUILDHOUSES represent the state of building houses for living.
     */
    BUILDHOUSES,
    /**
     * BUILDLABS represent the state of building laboratories for investigation.
     */
    BUILDLABS,
    /**
     * BUILDBUNKERS represent the state of building bunkers for defense.
     */
    BUILDBUNKERS;
}
