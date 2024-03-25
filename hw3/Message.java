/**
 * Class used to translate sentences to different dialects.
 * @author Eddie kwak
 * @version 1.0
 */
public class Message {
    /** The object's dialect. */
    private Dialect dialect;
    /** The object's original message. */
    private String originalMessage;
    /** The object's translated message.  */
    private String translatedMessage;
    /** Boolean value checking if the message has already been translated. */
    private boolean hasBeenTranslated;

    /** Number of times the Elmer Fudd dialect was used for translation. */
    private static int elmerFuddCount = 0;
    /** Number of times the Pirate dialect was used for translation. */
    private static int pirateCount = 0;
    /** Number of times the Computer dialect was used for translation. */
    private static int computerCount = 0;

    /** Constructor used to create a new message.
     * @param cDialect The dialect used for translation.
     * @param cOriginalMessage The message being translated.
     */
    public Message(Dialect cDialect, String cOriginalMessage) {
        dialect = cDialect;
        originalMessage = cOriginalMessage;
        translatedMessage = "";
        hasBeenTranslated = false;
    }

    /** Medthod used to prompt translations.
     * @return Returns the translated message.
     */
    public String translate() {
        String t = "";
        if (this.hasBeenTranslated) {
            return this.translatedMessage;
        } else {
            if (this.dialect == Dialect.ELMER_FUDD) {
                t = this.elmerFuddTranslation();
            } else if (this.dialect == Dialect.PIRATE) {
                t = this.pirateTranslation();
            } else if (this.dialect == Dialect.COMPUTER) {
                t = this.computerTranslation();
            }
        }
        while (t.contains("  ")) {
            t = t.replaceAll("  ", " ");
        }
        this.hasBeenTranslated = true;
        this.translatedMessage = t;
        return t;
    }

    /** Method used for preparing and returning elmer fudd translations.
     * @param original The message being translated.
     * @return Returns translated message.
     */
    private String elmerFuddTranslation() {
        String original = this.originalMessage;
        String[] words = original.split(" ");
        String t = "";
        for (int i = 0; i < words.length; i++) {
            t += elmerFuddTranslator(words[i]) + " ";
        }
        elmerFuddCount++;
        return t.trim();
    }

    /** Method used to translate each word for elmer fudd translations.
     * @param word The word being translated.
     * @return Returns translated word.
    */
    private String elmerFuddTranslator(String word) {
        String t = word;
        if (t.contains("ith")) {
            t = t.replaceAll("ith", "if");
        }
        if (t.contains("Ith")) {
            t = t.replaceAll("Ith", "If");
        }
        if (t.contains("th")) {
            t = t.replaceAll("th", "d");
        }
        if (t.contains("Th")) {
            t = t.replaceAll("Th", "D");
        }
        if (t.contains("l") || word.contains("L") || word.contains("r") || word.contains("R")) {
            t = t.replaceAll("l", "w");
            t = t.replaceAll("L", "W");
            t = t.replaceAll("r", "w");
            t = t.replaceAll("R", "W");
        }
        return t;
    }

    /** Method used to prepare and return pirate translations.
     * @param original Message being translated.
     * @return Returns translated message preceded by "Yarr!"
     */
    private String pirateTranslation() {
        String original = this.originalMessage;
        String[] words = original.split(" ");
        String t = "";
        for (int i = 0; i < words.length; i++) {
            t += pirateTranslator(words[i]) + " ";
        }
        pirateCount++;
        return "Yarr! " + t.trim();
    }

    /** Method used to translate each word in pirate translation.
     * @param word Word being translated.
     * @return Returns translated word.
     */
    private String pirateTranslator(String word) {
        String t = word;
        if (t.equals("and") || t.equals("is") || t.equals("are") || t.equals("am") || t.equals("my")) {
            t = t.replace("and", "n");
            t = t.replace("is", "be");
            t = t.replace("are", "be");
            t = t.replace("am", "be");
            t = t.replace("my", "me");
        }
        if (t.equals("And") || t.equals("Is") || t.equals("Are") || t.equals("Am") || t.equals("My")) {
            t = t.replace("And", "N");
            t = t.replace("Is", "Be");
            t = t.replace("Are", "Be");
            t = t.replace("Am", "Be");
            t = t.replace("My", "Me");
        }
        if (t.length() >= 3) {
            String lastThree = t.substring(t.length() - 3);
            if (lastThree.contains("ing")) {
                t = t.substring(0, (t.length() - 3)) + "in'";
            }
        }
        if (t.length() >= 4) {
            String lastFour = t.substring(t.length() - 4);
            if (lastFour.contains("ing")) {
                lastFour = lastFour.replace("ing", "in'");
                t = t.substring(0, (t.length() - 4)) + lastFour;
            }
        }
        if (t.length() >= 3) {
            String firstThree = t.substring(0, 3);
            if (firstThree.equals("you")) {
                firstThree = firstThree.replace("you", "ye");
                t = firstThree + t.substring(3);
            }
            if (firstThree.equals("You")) {
                firstThree = firstThree.replace("You", "Ye");
                t = firstThree + t.substring(3);
            }
        }
        return t;
    }

    /** Method used to prepare and return binary string translations.
     * @param original Message being translated.
     * @return Returns binary string representation of original message.
     */
    private String computerTranslation() {
        String original = this.originalMessage;
        String[] words = original.split(" ");
        String t = "";
        for (int i = 0; i < words.length; i++) {
            t += computerTranslator(words[i]);
        }
        computerCount++;
        return t.trim();
    }

    /** Method used to translate each word to binary string.
     * @param word Word being translated.
     * @return Returns binary string representation of word.
     */
    private String computerTranslator(String word) {
        String wordCopy = word;
        String t = "";
        for (int i = 0; i < wordCopy.length(); i++) {
            char currentChar = wordCopy.charAt(i);
            int charNum = (int) (currentChar);
            String binaryString = Integer.toBinaryString(charNum);
            t += binaryString + " ";
        }
        return t;
    }

    /** Method used to return the number of times each dialect was used for translation.
     * @return Returns number of times each dialect was used in string format
     */
    public static String translationTallyString() {
        return elmerFuddCount + " " + pirateCount + " " + computerCount;
    }
}