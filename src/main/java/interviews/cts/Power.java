package interviews.cts;

import java.util.Scanner;

public class Power {
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt())
        {
            int n = in.nextInt();
            int p = in.nextInt();
            MyCalculator m = new MyCalculator();
            try
            {
                System.out.println(m.power(n,p));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
}

class MyCalculator{
    int power(int n , int p) throws Exception{
        if(n<0 || p<0){
            throw new Exception("n and p should be non-negative");
        }
        return (int)Math.pow(n , p);
    }
}
