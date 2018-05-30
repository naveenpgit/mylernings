package learn;

public class TrickyJavaQuestions {
    public static void main(String[] args) {

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));

        /**
         * Answer: This question is tricky because unlike the Integer, where MIN_VALUE is negative,
         * both the MAX_VALUE and MIN_VALUE of the Double class are positive numbers. The Double.MIN_VALUE is 2^(-1074),
         * a double constant whose magnitude is the least among all double values. So unlike the obvious answer,
         * this program will print 0.0 because Double.MIN_VALUE is greater than 0.
         *
         * Read more: http://www.java67.com/2012/09/top-10-tricky-java-interview-questions-answers.html#ixzz5BmQKiEv0
         */
    }

}
