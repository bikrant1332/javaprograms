package in.bjena.javacollection.LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<>();
		// Add elements to LinkedList
	    animals.add("Dog");
	    animals.add("Cat");
	    animals.add("Cow");
	    System.out.println("LinkedList: " + animals);
	    
	    //add() method used to add elements to the list
	    animals.add(2, "Tiger");
	    System.out.println("LinkedList: " + animals);
	    animals.addFirst("Lion");
	    animals.addLast("Elephant");
	   
	    System.out.println("LinkedList: " + animals);
	    
	    //get() method used to access the elements from the list
	    String str = animals.get(1);
	    System.out.println("str: " + str);
	    
	    //set() method used for setting a value for a node
	    animals.set(4, "Bull");
	    System.out.println("LinkedList: " + animals);

	    //remove()
	    String removedElement= animals.remove(1);
	    System.out.println("removedElement: " + removedElement);
	    System.out.println("LinkedList: " + animals);	

	}

}
