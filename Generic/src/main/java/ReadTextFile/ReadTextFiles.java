package ReadTextFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFiles {

    // 1. Created a Static String variable systemPath
    // 2. We Want the System to Get the Property Indicated by the Specified Key
    // 3. getProperty() Gets the system property indicated by the specified key <-- key = "user.dir"
    static String systemPath = System.getProperty("user.dir");

    // Created a Static String variable Named relativePath
    // Entered The Path From Content Root as Value in our Static String relativePath
    static String relativePath = "src/ReaderUtilities/ReadFiles/testBufferedReader.txt";  ///src/readerUtilities/Test.txt

    // We Want To Combine systemPath's Specified Key + relativePath's Path From Content Root
    static String path = systemPath + relativePath;

    // static classType reference
    static FileReader fileReader;

    // static classType reference
    static BufferedReader bufferedReader;


    // Main Method
    public static void main(String[] args) throws Exception {

        // Calling the ReadTextFiles Class
        // Inside Our ReadTextFiles Class We Want To Call The Method readFile
        // Read textFile & Print Value in String data <- Empty/No Value
        ReadTextFiles.readFile();
    }

    // Created A Static Method
    public static void readFile() {

        String data =""; // String variable without a value/empty

        // Try this
        try {
            // Created an Object of FileReader Class
            // In The Constructor We Want Enter Our TextFile Path From Content Root
            fileReader = new FileReader(path);

            // Created an Object of BufferedReader Class
            // In The Constructor We Entered fr Which is The Reference of FileReader class object
            // BufferedReader will read the textFile line by line <-- allows performance to become faster
            bufferedReader = new BufferedReader(fileReader);

        // Catch this
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Exception Handling

        // Try this
        try {
            // If String data is able to read the data line by line
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data); // Than print String data
            }
            // Catch Exception
        } catch (IOException e) {
            e.printStackTrace();

            // Finally try this
        } finally {
            try{

                // Close fileReader
                fileReader.close();
                // Close bufferedReader
                bufferedReader.close();

                // Catch Exception
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
