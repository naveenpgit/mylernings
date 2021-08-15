package zolando.practice;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryGap {
	public static void main(String[] args) {
		String  s  = Integer.toBinaryString(20);
		AtomicInteger max = new AtomicInteger(0);
		AtomicInteger counter = new AtomicInteger(0);
		Arrays.stream(s.split("")).forEach(x->{
			if (x.equals("0")){
				counter.getAndIncrement();
			}else{
				int temp = counter.get();
				if(temp> max.get()) {
					max.set(counter.get());
				}
				counter.set(0);
			}
		});
		System.out.println(max.get());
	}
}
