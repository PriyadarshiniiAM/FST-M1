package activities;

import java.util.ArrayList;
import java.util.List;
public class Activity9 {
	
	    public static void main(String[] args) {
	        //Creating ArrayList
	    	List<String> myList = new ArrayList<>();
	        //ArrayList<String> myList = new ArrayList<String>();
	    	
	        //Add 5 names to the list
	        myList.add("Apple");
	        myList.add("Mango");
	        myList.add("Orange");
	        myList.add(3, "Guava");
	        myList.add(1, "Papaya");//it will replace the index 1 value from Mango to Papaya and Mango will move to next index.
	        
	        //print all elements using a loop
	        for(String s:myList){
	            System.out.println(s);
	        }
	        
	        //print the 3rd element
	        System.out.println("Third element is: " + myList.get(2));
	        
	        //Search for a specific name
	        System.out.println("Is Banana is in list: " + myList.contains("Banana"));
	        
	        //print the size of the list
	        System.out.println("No. of elements int he list before remove: " + myList.size());
	        
	        //Remove an element
	        //myList.remove(1);
	        myList.remove("Guava");
	        
	        //print the size of the list after remove
	        
	        System.out.println("No. of elements in the list after remove: " + myList.size());
	    }
}
