public class ToUpperCase{
    public static void main(String[] args){
        char letter = 'a'; 
        System.out.println("Before: " + letter); 
        System.out.println("After: " + (char)(letter -= 32)); 
    }
}