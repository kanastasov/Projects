package mediatordesignpatternmba;

import javax.swing.JFrame;

/**
 * <p>MediatorDesignPatternMBA is the class with the main method and creates the
 * JFrame for the GUI and calls the MediatorGUI class where is the GUI of the
 * program.</p>
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
public class MediatorDesignPatternMBA {
    /**
     * main(String[] args) is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * FRAME_WIDTH represent the width of the frame.
         */
        final int frameWidth = 1200;
        /**
         * FRAME_HEIGHT represent the height of the frame.
         */
        final int frameHeight = 850;
        final JFrame application = new JFrame();
        final MediatorGUI panel = new MediatorGUI();
        application.add(panel);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        application.setSize(frameWidth, frameHeight);
        application.setLocationRelativeTo(panel);
        application.setResizable(true);
        application.setVisible(true);
    }
}
