public class CharacterJumble{
    public static void main(String[] args){
        String userInput = new String("This is Character Jumble");
        System.out.println("Original Text: " + userInput); 
        userInput = userInput.toLowerCase(); 

        String jumbledText = new String(userInput.replace('a', '&')); 
        jumbledText = jumbledText.replace('e', '%'); 
        jumbledText = jumbledText.replace('i', '^'); 
        jumbledText = jumbledText.replace('o', '*'); 
        jumbledText = jumbledText.replace('u', '@'); 
        jumbledText = jumbledText.replace('s', '$'); 
        jumbledText = jumbledText.replace('t', '!'); 

        System.out.println("Jumbled Text: " + jumbledText); 
    }
}