package zolando.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class PascalTriangle {
	public static void main(String[] args) {
		boolean[] in = new boolean[]{true, false, false, true, false};
		System.out.println(findTrues(in, 0));
	}
	
	static int findTrues( boolean[] in , int count){
		boolean[] next = new boolean[in.length-1];
		for(int i=0; i<in.length;i++){
			if(in[i]){
				count++;
			}
			if(i<in.length-1) {
				next[i] =(in[i] || in[i + 1]);
			}
		}
		if(next.length!=1){
			return findTrues(next, count);
		}else{
			if(in[0]){
				count++;
			}
			return count;
		}
	}
}
