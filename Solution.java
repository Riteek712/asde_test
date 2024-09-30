import java.util.Arrays;
import java.util.Scanner;

public class Solution {
     // Function to get the highest 's' skip steps from the array
public static int[] getSkipIndices(int[] powers, int s) {
    // Create a copy of the original array
    int[] copy = Arrays.copyOf(powers, powers.length);
    // Sort the copied array
    Arrays.sort(copy);
    int[] skipSteps = new int[s];
    for (int i = 0; i < s; i++) {
        skipSteps[i] = copy[copy.length - 1 - i];  // Getting the top 's' powers
    }
    return skipSteps;
}

    // Function to check if an array contains a specific target
    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Function to determine if Abhimanyu can win the battle
    public static boolean canAbhimanyuWin(int initialPower, int[] enemyPowers, int skipCount, int rechargeCount) {
        int power = initialPower;

        // Regenerate specific enemy powers
        enemyPowers[3] += enemyPowers[2] / 2;
        enemyPowers[7] += enemyPowers[6] / 2;
        
        int[] skipSteps = getSkipIndices(enemyPowers, skipCount);

        // Loop through the enemies in the Chakravyuha
        for (int i = 0; i < 11; i++) {
            // Check if the current enemy can be skipped
            if (contains(skipSteps, enemyPowers[i]) && skipCount > 0) {
                System.out.println("Abhimanyu skips at circle " + (i + 1));
                skipCount--;  // Decrease the skip count
                continue;  // Move to the next enemy
            }

            // Check if Abhimanyu can fight the enemy
            if (power >= enemyPowers[i]) {
                System.out.println("Abhimanyu " + power + " fights enemy at circle " + (i + 1) + " with power " + enemyPowers[i]);
                power -= enemyPowers[i];  // Reduce Abhimanyu's power after the fight
            } else {
                // If Abhimanyu's power is less than the enemy's power
                if (rechargeCount > 0) {
                    System.out.println("Abhimanyu recharges at circle " + (i + 1));
                    power = initialPower;  // Recharge Abhimanyu's power
                    System.out.println("Abhimanyu " + power + " fights enemy at circle " + (i + 1) + " with power " + enemyPowers[i]);
                power -= enemyPowers[i];
                    rechargeCount--;
                } else {
                    // If recharges are exhausted, skips will be used.
                    if(skipCount>0){
                        System.out.println("Abhimanyu skips at circle " + (i + 1));
                skipCount--;  // Decrease the skip count
                continue;
                    }
                    // If no skips or recharges left, Abhimanyu loses
                    System.out.println("Abhimanyu loses at circle " + (i + 1));
                    return false;
                }
            }
        }
        return true;  // Abhimanyu wins if he passes all circles
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Abhimanyu's starting power, number of skips and recharges
        System.out.println("Enter Abhimanyu's starting power (p):");
        int p = sc.nextInt();

        System.out.println("Enter number of skips (a):");
        int a = sc.nextInt();

        System.out.println("Enter number of recharges (b):");
        int b = sc.nextInt();

        // Input: enemies' power in each circle
        int[] k = new int[11];
        System.out.println("Enter the power of enemies in each circle (k1 to k11):");
        for (int i = 0; i < 11; i++) {
            System.out.print("k"+(i+1)+":  ");
            k[i] = sc.nextInt();
        }

        // Test the algorithm with provided inputs
        boolean result = canAbhimanyuWin(p, k, a, b);
        if (result) {
            System.out.println("Abhimanyu successfully crosses the Chakravyuha!");
        } else {
            System.out.println("Abhimanyu fails to cross the Chakravyuha.");
        }

        sc.close();
    }
}
