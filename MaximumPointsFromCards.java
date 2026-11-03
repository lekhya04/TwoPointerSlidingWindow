import java.util.Scanner;

public class MaximumPointsFromCards {
    static int maxScore(int[] cardScore, int k) {
        int lsum = 0;
        int rsum = 0;
        int n = cardScore.length;

        for (int i = 0; i < k; i++) {
            lsum += cardScore[i];
        }
        int maxsum = lsum;

        int rind = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum -= cardScore[i];
            rsum += cardScore[rind];
            rind--;
            maxsum = Math.max(maxsum, lsum + rsum);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();

        int[] cardScore = new int[n];
        System.out.println("Enter card scores:");
        for (int i = 0; i < n; i++) {
            cardScore[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Maximum score: " + maxScore(cardScore, k));
        sc.close();
    }
}