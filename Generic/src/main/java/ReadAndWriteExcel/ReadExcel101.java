package ReadAndWriteExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

// Now we will read the excel file by fetching the given excel file using FileInputStream.
// 1. Get the workbook using XSSFWorkbook
// 2. Fetch the required sheet as XSSFSheet object.
// 3. Repeatedly fetch the row with XSSFSheet.rowIterator()
// 3. Then Repeatedly fetch the corresponding cells with Row.cellIterator().

public class ReadExcel101 {

    public static void main(String[] args) throws IOException {

        //Similar to FileReader From ReadTextFile Class
        //FileReader Is Used To Read TextFiles and FileInputStream Is Used To Read Binary Data <- For Now Excel
        //FileInputStream(File file) : Creates an input file stream to read from the specified File object.
        FileInputStream fis = new FileInputStream(new File("DataTest/WriteExcel201.xlsx"));

        //This is the root class to handle XLSX. It reads excel file from a file input stream.
        //This is the first object most users will construct whether they are reading or writing a workbook.
        XSSFWorkbook workbook = new XSSFWorkbook (fis);
        //It is also the top level object for creating new sheets/etc.

        //An excel file can have more than one sheet. This class owns an excel sheet which is obtained by XSSFWorkbook
        XSSFSheet sheet = workbook.getSheetAt(0); //Fetch Data From Index 0

        //Returns: an iterator of the PHYSICAL rows.
        //Meaning the 3rd element may not be the third row if say for instance the second row is undefined.
        //Call getRowNum() on each row if you care which one it is.
        Iterator ite = sheet.rowIterator(); //Fetches rows with data in our worksheet

        //Returns true if the iteration has more elements.
        //In other words, returns true if next would return an element rather than throwing an exception.
        while(ite.hasNext()){ //Boolean Condition


            //Returns the next element in the iteration. <- Return the rest of the rows in the ExcelSheet
            Row row = (Row) ite.next();
            //classType reference = (row #) . ite is the iterator <- which returns the next row, than the row after
            //Until no more rows are left to fetch



            //Returns all cells including empty cells ( null values are returned for empty cells).
            Iterator<Cell> cite = row.cellIterator();
            //Iterating over each column



            //Returns true if the iteration has more elements
            while(cite.hasNext()){

                // Fetches The Next Cell, Than The Cell After Until no more Cells Are Left To Fetch
                Cell c = cite.next();

                //Returns a string representation of the object.
                //In general, the toString method returns a string that "textually represents" this object.
                //The result should be a concise but informative representation that is easy for a person to read.
                System.out.print(c.toString() +"  ");
                //Print all of the cells in a String format
            }
            System.out.println();
            //Print in the order that it was received
        }
        //Close fileInputStream
        fis.close();

    }
}
