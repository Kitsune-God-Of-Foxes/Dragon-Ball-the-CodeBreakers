import java.nio.charset.StandardCharsets;

import java.nio.file.Files;

import java.nio.file.Path;



/**

 * Code Breakers — Iteration 3 starter.

 * Copy your six completed Iteration 2 method bodies into the matching methods.

 * Implement breakCode. Keep main unchanged.

 * Compile: javac CodeBreakers3.java

 * Run: java CodeBreakers3 ciphertext.txt

 */

public class CodeBreakers3 {

public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";



public static boolean isLetter(String ch) {

return false;

}



public static String shiftLetter(String ch, int shift) {

return ch;

}



public static String encrypt(String message, int shift) {

return message;

}



public static String decrypt(String message, int shift) {

return message;

}



public static String reverse(String text) {

return text;

}



public static String repeatingThreeKeyShift(String text, int key) {

return text;

}



 /** Returns the recovered plaintext. Precondition: ciphertext is not null. */

public static String breakCode(String ciphertext) {

 // TODO: Find the transformation chain and recover the message.

return ciphertext;

}



 /** Reads the named file and prints the value returned by breakCode. */

public static void main(String[] args) throws java.io.IOException {

if (args.length != 1) {

System.out.println("Usage: java CodeBreakers3 ciphertext.txt");

return;

}

String ciphertext = Files.readString(Path.of(args[0]), StandardCharsets.UTF_8);

System.out.println(breakCode(ciphertext));

}

}
