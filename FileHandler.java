import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates basic file handling in Java:
 * 1. Creates a file named 'sample.txt'.
 * 2. Writes a predetermined string to the file.
 * 3. Reads the content from the file.
 * 4. Prints the content to the console.
 */
public class FileHandler {

    private static final String FILENAME = "sample.txt";
    private static final String CONTENT_TO_WRITE = 
        "This is the content written to sample.txt.\n" + 
        "Java File Handling is demonstrated here in a secure way.";

    public static void main(String[] args) {
        
        // --- Step 1 & 2: Write Content to the File ---
        try (FileWriter writer = new FileWriter(FILENAME)) {
            // FileWriter will automatically create the file if it doesn't exist,
            // or overwrite it if it does.
            writer.write(CONTENT_TO_WRITE);
            System.out.println("✅ Successfully wrote content to " + FILENAME);
        } catch (IOException e) {
            System.err.println("❌ An error occurred while writing to the file: " + e.getMessage());
            // Exit if writing failed, as reading won't be possible/meaningful.
            return; 
        }

        System.out.println("\n--- Content Read from " + FILENAME + " ---");

        // --- Step 3 & 4: Read Content from the File ---
        try {
            File file = new File(FILENAME);
            // Use Scanner to read the file line by line
            try (Scanner fileReader = new Scanner(file)) {
                // Check if the file exists before attempting to read
                if (!file.exists()) {
                    System.err.println("❌ Error: File not found (" + FILENAME + ").");
                    return;
                }
                
                // Print the content header
                
                // Loop through the file line by line and print it
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    System.out.println(line);
                }
            }
            System.out.println("------------------------------------");
            System.out.println("✅ File reading complete.");
            
        } catch (IOException e) {
            // This catch block handles potential errors during file reading/opening
            System.err.println("❌ An error occurred while reading the file: " + e.getMessage());
        }
    }
}