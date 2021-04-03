package DataStructure.DataStructureAndAlgorithm;

// Two – dimensional Array (2D-Array)
// Two – dimensional array is the simplest form of a multidimensional array.
// A two – dimensional array can be seen as an array of one – dimensional array for easier understanding.
//
// Indirect Method of Declaration:
//
// Declaration – Syntax:
// data_type[][] array_name = new data_type[x][y];
//        For example: int[][] arr = new int[10][20];
//
// Initialization – Syntax:
// array_name[row_index][column_index] = value;
//        For example: arr[0][0] = 1;
//
// Direct Method of Declaration:
// Syntax:
//
// data_type[][] array_name = {{1,4},{2,6}};
//                  OR
// For Example: int[][] arr = {{1, 2}, {3, 4}};
//
// Accessing Elements of Two-Dimensional Arrays
// Elements in two-dimensional arrays are commonly referred by x[i][j] where ‘i’ is the row number and ‘j’ is the column number.
//
// Syntax:
// x[row_index][column_index]
//
// For example:
// int[][] arr = new int[10 rows][20 columns];
// arr[0][0] = 1;

public class Learn2DArray {
    // 2D Array:

    //2D Array/ Multidimensional Array: simple words as array of arrays

    // dataType[1st Dimension][2nd Dimension]  arrayName =new dataType[size1][size2]
    // dataType[1st Dimension][2nd Dimension]  arrayName =new dataType[numOfRow][numOColumn]

    //Created A 2D Array
    public static String [][] carInfo ={
            { "carBrand","carModel", "carColor","carPrice","carYear"},
            {  "Tesla",    "T23" ,     "Black",  "110000",  "2023"},
            {  "BMW" ,     "X8",       "Red",    "90000",   "2020" },
            {  "Audi" ,    "A5",       "Blue",   "80000",   "2021"}
    };

    public static void main(String[] args) {
        System.out.println("*********************************************************************************");
        System.out.println("Car Color : " + carInfo[2][2]); //Print the value inside [row #2][column #2]
        System.out.println("*********************************************************************************");



        // 1. Created a 2D Array
        // 2. Declare Array with Length
        String[][] stName = new String[6][4]; //We Are Implying That There Are 6 Rows And 4 Columns

        System.out.println("List of stName has total of : "+stName.length+" students"); //Prints Total Length of Array
        System.out.println("*********************************************************************************");

        //How To Add Value In A 2D Array: referenceName[row #][column #] = "add value";
        stName[0][0] = "id";
        stName[0][1] = "   firstName";
        stName[0][2] = "lastName";
        stName[0][3] = " Address";

        stName[1][0] = "101";
        stName[1][1] = "   James ";
        stName[1][2] = "  William";
        stName[1][3] = "  Manhattan,NY";


        stName[2][0] = "102";
        stName[2][1] = "   Jack ";
        stName[2][2] = "   Cohen ";
        stName[2][3] = "   Queens,NY";


        stName[3][0] = "103";
        stName[3][1] = "   Easha ";
        stName[3][2] = "  Khanam ";
        stName[3][3] = "  Sitka,Alaska";

        stName[4][0] = "104 ";
        stName[4][1] = "  Amar ";
        stName[4][2] = "   Alili ";
        stName[4][3] = "   Denver,CO";

        //Exception Handling
        try {
            stName[5][0] = "105 ";
            stName[5][1] = "  Parisha";
            stName[5][2] = " Khosravi";
            stName[5][3] = " Irvine,CA";

            //Exception Handling
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception"); //Exception Handling Print Out
        }

        System.out.println("Student name is : " + stName[4][1]); //Print stName in [row 4][column 1]
        System.out.println("*********************************************************************************");
        System.out.println("Student name is : " + stName[5][1]); //Print stName in [row 5][column 1]
        System.out.println("*********************************************************************************");


        // How to retrieve all the value from a 2D Array?
        // 1. Initialize a 2D Array
        // 2. Convert/Store Elements in a 1D Array

        // Retrieve Data from stName[2D Array] and Place it Inside String stn[1D Array]
        for (String stn[] : stName) {
            // Convert 2D Array to 1D Array
            for (String st : stn) {
                // Printing Elements in 1D Array
                System.out.print(st + "    ");
            }
            System.out.println();

        }
        System.out.println("********************************************************************************");
    }
    // Will add list l2 from 1 index
    // list1.addAll(1, list2);
    // System.out.println(list1.size());
}
