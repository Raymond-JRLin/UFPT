// RPLB - Blueberries
// #dynamic-programming
// Teresa picked up enough strawberries, now she wants to pick blueberries from the magical blueberry bush from Rainbowland.
//
// Knowing her previous experience with the strawberries, Teresa wants to pick up the blueberries in a way that she may not exceed the limit proposed.
//
// When picking the blueberries, she noticed that if she pick from the bush i, she couldn't pick the blueberries at the bush i+1 (some sort of magic in rainbowland).
//
// Worried about this, Teresa wants to know the maximum blueberries she can pick, given the number of bushes and the number of blueberries in each bush.
//
// Input
// Will contain an integer T, then, T cases will follow, each case starts with a number N and K, being N the number of bushes and K the number of blueberries Teresa will pick as maximum, the next line contains N integers, each one representing the blueberries there is on the i-th bush.
//
// Output
// You will output for each test case the string: “Scenario #i: “ where i is the test case you are analyzing, then, an integer denoting the maximum number of blueberries you can grab.
//
// Example
// Input:
// 2
// 5 100
// 50 10 20 30 40
// 5 87
// 21 45 30 12 14
//
// Output:
// Scenario #1: 90
// Scenario #2: 65
// Output explanation (first scenario)
// Teresa picks the 1st blueberry bush (50), she cannot pick the 2nd, she decides not to pick until the 5th one where she picks the “40” blueberry, she could pick the 3rd bush, but she would exceed the limit (100).
//
// Output explanation (second scenario)
// Teresa picks the 1st, the 3rd and the 5th bush, total of (21+30+14 = 65) blueberries
//
// CONSTRAINTS
// 1 <= N <= 1000
// 1 <= K <= 1000


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int index = 1;
        while (index <= cases) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int result = getMax(nums, max);
            System.out.println("Scenario #" + index + ": " + result);
            index++;
        }
    }
    private static int getMax(int[] nums, int max) {
        int n = nums.length;
        // definition
        int[][] pick = new int[n][max + 1];
        int[][] no = new int[n][max + 1];
        // initialization
        for (int i = nums[0]; i < max + 1; i++) {
            pick[0][i] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < max + 1; j++) {
                // update pick if we can pick at this position
                if (j >= nums[i] && no[i - 1][j - nums[i]] + nums[i] <= j) {
                    pick[i][j] = no[i - 1][j - nums[i]] + nums[i];
                }
                // update no-pick if we don't pick here
                no[i][j] = Math.max(no[i - 1][j], pick[i - 1][j]);
            }
        }
//        System.out.println("pick array is: ");
//        printArray(pick);
//        System.out.println("non-pick array is: ");
//        printArray(no);
        return Math.max(pick[n - 1][max], no[n - 1][max]);
    }
    public static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 10; j < array[0].length; j += 10){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
