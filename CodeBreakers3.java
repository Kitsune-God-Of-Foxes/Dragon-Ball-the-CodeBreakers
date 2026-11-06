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
boolean I = ALPHABET.contains(ch) && ch.length() == 1;
    return I;

}



public static String shiftLetter(String ch, int shift) {
if (isLetter(ch))
        {
        int value = ALPHABET.indexOf(ch);
        value = value + shift;
        while (value < 0)
        {
        value += 26;
        }
        value = value % 26;
        if (value != 25)
        {
        ch = ALPHABET.substring(value, value+1);
        return ch;
        }
        else
        {
        ch = ALPHABET.substring(value);
        return ch;
        }
        }
        else
        {
        return ch;
        }

}



public static String encrypt(String message, int shift) {

int i = 0;
        String newMessage = "";
        while (i < message.length())
        {
            String letter = message.substring(i,i + 1);
            if (isLetter(letter));
           {
                letter = shiftLetter(letter, shift);
            
            }
            newMessage += letter;
           i += 1;
        }
        return newMessage;

}



public static String decrypt(String message, int shift) {

int i = 0;
        int c = 0;
        String newMessage = "";
        String letter = "";
        shift = 26 * (1 + Math.abs(shift) % 26) - shift;
        while (i < message.length())
       {
        
            
            letter = message.substring(c, c+1);
            if (isLetter(letter));
            {
                letter = shiftLetter(letter, shift);
            
            }
            newMessage += letter;
            i += 1;
            c += 1;
        
        
        }
        return newMessage;

}



public static String reverse(String text) {
String newText = "";
        String letter = "";
        for (int i = text.length(); i >= 0; i--) {
            if (i + 1 < text.length()) {
                letter = text.substring(i, i + 1);
            } else {
                letter = text.substring(i);
            }
            newText += letter;
        }
        return newText;

}



public static String repeatingThreeKeyShift(String text, int key) {

if (key < -999 || key > 999) {

            throw new IllegalArgumentException("K: key must be -999 through 999.");

        }
        String letter = "";
        int key1 = key / 100;
        int key2 = (key % 100) / 10;
        int key3 = key % 10;
        int count = 1;
        if (key < 0) {
            key1 = 26 + key1;
            key2 = 26 + key2;
            key3 = 26 + key3;
        }
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length()) {
                letter = text.substring(i, i + 1);
            } else {
                letter = text.substring(i);
            }
            if (isLetter(letter))
                {
                if (count == 1) {
                    letter = encrypt(letter, key1);
                    count = 2;
                    
                }
                else if (count == 2) {
                    letter = encrypt(letter, key2);
                    count = 3;
                    
                }
                else if (count == 3) {
                    letter = encrypt(letter, key3);
                    count = 1;
                    
                }
                
                
            }
            newText += letter;
        }
        return newText;

}


public static float test(String ciphertext)
{
    float score = 0.0;
    String letter = "";
    int occurences = 0;
    String currenLetter = "";
    String Landmarks = ETAOIZQJXK;
    int a = 1;
    for (int i = 0; i <10; i++){
        if (i + 1 != 10){
        Letter = landmarks.substring(i, i + 1)
        }
        else
        {Letter = landmarks.substring(i, i + 1)}
        while (a < length(ciphertext)){
            
            currentLetter = ciphertext.substring(a-1, 1);
            if (currentLetter = letter){
                occurences += 1;
            }
            a += 1;
        }
       if (letter = A){
            
            if (((occurences / length(ciphertext))) > (0.05) && (occurences / length(ciphertext)) < 0.1)
            {
            score += 0.1;
            }
        }
        if (letter = E){
            
            if (((occurences / length(ciphertext))) > (0.08) && (occurences / length(ciphertext)) < 0.15)
            {
            score += 0.1;
            }
        }
        if (letter = T){
            
            if (((occurences / length(ciphertext))) > (0.06) && (occurences / length(ciphertext)) < 0.11)
            {
            score += 0.1;
            }
        }
        if (letter = O){
            
            if (((occurences / length(ciphertext))) > (0.045) && (occurences / length(ciphertext)) < 0.09)
            {
            score += 0.1;
            }
        }
        if (letter = N){
            
            if (((occurences / length(ciphertext))) > (0.04) && (occurences / length(ciphertext)) < 0.085)
            {
            score += 0.1;
            }
        }
        if (letter = Z){
            
            if (((occurences / length(ciphertext))) > (0) && (occurences / length(ciphertext)) < 0.001)
            {
            score += 0.1;
            }
        }
        if (letter = Q){
            
            if (((occurences / length(ciphertext))) > (0.0005) && (occurences / length(ciphertext)) < 0.002)
            {
            score += 0.1;
            }
        }
        if (letter = J){
            
            if (((occurences / length(ciphertext))) > (0.001) && (occurences / length(ciphertext)) < 0.003)
            {
            score += 0.1;
            }
        }
        if (letter = X){
            
            if (((occurences / length(ciphertext))) > (0.0015) && (occurences / length(ciphertext)) < 0.0035)
            {
            score += 0.1;
            }
        }
        if (letter = K){
            
            if (((occurences / length(ciphertext))) > (0.005) && (occurences / length(ciphertext)) < 0.01)
            {
            score += 0.1;
            }
        }
        
        
     
      
            
   

    
        
    return score;
}
}
 /** Returns the recovered plaintext. Precondition: ciphertext is not null. */

public static String breakCode(String ciphertext) {
int K = -999;
int C = -26;
float score = 0.0;
String PlainText = "";
String decrypting = "";
while (C <= 26)
{
    while (K <= 999)
    {
        decypting = ciphertext;
        decrypting = encrypt(decrypting, C);
        decrypting = reverse(decrypting);
        decrypting = repeatingThreeKeyShift(decrypting, K);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);
        }
        decypting = ciphertext;
        decrypting = encrypt(decrypting, C);
        decrypting = repeatingThreeKeyShift(decrypting, K);
        decrypting = reverse(decrypting);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);
        }
        decypting = ciphertext;
        decrypting = reverse(decrypting);
        decrypting = encrypt(decrypting, C);
        decrypting = repeatingThreeKeyShift(decrypting, K);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);
        }
        decypting = ciphertext;
        decrypting = reverse(decrypting);
        decrypting = repeatingThreeKeyShift(decrypting, K);
        decrypting = encrypt(decrypting, C);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);
        }
        decypting = ciphertext;
        decrypting = repeatingThreeKeyShift(decrypting, K);
        decrypting = encrypt(decrypting, C);
        decrypting = reverse(decrypting);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);
        }
        decypting = ciphertext;
        decrypting = repeatingThreeKeyShift(decrypting, K);
        decrypting = reverse(decrypting);
        decrypting = encrypt(decrypting, C);
        if (test(decrypting) > score){
            PlainText = decrypting;
            score = test(decrypting);

        }
        K+= 1;
    }
    C += 1;
    K = -999;
}

return PlainText;

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
