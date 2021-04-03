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
//
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

public class Learn1DArray {
    public static void main (String[] args)
    {
        // Declare an Array of Integers
        int[] age;

        // Allocating Memory for 5 Integers
        age = new int[5]; // <- Designate The Memory Size According To What You Want/Need in The Array

        // Initialize the First Elements of the Array
        age[0] = 10;

        // Initialize the Second Element of the Array
        age[1] = 20;

        // Initialize the Third Element of the Array
        age[2] = 30;

        // Initialize the Fourth Element of the Array
        age[3] = 40;

        // Initialize the Fifth Element of the Array
        age[4] = 50;

        // Accessing The Elements of the Specified Array
        //Start At Index #0; If i is less than age;print;
        for (int i = 0; i < age.length; i++)
            System.out.println("Element at index : "+ age[i]); // Print's Each Element of the Array 1 by 1

        //Element at index 0 : 10
        //Element at index 1 : 20
        //Element at index 2 : 30
        //Element at index 3 : 40
        //Element at index 4 : 50
    }
}
