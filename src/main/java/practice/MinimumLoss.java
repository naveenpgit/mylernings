package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumLoss {
    public static void main(String[] args) {
//        System.out.println(minimumLoss(new long[]{5, 10, 3}));
        System.out.println(minimumLoss(new long[]{20, 7, 8, 2, 5}));
    }

    static int minimumLoss(long[] price) {
        // Complete this function
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < price.length; i++) {
            nodes.add(new Node(i, price[i]));
        }

        Collections.sort(nodes);

        Long min = Long.MAX_VALUE;
        Node pre = null;

        for (Node node : nodes) {
            if (pre != null) {
                if (pre.oIndex < node.oIndex) {
                    long temp = pre.value - node.value;
                    if (temp < min)
                        min = temp;
                }
            }
            pre = node;
        }

        return min.intValue();

    }

    static class Node implements Comparable {
        public int oIndex;
        public long value;

        public Node(int oIndex, long value) {
            this.oIndex = oIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return Long.valueOf(this.value).compareTo(((Node) o).value) * -1;
        }

        @Override
        public String toString() {
            return ((Long) value).toString();
        }
    }
}
