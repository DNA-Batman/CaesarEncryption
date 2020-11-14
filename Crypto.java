import java.util.Scanner;
public class Crypto {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
       System.out.println("Enter the text you want to be encrypted"); // The text to be sent to normalizetext for beginning of encryption
       String Text = input.nextLine();
       System.out.println("Enter the amount of shifts you want "); // The number to be sent to caesarify to give the number of shifts to occur per alphabet
       int shift = input.nextInt();
       System.out.println("Enter the number of letter you want per group"); // The number to be sent to groupify to group the number of leeters as one word as part of the encryption
       int gpWord = input.nextInt();
       String Encrypted =EncryptString(Text, shift, gpWord);
       System.out.println("The encrypted text is "+ Encrypted) ;
    }
    public static String EncryptString( String InputText, int sText, int gText ){    // the place for all the calls and stuff
        String normText = normalizeText(InputText);                                 // to normalize the text we got from the user
        String caesarText = caesarify(normText, sText);                            // to call and obtain the casarified text
        String groupifiedText = groupify(caesarText,gText);                       // to call and obtain the groupified text
        return groupifiedText;

    }
    public static String normalizeText(String userInput) {

        userInput = userInput.replaceAll("[^a-zA-Z]", ""); // This removes everything which isn't an alphabet (lowercase and uppercase included)
        userInput = userInput.toUpperCase();
        return userInput;

    }
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String nText, int shiftNum ){
        String caesarifiedText= "";
        String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";                       // This is for having all the alphabets in their original positions
        String shiftedAlphabets =shiftAlphabet(shiftNum);                     // This is all the alphabets after being shifted from their original position
        char originalChar;                                                   // This is to store the original character from the text
        char shiftedChar ;                                                  // This is to update the original character to the shifted  character
        int indexOfLetter;                                                 // This is to store the number of the letter needed to be shifted
        for(int i=0 ; i < nText.length() ; i++){
            originalChar = nText.charAt(i);                              // This now stores the i'th alphabet of the text
            indexOfLetter = Alphabets.indexOf(originalChar);            //  THis now finds the positions of that letter in the original alphabets
            if(indexOfLetter > -1) {                                   // To make sure the word ends
                shiftedChar = shiftedAlphabets.charAt(indexOfLetter); // Uses the already shifted alphabets, points and stores the alphabet at the index position
                caesarifiedText= caesarifiedText + shiftedChar;      // Updates the original text
            }

        }

        return caesarifiedText;
    }
    public static String groupify(String cText, int gpNum){
        String groupifiedText ="";
        while( cText.length() % gpNum != 0 ){
            cText += "x";

        }
        int length = cText.length();
        for (int i = 0 ; i < length ; i += gpNum ) {
            groupifiedText += cText.substring(i, i + gpNum) + " ";

        }
        return groupifiedText;
    }

}
