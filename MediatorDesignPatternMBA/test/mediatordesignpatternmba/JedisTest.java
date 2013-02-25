package mediatordesignpatternmba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>A set of unit tests to check the states of the jedis.</p>
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
public class JedisTest {

    /**
     * Do this before any tests have run.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Jedi class");
    }

    /**
     * jedisReac() is responsible for testing the Jedis.
     *
     * Using the handleJedis() method to check the return String of the Jedis.
     */
    @Test
    public void jedisReac() {
        System.out.print("Testing simple jedis");
        final Mediator mediator = new Mediator();

        final String jedisAttack = "Jedis are charging!";
        final String jedisDefend = "Jedis are in protection mode.";
        final String jedisHold = "Jedis are in hold position.";
        final String jedisNegotiate = "Jedis are waiting for advice from the computer scientist to negotiate.";
        final String jedisDrinking = "Jedis drinking beer.";

        assertEquals(jedisAttack, mediator.handleJedis(JediStates.ATTACK));
        System.out.println("Jedis charging OK");

        assertEquals(jedisDefend, mediator.handleJedis(JediStates.DEFEND));
        System.out.println("Jedis defending OK");

        assertEquals(jedisHold, mediator.handleJedis(JediStates.HOLD));
        System.out.println("Jedis holding OK");

        assertEquals(jedisNegotiate, mediator.handleJedis(JediStates.NEGOTIATE));
        System.out.println("Jedis negotiating OK");

        assertFalse(jedisDrinking.equals(mediator.handleJedis(null)));
        System.out.println("Jedis drinking  OK");
    }

    /**
     * testJediStates() is responsible for testing the state of the jedis.
     *
     * Using the getState() and setState() methods to check the state of the
     * jedis
     */
    @Test
    public void testJediStates() {
        System.out.print("Testing the states of the jedis");
        final Mediator mediator = new Mediator();
        final Jedi jedi = new Jedi(mediator);

        jedi.setState(JediStates.ATTACK);
        assertEquals(JediStates.ATTACK, jedi.getState());
        System.out.println("Jedi state attack OK");

        jedi.setState(JediStates.DEFEND);
        assertEquals(JediStates.DEFEND, jedi.getState());
        System.out.println("Jedi state defend OK");

        jedi.setState(JediStates.HOLD);
        assertEquals(JediStates.HOLD, jedi.getState());
        System.out.println("Jedi state hold OK");

        jedi.setState(JediStates.NEGOTIATE);
        assertEquals(JediStates.NEGOTIATE, jedi.getState());
        System.out.println("Jedi state negotiate OK");

        assertFalse(JediStates.NEGOTIATE.equals(mediator.handleJedis(null)));
        System.out.println("jedi state null OK");

    }

    /**
     * Do this after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing Jedi class");
    }
}
