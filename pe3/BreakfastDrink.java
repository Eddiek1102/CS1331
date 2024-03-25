import java.util.Scanner; 

public class BreakfastDrink{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Beverage name: "); 
        String userBeverage = scanner.nextLine(); 
        System.out.print("Customer budget: "); 
        int budget = scanner.nextInt(); 
        
        switch (userBeverage){
            case "Coffee": 
                if (budget < 4){
                    System.out.println("Customer cannot afford a " + userBeverage); 
                }
                else { 
                    System.out.println("Customer can afford " + (budget / 4) + " " + userBeverage + "(s)");
                }
                break; 
            case "Tea": 
                if (budget < 3){
                    System.out.println("Customer cannot afford a " + userBeverage); 
                }
                else { 
                    System.out.println("Customer can afford " + (budget / 3) + " " + userBeverage + "(s)"); 
                }
                break; 
            case "OJ": 
            case "Orange Juice": 
                if (budget < 2){
                    System.out.println("Customer cannot afford a " + userBeverage); 
                }
                else { 
                    System.out.println("Customer can afford " + (budget / 2) + " " + userBeverage + "(s)"); 
                }
                break; 
            case "Milk": 
                if (budget < 1){
                    System.out.println("Customer cannot afford a " + userBeverage); 
                }
                else { 
                    System.out.println("Customer can afford " + (budget / 1) + " " + userBeverage + "(s)"); 
                }
                break; 
        }
        scanner.close(); 
    }
}