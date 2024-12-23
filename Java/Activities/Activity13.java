package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// Create the objects
		Scanner scan = new Scanner(System.in);
		List<Integer> numArr = new ArrayList<>();
		Random indexGen = new Random();
		// Statements to show users to indicate when they can type
		System.out.println("Enter the numbers for the list");
		System.out.println("Enter a EOL or any non-integer character to stop:");

		// Loop to take only integers from console
		while (scan.hasNextInt()) {
			numArr.add(scan.nextInt());
		}

		// Generate a random index
		int generatedIndex = indexGen.nextInt(numArr.size());

		// Print the random index and the value at that index
		System.out.println("Random index generated: " + generatedIndex);
		System.out.println("The number at generated index is: " + numArr.get(generatedIndex));
	}

}
