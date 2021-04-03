package DataStructure.DataStructureAndAlgorithm;

// Java provides a data structure, The Array, which stores a fixed-size sequential collection of elements of the same type.
// An array is used to store a collection of data
// But it is often more useful to think of an array as a collection of variables of the same type.
//
// Array can contain primitives (int, char, etc.) as well as object (or non-primitive) references of a class
// Depending on the definition of the array.
// In case of primitive data types, the actual values are stored in contiguous memory locations.
// In case of objects of a class, the actual objects are stored in heap segment.
//
// One-Dimensional Arrays :
// The general form of a one-dimensional array declaration is:
// type variable-name[];
// OR
// type[] variable-name;
//
// An array declaration has two components: the type and the name.
// Type declares the element type of the array.
// The element type determines the data type of each element that comprises the array.
//
// Both Of These Are Valid Declarations:
//int intArray[];
//or int[] intArray;
//
//How to do it for every dataType:
//byte byteArray[];
//short shortsArray[];
//boolean booleanArray[];
//long longArray[];
//float floatArray[];
//double doubleArray[];
//char charArray[];
//
// An Array of References to Objects of the Class MyClass (a class created by user)
// MyClass myClassArray[];
//
//  Object[]  ao,        // array of Object
// Collection[] ca;     // array of Collection
//                     // of unknown type
//
//
// Instantiating an Array in Java:
//
// When an array is declared, only a reference of array is created.
// To actually create or give memory to array
// You create an array like this:The general form of new as it applies to one-dimensional arrays appears as follows:
//
// var-name = new type [size];
//
// Here, type specifies the type of data being allocated
// Size specifies the number of elements in the array
// Var-name is the name of array variable that is linked to the array.
// That is, to use new to allocate an array, you must specify the type and number of elements to allocate.
//
// For Example:
//
// int intArray[];           // Declaring Array
// intArray = new int[20];  // Allocating Memory To Array
//
// OR
//
// int[] intArray = new int[20]; // Combining Both Statements In One

import java.util.Arrays;

public class LearnArrayWithMethod { // Class named LearnArrayWithMethod
    public static void main(String[] args) { // Main Method

        int[] numbers = {23, 34, 65, 12, 7, 102, 87, 46, 304}; // Created an Array

        LearnArrayWithMethod.checkMinimum(numbers);  // Used to CheckMinimum Number in Array
        LearnArrayWithMethod.checkMaximum(numbers); // Used to CheckMaximum Number in Array
        LearnArrayWithMethod.getArray();           // We are calling the getArray Method we made
        System.out.println(Arrays.stream(LearnArrayWithMethod.getArray()).min()); // Minimum Value in our getArray

    }

    /**
     * this method will check Minimum value from an Array
     */

    //  Created a Method called checkMinimum with int num[] as our Parameter
    static void checkMinimum(int num[]) {

        //Initializing that int min equals num with the starting value of 0
        int min = num[0];

        // Initializing i equals 10; if i is less than num.length; print in incremental order
        for (int i = 0; i < num.length; i++) {

            // If min is greater than num[i] <-- i is a variableName
            if (min > num[i]) {

                // Than min equals num[i]
                min = num[i];
            }
        }
        System.out.println("Minimum value is : "+min); // Print Minimum Value in the Array
        System.out.println("***************************************************************************************");
    }
    // Created a Method called checkMaximum with int num[] as our Parameter
    static void checkMaximum(int num[]) {

        //Initializing that int max equals num with the starting value of 0
        int max = num[0];

        // Initializing i equals 10; if i is less than num.length; print in incremental order
        for (int i = 0; i < num.length; i++) {

            // If max is less than num[i] <-- i is a variableName
            if (max < num[i]) {

                // Than max equals num[i]
                max = num[i];
            }
        }
        System.out.println("Maximum value is : "+max);// Print Maximum Value in the Array

    }
    // Made a Method called getArray
    static int[] getArray(){

        return new int[]{88,66,70,90,23,12,405}; // Array Created inside The Method

    }

}
