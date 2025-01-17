// Create PalindromeChecker class to check if the string is a palindrome or not and display the result
public class PalindromeChecker {
    // Attribute for the text
    private String text;
    // Constructor to initialize the text
    public PalindromeChecker(String text) {
        this.text = text;
    }
    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        // Convert the text to lowercase for uniformity
        String processedText = text.toLowerCase();
        // Reverse the string 
        String reversedText = "";
        for (int i = processedText.length() - 1; i >= 0; i--) {
            reversedText += processedText.charAt(i);
        }
        // Compare the processed text with its reverse
        return processedText.equals(reversedText);
    }
    // Method to display the result
    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("The text is a palindrome.");
        } else {
            System.out.println("The text is not a palindrome.");
        }
    }
    public static void main(String[] args) {
        // Create a PalindromeChecker object
        PalindromeChecker checker1 = new PalindromeChecker("Level");
        PalindromeChecker checker2 = new PalindromeChecker("Hey");
        // Display the result
        checker1.displayResult();
        checker2.displayResult();
    }
}
