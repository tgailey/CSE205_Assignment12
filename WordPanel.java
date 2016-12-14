// Assignment #: 12
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: Panel that holds all the words, two of them are created

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class WordPanel extends JPanel {
	
	//A string for the word that will be animated
	private String word;
	//A Color for the color of the word
	private Color color;
	//A int for the x-coordinate of the created word
	private int currentX;
	//A int for the y-coordinate of the created word
	private int currentY;
	//A int to what to increase the x-coordinate each time the timer goes off
	private int stepX;
	//A int to what to increase the y-coordinate each time the timer goes off
	private int stepY;
	//An arraylist of all the created words
	private ArrayList<Word> wordList;
	//The timer that creates a word everytime it goes off
	private Timer timer;
	//Amount of time that passes before timer goes off
	private int delay;
	
	public WordPanel (Color color, String initialWord) {
		//Set color to given color and word to given word
		this.color = color;
		word = initialWord;
		//Set the values to default value
		delay = 400;
		stepX = 30;
		stepY = 30;
		setBackground(Color.black);
		currentX = 0;
		currentY = 10;
		wordList = new ArrayList<Word>();
		timer = new Timer(delay, new MoveListener());
	}
	public void resume() {
		//start the timer when this method is called
		timer.start();
	}
	public void suspend(){
		//Stop timer when this method is called
		timer.stop();
	}
	public void clear() {
		//Clear all the words in the list and redraw the canvas with new list (of nothing)
		wordList.clear();
		repaint();
	}
	public void setWord(String newWord) {
		//Set the word to the new word provided
		word = newWord;
	}
	public void setDelay (int newDelay) {
		//Set the timer's delay to the new delay provided
		delay = newDelay;
		timer.setDelay(delay);
	}
	public void paintComponent (Graphics page) {
		//Everytime this is called, draw every word in the arraylist
		super.paintComponent(page);
		for (int i = 0; i < wordList.size(); i++) {
			wordList.get(i).drawWord(page);
		}
	}
	private class MoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//When the timer goes off, move the coordinates by the given step
			//and add it to the list.
			//Reverse direction if need be.
			currentX += stepX;
			currentY += stepY;
			wordList.add(new Word(word, currentX, currentY, color));
			repaint();
			if (currentX + stepX < 0 || currentX + stepX > getSize().getWidth()-word.length()*7) {
				stepX = stepX * -1;
			}
			if (currentY+stepY < 10 || currentY+stepY > getSize().getHeight()) {
				stepY = stepY * -1;
			}
		}
	}
}
