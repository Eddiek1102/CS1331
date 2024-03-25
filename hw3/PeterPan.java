import java.util.Scanner;
/** Driver program for Peter Pan translation program.
 * @author Eddie kwak
 * @version 1.0
 */
public class PeterPan {
    /** Main method used to drive the program.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Hardcoded Translations:");
        System.out.println("--------------------------------------------------");
        String elmerFuddOriginal = "Be very, very quiet.";
        Message elmerFuddMessage1 = new Message(Dialect.ELMER_FUDD, elmerFuddOriginal);
        String elmerTranslated = elmerFuddMessage1.translate();
        System.out.println("Originai:   " + elmerFuddOriginal);
        System.out.println("Translated: " + elmerTranslated);
        System.out.println();
        //System.out.println(Message.translationTallyString() + "\n")

        //Hardcoded Pirate translation
        String pirateOriginal = "Teaching yourself Java is fun.";
        Message pirateMessage1 = new Message(Dialect.PIRATE, pirateOriginal);
        String pirateTranslated = pirateMessage1.translate();
        System.out.println("Original:   " + pirateOriginal);
        System.out.println("Translated: " + pirateTranslated);
        System.out.println();
        //System.out.println(Message.translationTallyString() + "\n");

        //Hardcoded Computer translation
        String computerOriginal = "Hello World!";
        Message computerMessage1 = new Message(Dialect.COMPUTER, computerOriginal);
        String computerTranslated = computerMessage1.translate();
        System.out.println("Original:   " + computerOriginal);
        System.out.println("Translated: " + computerTranslated);
        System.out.println("--------------------------------------------------");
        //System.out.println(Message.translationTallyString());
        //1001000 1100101 1101100 1101100 1101111 1010111 1101111 1110010 1101100 1100100 100001

        //Prompting User Interaction
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Message: ");
            String userOriginal = scanner.nextLine();
            System.out.println("Enter Dialect (e = Elmer Fudd, p = Pirate, c = Computer): ");
            String userInputDialect = scanner.nextLine();

            System.out.println("Original:   " + userOriginal);

            Dialect userDialect;
            Message userMessage;
            String userTranslated;

            switch (userInputDialect) {
            case "p":
                userDialect = Dialect.PIRATE;
                userMessage = new Message(userDialect, userOriginal);
                userTranslated = userMessage.translate();
                System.out.println("Translated: " + userTranslated);
                break;

            case "e":
                userDialect = Dialect.ELMER_FUDD;
                userMessage = new Message(userDialect, userOriginal);
                userTranslated = userMessage.translate();
                System.out.println("Translated: " + userTranslated);
                break;

            case "c":
                userDialect = Dialect.COMPUTER;
                userMessage = new Message(userDialect, userOriginal);
                userTranslated = userMessage.translate();
                System.out.println("Translated: " + userTranslated);
                break;

            default:
                System.out.println("Enter a valid dialect (e/p/c)");
                break;
            }

            System.out.println("Continue? (y/n): ");
            String checkContinue = scanner.nextLine();
            if (checkContinue.equals("n")) {
                break;
            }
        }
        System.out.print("Translation Tally: ");
        System.out.println(Message.translationTallyString());

        scanner.close();
    }
}