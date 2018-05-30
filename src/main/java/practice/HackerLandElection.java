package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HackerLandElection {
    public static void main(String[] args) {

//        String[] s = new String[]{
//                "Alex",
//                "Michael",
//                "Harry",
//                "Dave",
//                "Michael",
//                "Victor",
//                "Harry",
//                "Alex",
//                "Mary",
//                "Mary" };

        String[] s = new String[]{
                "Joe",
                "Mary",
                "Mary",
                "Joe" };

        Map<String, Candicate> temp = new HashMap<>();

        Arrays.stream(s).forEach(x -> {
            if (temp.get(x) == null) {
                temp.put(x, new Candicate(x, 1));
            } else {
                temp.put(x, temp.get(x).incrementVote());
            }
        });

        String res = temp.values().stream().sorted().collect(Collectors.toList()).get(0).name;
        System.out.println(res);

    }

    static class Candicate implements Comparable {
        String name;
        int votes;

        public Candicate(String name, int votes) {
            this.name = name;
            this.votes = votes;
        }

        Candicate incrementVote() {
            votes++;
            return this;
        }

        @Override
        public int compareTo(Object o) {
            Candicate candicate = ((Candicate) o);

            int nameC = candicate.name.compareTo(this.name);

            int votesC = Integer.valueOf(candicate.votes).compareTo(Integer.valueOf(this.votes));

            return votesC == 0 ? nameC : votesC;
        }
    }
}
