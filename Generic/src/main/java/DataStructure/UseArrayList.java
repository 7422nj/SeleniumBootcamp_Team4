package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;

public class UseArrayList {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Be");
        list.add("The");
        list.add("Change");
        list.add("That");
        list.add("You");
        list.add("Wish");
        list.add("To");
        list.add("See");
        list.add("In");
        list.add("The");
        list.add("World");

        // Displaying the list
        System.out.println("The list is: \n"
                + list);
        // Create an iterator for the list
        // using iterator() method
        Iterator<String> iter = list.iterator();

        // Displaying the values after iterating
        // through the list
        System.out.println("\nThe iterator values"
                + " of list are: ");
        {
        }
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        String arr[] = {" ", " - Mahatma Gandhi - "};
        for (String str : arr) {
            System.out.println(str);

        }
        {
            System.out.println("***********************************");
            // Removing a word from  the quote by choosing number of line and String variableName
            System.out.println(" Word You Want To Remove: ");
            System.out.println(list.get(10));
            System.out.println();
            list.remove("World");
            System.out.println("***********************************");
            // After removal of the word from the list
            System.out.println("List after removal of the word: ");
            System.out.println(list);
        }
    }

}
