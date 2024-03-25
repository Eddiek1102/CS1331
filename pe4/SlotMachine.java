import java.util.Scanner; 
import java.util.Random; 

public class SlotMachine{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random(); 

        System.out.println("Welcome to Slot Machine!"); 
        System.out.println(); 
        
        GameMode gamemode = GameMode.EASY;
        int overallScore = 0; 

        while (true){
            int firstRandom = 0, secondRandom = 0, thirdRandom = 0;  

            switch(gamemode){
                case EASY: 
                    firstRandom = random.nextInt(5) + 1; 
                    secondRandom = random.nextInt(5) + 1; 
                    thirdRandom = random.nextInt(5) + 1; 
                    break; 
                case NORMAL: 
                    firstRandom = random.nextInt(7) + 1; 
                    secondRandom = random.nextInt(7) + 1; 
                    thirdRandom = random.nextInt(7) + 1; 
                    break; 
                case HARD: 
                    firstRandom = random.nextInt(10) + 1; 
                    secondRandom = random.nextInt(10) + 1; 
                    thirdRandom = random.nextInt(10) + 1; 
                    break; 
                default: 
                    break; 
            }
            
            System.out.println("Your roll: " + firstRandom + ", " + secondRandom + ", " + thirdRandom); 

            if ((firstRandom == secondRandom) && (secondRandom == thirdRandom)){
                overallScore += (firstRandom + secondRandom + thirdRandom); 
                System.out.println("Overall: " + overallScore + ", Immediate: " + (firstRandom + secondRandom + thirdRandom)); 
            }
            else if ((firstRandom == secondRandom) && (secondRandom != thirdRandom)){
                overallScore += 2; 
                System.out.println("Overall: " + overallScore + ", Immediate: 2");
            }
            else if ((firstRandom != secondRandom) && (secondRandom == thirdRandom)){
                overallScore += 2; 
                System.out.println("Overall: " + overallScore + ", Immediate: 2"); 
            }
            else{
                System.out.println("Overall: " + overallScore + ", Immediate: 0"); 
            }

            System.out.print("Keep playing (y/n): "); 
            String keepPlaying = scanner.nextLine(); 
            if (keepPlaying.equals("n")){
                break; 
            }
            System.out.println(); 
        }
        scanner.close(); 
    }
}