package kattis;
import java.util.Arrays;
import java.util.Scanner;

public class ColoringSocks_260734701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        
        int[] inputSocks = new int[s];
        for (int i = 0; i < inputSocks.length; i++) {
        	inputSocks[i] = sc.nextInt();
        }
        
        if (s < 1) {
			System.out.println("0");
			System.exit(0);
		}
        if (c <= 0 || c > Math.pow(10, 5)) {
			System.out.println("The capacity of a laundry machine must be positive and less than or equal to 10^5");
			System.exit(0);
		}
        if (k < 0 || k > Math.pow(10, 9)) {
			System.out.println("The maximum color difference must be positive and less than or equal to 10^9");
			System.exit(0);
		}
        
        Arrays.sort(inputSocks);
        
        int numMachines = 0;
        int currMachineColor = -1;
        int currCapacity = 0;

        for (int i = 0; i < inputSocks.length; i++){
            if (currMachineColor == -1){
                numMachines++;
                currMachineColor = inputSocks[i];
                currCapacity = 1;
            } else if (currCapacity == c){
                numMachines++;
                currMachineColor = inputSocks[i];
                currCapacity = 1;
            } else if ((Math.abs(currMachineColor - inputSocks[i])) <= k){
                 currCapacity++;
            } else {
                numMachines++;
                currMachineColor = inputSocks[i];
                currCapacity = 1;
            }
        }
        System.out.println(numMachines);
        sc.close();
    }
}
