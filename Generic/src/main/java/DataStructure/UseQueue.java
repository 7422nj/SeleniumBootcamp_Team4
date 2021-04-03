package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) {

        //We cannot create instance of a Queue since it is an interface, thus we
        Queue<String> q1 = new LinkedList<String>();
//Adding elements to the Queue
        q1.add("I");
        q1.add("Enjoy");
        q1.add("Sleeping");
        q1.add("And");
        q1.add("Eating");
        System.out.println("Elements in Queue:"+q1);
        System.out.println("********************************************");
        /*
         * We can remove an element from Queue using remove() method,
         *this removes the first element from the Queue
         */
        System.out.println("Removed element: "+q1.remove());
        System.out.println("********************************************");
        /*
         *element() method - this returns the head of the
         *Queue.
         */
        System.out.println("Head: "+q1.element());
        System.out.println("********************************************");
        /*
         *poll() method - this removes and returns the
         *head of the Queue. Returns null if the Queue is empty
         */
        System.out.println("poll(): "+q1.poll());
        /*
         *peek() method - it works same as element() method,
         *however, it returns null if the Queue is empty
         */
        System.out.println("peek(): "+q1.peek());
        System.out.println("********************************************");
//Displaying the elements of Queue
        System.out.println("Elements in Queue:"+q1);
    }

}
