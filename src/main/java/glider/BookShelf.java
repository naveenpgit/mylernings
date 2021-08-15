package glider;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BookShelf {
	public static void main(String[] args) {
		int n = 19;
		AtomicInteger sum = new AtomicInteger(0);
		IntStream.rangeClosed(1, n).forEach(i -> {
			System.out.println(i);
			sum.addAndGet(new Integer(i).toString().length());
		});
		System.out.println("---------");
		System.out.println(sum.get());
	}
}
