package algorithm.medium;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard { // Complete the climbingLeaderboard function below.


    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        List<Integer> res = new ArrayList<>();

        List<Integer> scores_ = Arrays.stream(scores).boxed().collect(Collectors.toList());

        Arrays.stream(alice).forEach(x -> {
            int[] array = scores_.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
            int temp = Arrays.binarySearch(array, x);

            if(temp>=0){
                res.add(temp);
            }
            else{
//                scores_.add();
            }
        });

        return res.stream().mapToInt(x -> x).toArray();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int scoresCount = scanner.nextInt();
//
//        int[] scores = new int[scoresCount];
//
//        for (int i = 0; i < scoresCount; i++) {
//            scores[i] = scanner.nextInt();
//        }
//
//        int aliceCount = scanner.nextInt();
//
//        int[] alice = new int[aliceCount];
//
//        for (int i = 0; i < aliceCount; i++) {
//            alice[i] = scanner.nextInt();
//        }

        //int[] result = climbingLeaderboard(scores, alice);
        int[] result = climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5, 25, 50, 120});


        for (int x : result) {
            System.out.println(x);
        }

        scanner.close();
    }
}
