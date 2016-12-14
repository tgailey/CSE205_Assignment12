// Assignment #: 12
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: Word class that holds the necessary components of each word

import java.awt.Color;
import java.awt.Graphics;

public class Word {
	//String for the actual word
	private String word;
	//Color of the drawn word
	private Color color;
	//The x-coordinate of the drawn word
	private int x;
	//The y-coordinate of the drawn word
	private int y;
	
	public Word(String word1, int x1, int y1, Color color1) {
		//Set values with given constructor values
		word = word1;
		color = color1;
		x = x1;
		y = y1;
	}
	
	public void drawWord(Graphics page) {
		//Set the color to the given color and draw the word using the drawString method.
		page.setColor(color);
		page.drawString(word, x, y);
	}
}
