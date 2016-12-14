// Assignment #: 12
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: The WordControlPane class creates 4 buttons, 1 label, 1 textfield
//               and 1 sliders to to control the movement of words,
//               and also contains a panel displaying words.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class WordControlPanel extends JPanel
 {
      //components of the panel
      private WordPanel wPanel;
      private JButton start, stop, clear, change;
      private JSlider speed;
      private JLabel label1;
      private JPanel buttons1;
      private JTextField wordField;

      private int width, height;
      private Color color;

      //Constructor to create all components, add their listener to them,
      //and arrange them using a layout.
      public WordControlPanel(int width, int height, Color initialColor, String initialString)
       {
           color = initialColor;
           this.width = width;
           this.height = height;

           //create a panel displaying words, with the specified color
           wPanel = new WordPanel(initialColor, initialString);

           //create 3 buttons, start, stop, and clear
           start = new JButton("Start");
           stop = new JButton("Stop");
           clear = new JButton("Clear");

           //add a listener to each button
           start.addActionListener(new ButtonListener());
           stop.addActionListener(new ButtonListener());
           clear.addActionListener(new ButtonListener());

           buttons1 = new JPanel();
           buttons1.setLayout(new GridLayout(1,3));

           buttons1.add(start);
           buttons1.add(stop);
           buttons1.add(clear);

           //create a button to change the word
           change = new JButton("Change the word");
           change.addActionListener(new ButtonListener());
           
           //create a textfield to enter a word
           wordField = new JTextField(initialString);
           
           //create a label for the delay
           label1 = new JLabel("Delay");

           //create a slider for the delay with major tick spacing 100,
           //minor tick spacing 25. The minimum value is 200, the maximum
           //is 600, and the initial set value is 400.
           speed = new JSlider(JSlider.HORIZONTAL, 200, 600, 400);
           speed.setMajorTickSpacing(100);
           speed.setMinorTickSpacing(25);
           speed.setPaintTicks(true);
           speed.setPaintLabels(true);
           speed.setAlignmentX(Component.LEFT_ALIGNMENT);
           speed.addChangeListener(new SpeedListener());
           

           JPanel panel5 = new JPanel();
           panel5.setLayout(new GridLayout(5,1));
           panel5.add(buttons1);
           panel5.add(change);
           panel5.add(wordField);
           panel5.add(label1);
           panel5.add(speed);

           setLayout(new BorderLayout());
           panel5.setPreferredSize(new Dimension(width/3, height));
           add(wPanel, BorderLayout.CENTER);
           add(panel5, BorderLayout.WEST);

      }

  //ButtonListener defines actions to be performed when each button
  //is pushed.
  private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
        {
            Object action = event.getSource();
            
            //If the button pressed is start, resume the animation
            if (action.equals(start)) {
            	wPanel.resume();
            }
            //If the button pressed is stop, stop the animation
            else if (action.equals(stop)) {
            	wPanel.suspend();
            }
            //IF the button pressed is clear, clear all the words
            else if (action.equals(clear)) {
            	wPanel.clear();
            }
            //If the button pressed is change, change the word to entered string
            else if (action.equals(change)) {
            	wPanel.setWord(wordField.getText());
            }

         }
     } //end of ButtonListener

   //SpeedListener adjust the delay of words drawing movement based on
   //the chosen integer in the corresponding slider.
   private class SpeedListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent event)
         {
        	//When the slider is set, change the speed of the timer to selected value
             wPanel.setDelay(speed.getValue());
         }

     } //end of SpeedListener
 }