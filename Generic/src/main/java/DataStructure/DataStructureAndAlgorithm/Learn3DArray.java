package DataStructure.DataStructureAndAlgorithm;

// Three – dimensional Array (3D-Array)
// Three – dimensional array is a complex form of a multidimensional array. A three – dimensional array can be seen as an array of two – dimensional array for easier understanding.
//
// Indirect Method of Declaration:
//
// Declaration – Syntax:
// data_type[][][] array_name = new data_type[x][y][z];
//        For example: int[][][] arr = new int[10][20][30];
//
// Initialization – Syntax:
// array_name[array_index][row_index][column_index] = value;
//        For example: arr[0][0][0] = 1;
//
// Direct Method of Declaration:
//
//Syntax:
// data_type[][][] array_name = { {{3,4},{2,3}},{3,4}},{2,5}},{32,32}} };
//
//              OR
// For example: int[][][] arr = { {{1, 2}, {3, 4}}, {{5, 6}, {7, 8}} };
//
// Accessing Elements of Three-Dimensional Arrays
// Elements in three-dimensional arrays are commonly referred by x[i][j][k]
// 1. ‘i’ is the Array Number
// 2. ‘j’ is the Row Number
// 3. ‘k’ is the Column Number
//
//Syntax:
//
//x[array_index][row_index][column_index]
//For example:
//
//int[][][] arr = new int[10][20][30];
//arr[0][0][0] = 1;

public class Learn3DArray {

    // 3D Array = 1D Array + 2D Array
    // DataType [Size][Row][Column] arrayName = new DataType [Size][Row][Column];

    // Declare 3D Array
    // DataType [Size][Row][Column] arrayName = new DataType [Size][Row][Column];
    static String  pizza [][][] = new String[2][6][5];

    // Declare 3D Array
    // DataType [Size][Row][Column] arrayName = new DataType [Size][Row][Column];
    static String [][][]  pizza1  = new String[2][6][5];

    public static void main(String[] args) { // Main Method

        // Assign Value to Row 0
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[0][0][0] = "Sl";
        Learn3DArray.pizza[0][0][1] = "Pizza Type";
        Learn3DArray.pizza[0][0][2] = "Price";
        Learn3DArray.pizza[0][0][3] = "Quantity";
        Learn3DArray.pizza[0][0][4] = "Amount";

        // Assign Value to Row 1
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[0][1][0] = "101";
        Learn3DArray.pizza[0][1][1] = "Pepperoni";
        Learn3DArray.pizza[0][1][2] = "35";
        Learn3DArray.pizza[0][1][3] = "5";
        Learn3DArray.pizza[0][1][4] = "165";

        // Assign Value to Row 2
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[0][2][0] = "102";
        Learn3DArray.pizza[0][2][1] = "Neapolitan pizza";
        Learn3DArray.pizza[0][2][2] = "45";
        Learn3DArray.pizza[0][2][3] = "2";
        Learn3DArray.pizza[0][2][4] = "90";

        // Assign Value to Row 3
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[0][3][0] = "103";
        Learn3DArray.pizza[0][3][1] = "Meat Lover Pizza";
        Learn3DArray.pizza[0][3][2] = "55";
        Learn3DArray.pizza[0][3][3] = "3";
        Learn3DArray.pizza[0][3][4] = "165";

        // Assign Value to Row 4
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[0][4][0] = "104";
        Learn3DArray.pizza[0][4][1] = "Covered Pizza";
        Learn3DArray.pizza[0][4][2] = "65";
        Learn3DArray.pizza[0][4][3] = "5";
        Learn3DArray.pizza[0][4][4] = "325";


        // Assign Value to Row 5
        // How To Assign Value To A 3D Array: className.arrayName[size][row][column] = "add value";
        Learn3DArray.pizza[1][5][0] = "107";
        Learn3DArray.pizza[1][5][1] = "Cheese Pizza";
        Learn3DArray.pizza[1][5][2] = "15";
        Learn3DArray.pizza[1][5][3] = "10";
        Learn3DArray.pizza[1][5][4] = "150";

        System.out.println("************************************************************************************");
        System.out.println("Pizza Type  : " + Learn3DArray.pizza[0][4][1]); // Print Array Value In [size 0][row 4][column 1]
        System.out.println("************************************************************************************");

        // How to Retrieve All The Value from a 3D Array?
        // 1. Initialize a 3D Array
        // 2. Convert/Store Elements from 3D Array into a 2D Array
        // 3. Convert/Store Elements from 2D Array into a 1D Array

        // Retrieve Data from pizza[3D Array] and Store it Inside String pizz[2D Array]
        for (String pizz[][] : pizza) {
            // Convert 3D to 2D
            for (String piz[] : pizz) {
                // Convert 2D to 1D
                for (String pi : piz) {
                    // Get value from 1D
                    System.out.print(pi + "         ");
                }
                System.out.println();

            }

        }
        System.out.println("************************************************************************************");
    }





}
