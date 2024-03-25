public class BitCalculator{
    public static void main(String[] args){
        int numBytes = 1024; 
        int numBits = numBytes * 8; 
        float numKilobytes = numBytes / 1000; 
        float numMegabytes = numKilobytes / 1024; 

        System.out.println(numBytes + " byte(s) is the same as..."); 
        System.out.println(numBits + " bit(s)"); 
        System.out.println(numKilobytes + " kilobyte(s)");
        System.out.println(numMegabytes + " megabyte(s)");
    }
}