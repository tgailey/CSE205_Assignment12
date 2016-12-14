// Assignment #: 12
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: The ControlPane class creates 2 beams panels and
//               control panels that control their movement.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel
 {
  private int width, height;
  private int panelNum;

  //The constructor creates creates 2 word control panels
  //that control their movement, and organize them using a layout
  public ControlPanel(int width, int height)
   {
       this.width = width;
       this.height = height;
       panelNum = 2; //the number of beams panels is 2

       //create 2 panels to control the movement of beams
       WordControlPanel[] wordPanels;
       wordPanels = new WordControlPanel[panelNum];

       wordPanels[0] = new WordControlPanel(width, height/panelNum, Color.RED, "Hello");
       wordPanels[1] = new WordControlPanel(width, height/panelNum, Color.BLUE, "Bye");

       //add two beams panels into this control panel using GridLayout
       setLayout(new GridLayout(panelNum, 1));
       for (int i = 0; i < panelNum; i++)
            add(wordPanels[i]);

       setPreferredSize(new Dimension(width,height));
    }
}