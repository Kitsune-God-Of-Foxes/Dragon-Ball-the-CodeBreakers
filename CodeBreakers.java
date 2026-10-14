import java.util.Scanner;

/** Code Breakers — Iteration 1 Caesar cipher starter. */
public class CodeBreakers {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Determines whether ch is exactly one capital letter A-Z.
     * Precondition: ch is not null. It may be empty or have any length.
     * @param ch the string to check
     * @return true if ch contains exactly one capital A-Z letter; false otherwise
     */
    public static boolean isLetter(String ch) {

        return false;
    }

    /**
     * Applies a Caesar shift to one character, wrapping within A-Z.
     * Positive shifts move forward; negative shifts move backward.
     * Precondition: ch is not null and has length 1. shift may be any int,
     * including Integer.MIN_VALUE and Integer.MAX_VALUE.
     * @param ch the single character to shift
     * @param shift the signed number of alphabet positions to move
     * @return the shifted capital letter, or ch unchanged if it is not A-Z
     */
    public static String shiftLetter(String ch, int shift) {

        return ch;
    }

    /**
     * Applies the same signed Caesar shift to every capital letter in message.
     * Use shiftLetter for each character. Preserve lowercase letters, digits,
     * spaces and punctuation in their original positions.
     * Precondition: message is not null; an empty string is valid.
     * shift may be any int, including Integer.MIN_VALUE and Integer.MAX_VALUE.
     * @param message the text to transform
     * @param shift the signed number of alphabet positions to move
     * @return the transformed string, with the same length as message;
     *         an empty message returns an empty string
     */
    public static String encrypt(String message, int shift) {

        return message;
    }

    /**
     * Undoes encryption by reusing encrypt with the opposite normalized shift.
     * Precondition: message is not null; an empty string is valid.
     * shift is the ORIGINAL signed encryption shift, not its opposite.
     * It may be any int, including Integer.MIN_VALUE and Integer.MAX_VALUE.
     * @param message the ciphertext to decrypt
     * @param shift the signed shift originally used to encrypt the message
     * @return the string with that shift undone, preserving nonletters and length;
     *         decrypt(encrypt(text, shift), shift) returns the original text
     */
    public static String decrypt(String message, int shift) {

        return message;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Code Breakers — Iteration 1");
        System.out.println("Caesar shifts change capital A–Z only. Other characters stay unchanged.");
        String text = null;
        while (true) {
            if (text == null) {
                System.out.print("Message (or file:filename): ");
                if (!input.hasNextLine()) break;
                String source = input.nextLine();
                if (source.startsWith("file:")) {
                    try {
                        text = new String(java.nio.file.Files.readAllBytes(
                            java.nio.file.Paths.get(source.substring(5).trim())),
                            java.nio.charset.StandardCharsets.UTF_8);
                    } catch (java.io.IOException | IllegalArgumentException ex) {
                        System.out.println("Cannot read that file. Check its name and run from the launch folder.");
                        continue;
                    }
                } else text = source;
                System.out.println("Current text: " + text);
            }
            System.out.print("Transformation (C:3 for Caesar shift 3; new, tests, quit): ");
            if (!input.hasNextLine()) break;
            String operation = input.nextLine().trim();
            if (operation.equalsIgnoreCase("quit")) break;
            if (operation.equalsIgnoreCase("new")) { text = null; continue; }
            if (operation.equalsIgnoreCase("tests")) { runChecks(); continue; }
            if (!operation.toUpperCase(java.util.Locale.ROOT).startsWith("C:")) {
                System.out.println("Enter one Caesar transformation, such as C:3, or new, tests, quit.");
                continue;
            }
            int shift;
            try { shift = Integer.parseInt(operation.substring(2).trim()); }
            catch (NumberFormatException ex) {
                System.out.println("Enter a whole-number shift within the int range after C:.");
                continue;
            }
            text = encrypt(text, shift);
            System.out.println("Result: " + text);
        }
        System.out.println("Goodbye.");
    }

    public static void runChecks() {
        check("letter A", "true", "" + isLetter("A"));
        check("letter Z", "true", "" + isLetter("Z"));
        check("lowercase", "false", "" + isLetter("a"));
        check("two letters", "false", "" + isLetter("AB"));
        check("empty letter", "false", "" + isLetter(""));
        check("digit", "false", "" + isLetter("7"));
        check("forward wrap", "A", shiftLetter("Z", 1));
        check("backward wrap", "Z", shiftLetter("A", -1));
        check("large positive shift", "B", shiftLetter("A", 53));
        check("large negative shift", "Z", shiftLetter("D", -30));
        check("punctuation", "!", shiftLetter("!", 4));
        check("space", " ", shiftLetter(" ", -3));
        check("zero shift", "A", shiftLetter("A", 0));
        check("full cycle", "Z", shiftLetter("Z", 26));
        check("encrypt example", "BA!", encrypt("AZ!", 1));
        check("mixed characters", "BCD xyz 7!", encrypt("ABC xyz 7!", 1));
        check("empty message", "", encrypt("", 5));
        check("decrypt example", "AZ!", decrypt("BA!", 1));
        check("decrypt negative shift", "GO, TEAM!", decrypt("FN, SDZL!", -1));
        check("round trip", "THE MESSAGE, 7!", decrypt(encrypt("THE MESSAGE, 7!", 19), 19));
        check("maximum int shift", "X", shiftLetter("A", Integer.MAX_VALUE));
        check("minimum int shift", "C", shiftLetter("A", Integer.MIN_VALUE));
        check("minimum int decryption", "A", decrypt("C", Integer.MIN_VALUE));
    }

    public static void check(String label, String expected, String actual) {
        System.out.println((expected.equals(actual) ? "PASS " : "FAIL ") + label
            + ": expected [" + expected + "]; actual [" + actual + "]");
    }
}
