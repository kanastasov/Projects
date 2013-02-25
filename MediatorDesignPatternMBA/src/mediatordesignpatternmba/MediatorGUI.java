package mediatordesignpatternmba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * <p>MediatorGUI is responsible for creating the GUI for the program and
 * communication with the mediator.</p>
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
public class MediatorGUI extends JPanel implements ActionListener {
    /**
     * mediator instantiate the mediator object so the GUI can communicate with
     * the Mediator which is going to communicate with the concrete classes.
     */
    private final Mediator mediator = new Mediator();
    /**
     * drones object responsible for getting and setting the state of the
     * drones.
     */
    private DroneConstruction drones;
    /**
     * jedi object responsible for getting and setting the state of the jedis.
     */
    private Jedi jedi;
    /**
     * robots object responsible for getting and setting the state of the
     * robots.
     */
    private RobotPressurizedRover robots;
    /**
     * scientists object responsible for getting and setting the state of the
     * scientists.
     */
    private Scientist scientists;
    /**
     * commandButtons represent the buttons that are handled with the Mediator.
     */
    private JButton[] commandButtons = {new JButton("Drones"),
        new JButton("Jedis"),
        new JButton("Robots"),
        new JButton("Scientist")};
    /**
     * image stores the images for the GUI.
     */
    protected static ImageIcon[] image = {new ImageIcon("Pictures/symbol.png"),
        new ImageIcon("Pictures/robotDanger.png"),
        new ImageIcon("Pictures/robotExplore.png"),
        new ImageIcon("Pictures/robotReport.png"),
        new ImageIcon("Pictures/robotSearch.png"),
        new ImageIcon("Pictures/jediAttack.png"),
        new ImageIcon("Pictures/jediDefence.png"),
        new ImageIcon("Pictures/jediHold.png"),
        new ImageIcon("Pictures/jediNegotiate.png"),
        new ImageIcon("Pictures/droneHouses.png"),
        new ImageIcon("Pictures/dronesBunkers.png"),
        new ImageIcon("Pictures/dronesLabs.png"),
        new ImageIcon("Pictures/scientistAdvice.png"),
        new ImageIcon("Pictures/scientistDrone.png"),
        new ImageIcon("Pictures/scientistRobot.png")};
    /**
     * imgLabel is responsible for presenting the image.
     */
    protected static JLabel imgLabel = new JLabel();
    /**
     * messages is responsible for displaying the message from the mediator.
     */
    private JLabel messages;
    /**
     * centralPanel this is where the image is placed.
     */
    private JPanel centralPanel;
    /**
     * southPanel here are placed the buttons and the label for the text.
     */
    private JPanel southPanel;
    /**
     * westPanel here are placed the states of the jedi/drones/robots/scientist
     * and the labels for the text.
     */
    private JPanel westPanel;
    /**
     * northPanel here are placed the states of westPanel.
     */
    private JPanel northPanel;
    /**
     * three represent the number 3 and is used to access the third element from
     * the buttons and the imageicons.
     */
    private final int three = 3;
    /**
     * four represent the number 4 and is used to access the fourth element from
     * the buttons and the imageicons.
     */
    private final int four = 4;
    /**
     * twentyfour represent the number 24 and is used to set the font of the
     * text.
     */
    private final int twentyfour = 24;
    /**
     * droneStates a combo box for the states of the drones.
     */
    private JComboBox droneStates;
    /**
     * jediStates a combo box for the states of the jedis.
     */
    private JComboBox jediStates;
    /**
     * robotStates a combo box for the states of the robots.
     */
    private JComboBox robotStates;
    /**
     * scientistStates a combo box for the states of the scientist.
     */
    private JComboBox scientistStates;
    /**
     * MediatorGUI() A default constructor responsible for setting the GUI.
     */
    protected MediatorGUI() {
        drones = new DroneConstruction(mediator);
        jedi = new Jedi(mediator);
        robots = new RobotPressurizedRover(mediator);
        scientists = new Scientist(mediator);
        this.setLayout(new BorderLayout());
        southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createLineBorder(Color.green, 2));
//        add all the buttons to the southPanel
        for (JButton i : commandButtons) {
            southPanel.add(i);
            i.addActionListener(this);
        }
        messages = new JLabel("Waiting for your commands my lord.");
        southPanel.add(messages);
//        add the southPanel to the main Panel to the SOUTH
        this.add(southPanel, BorderLayout.SOUTH);
        westPanel = new JPanel(new GridLayout(four, 2));
        westPanel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
//        pass the values of the DroneStates to the JComboBox droneStates
        droneStates = new JComboBox(DroneStates.values());
//        select a default chosen item for the droneStates
        droneStates.setSelectedIndex(0);
//        add it to the actionListener
        droneStates.addActionListener(this);
        westPanel.add(new JLabel("Select a state for the Drones: "));
//         add it to the westPanel
        westPanel.add(droneStates);
        jediStates = new JComboBox(JediStates.values());
        jediStates.setSelectedIndex(0);
        jediStates.addActionListener(this);
        westPanel.add(new JLabel("Select a state for the Jedis: "));
        westPanel.add(jediStates);
        robotStates = new JComboBox(RobotStates.values());
        robotStates.setSelectedIndex(0);
        robotStates.addActionListener(this);
        westPanel.add(new JLabel("Select a state for the Robots: "));
        westPanel.add(robotStates);
        scientistStates = new JComboBox(ScientistStates.values());
        scientistStates.setSelectedIndex(0);
        scientistStates.addActionListener(this);
        westPanel.add(new JLabel("Select a state for the Scientists: "));
        westPanel.add(scientistStates);
        northPanel = new JPanel();
        northPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        northPanel.add(westPanel, BorderLayout.NORTH);
        this.add(northPanel, BorderLayout.WEST);
        centralPanel = new JPanel();
        centralPanel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        imgLabel = new JLabel(image[0]);
        centralPanel.add(imgLabel);
        this.add(centralPanel, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
//        set the font of the label to arial bolt with 24 size
        messages.setFont(new Font("Arial", Font.BOLD, twentyfour));
        if (ae.getSource() == commandButtons[0]) {
//          set the txt of the messages label with the return value of the handleDrones
            messages.setText(mediator.handleDrones(drones.getState()));
        } else if (ae.getSource() == commandButtons[1]) {
            messages.setText(mediator.handleJedis(jedi.getState()));
        } else if (ae.getSource() == commandButtons[2]) {
            messages.setText(mediator.handleRobots(robots.getState()));
        } else if (ae.getSource() == commandButtons[three]) {
            messages.setText(mediator.handleScientist(scientists.getState()));
        } else if (ae.getSource() == droneStates) {
            System.out.println(droneStates.getSelectedItem());
            if (droneStates.getSelectedItem().equals(DroneStates.BUILDBUNKERS)) {
                drones.setState(DroneStates.BUILDBUNKERS);
            } else if (droneStates.getSelectedItem().equals(DroneStates.BUILDHOUSES)) {
                drones.setState(DroneStates.BUILDHOUSES);
            } else if (droneStates.getSelectedItem().equals(DroneStates.BUILDLABS)) {
                drones.setState(DroneStates.BUILDLABS);
            }
//            better solution would be to use
//            messages.setText(mediator.handleDrones(DroneStates.BUILDBUNKERS));
//            and that would not require to use the buttons but in this way with
//            the setState is more ilustrative even that is not that effective
        } else if (ae.getSource() == jediStates) {
            System.out.println(jediStates.getSelectedItem());
            if (jediStates.getSelectedItem().equals(JediStates.ATTACK)) {
                jedi.setState(JediStates.ATTACK);
            } else if (jediStates.getSelectedItem().equals(JediStates.DEFEND)) {
                jedi.setState(JediStates.DEFEND);
            } else if (jediStates.getSelectedItem().equals(JediStates.HOLD)) {
                jedi.setState(JediStates.HOLD);
            } else if (jediStates.getSelectedItem().equals(JediStates.NEGOTIATE)) {
                jedi.setState(JediStates.NEGOTIATE);
            }
        } else if (ae.getSource() == robotStates) {
            System.out.println(robotStates.getSelectedItem());
            if (robotStates.getSelectedItem().equals(RobotStates.DANGER)) {
                robots.setState(RobotStates.DANGER);
            } else if (robotStates.getSelectedItem().equals(RobotStates.EXPLORE)) {
                robots.setState(RobotStates.EXPLORE);
            } else if (robotStates.getSelectedItem().equals(RobotStates.REPORT)) {
                robots.setState(RobotStates.REPORT);
            } else if (robotStates.getSelectedItem().equals(RobotStates.SEARCH)) {
                robots.setState(RobotStates.SEARCH);
            }
        } else if (ae.getSource() == scientistStates) {
            System.out.println(scientistStates.getSelectedItem());
            if (scientistStates.getSelectedItem().equals(ScientistStates.ADVICEJEDI)) {
                scientists.setState(ScientistStates.ADVICEJEDI);
            } else if (scientistStates.getSelectedItem().equals(ScientistStates.PROGRAMDRONE)) {
                scientists.setState(ScientistStates.PROGRAMDRONE);
            } else if (scientistStates.getSelectedItem().equals(ScientistStates.PROGRAMROBOT)) {
                scientists.setState(ScientistStates.PROGRAMROBOT);
            }
        }
    }
}
