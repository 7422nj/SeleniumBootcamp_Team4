package ReadTextFile;

import java.io.FileReader;

// Java FileReader class is used to read data from the file.
// It returns data in byte format like FileInputStream class.
// It is character-oriented class which is used for file handling in java.

public class FileReader101 {

        public static void main(String args[])throws Exception{ // Main Method Throws Exception

            // Created an Object of FileReader Class
            // In The Constructor We Want Enter Our TextFile Path From Content Root
            FileReader fr=new FileReader("C:\\Users\\prita\\IdeaProjects\\Java_CoffeeBeans101\\src\\ReaderUtilities\\ReadFiles\\testBufferedReader.txt");

            // Created a Empty Variable [int] <-- No Value/Empty
            int i;

            // If i is able to identify the textFile using FileReader, than Read textFile
            while((i=fr.read())!= -1)// Overrides: (read) in Reader Class
                // read() returns the character read, or else it returns -1 if no character has been read.

                // Print the Characters in the textFile after Reading
                System.out.print((char)i);

            // It is used to close the FileReader class.
            fr.close();
        }
    }

