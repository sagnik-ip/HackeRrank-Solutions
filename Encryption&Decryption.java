import java.util.*;
import java.io.*;

public class Solution {

    /**
     * Decrypt the given encrypted message.
     *
     * @param encryptedMessage the encrypted message to be decrypted
     * @return the decrypted message
     */
    public static String decrypt(String encryptedMessage) {
        // Split the encrypted message into words
        String[] words = encryptedMessage.split(" ");

        // Initialize a StringBuilder to store the decrypted words
        StringBuilder decryptedMessage = new StringBuilder();

        // Iterate over each word in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Initialize a StringBuilder to store the decrypted word
            StringBuilder decryptedWord = new StringBuilder();

            // Initialize an index to track the current character in the word
            int j = 0;

            // Iterate over each character in the word
            while (j < words[i].length()) {
                // If the current character is followed by a digit, it's a compressed character
                if (j + 1 < words[i].length() && Character.isDigit(words[i].charAt(j + 1))) {
                    // Extract the character and its frequency
                    char character = words[i].charAt(j);
                    int frequency = Character.getNumericValue(words[i].charAt(j + 1));

                    // Append the character to the decrypted word with its frequency
                    for (int k = 0; k < frequency; k++) {
                        decryptedWord.append(character);
                    }

                    // Move to the next character in the word
                    j += 2;
                } else {
                    // If the current character is not followed by a digit, it's a single character
                    decryptedWord.append(words[i].charAt(j));

                    // Move to the next character in the word
                    j++;
                }
            }

            // Append the decrypted word to the decrypted message
            decryptedMessage.append(decryptedWord);

            // If it's not the last word, append a space
            if (i > 0) {
                decryptedMessage.append(" ");
            }
        }

        // Return the decrypted message
        return decryptedMessage.toString();
    }

    public static void main(String[] args) throws IOException {
        // Create a Scanner to read dynamic input
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage);

        // Print the decrypted message
        System.out.println(decryptedMessage);

        // Close the Scanner
        scanner.close();
    }
}
