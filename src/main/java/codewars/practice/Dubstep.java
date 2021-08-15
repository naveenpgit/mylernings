package codewars.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dubstep {
	public static void main(String[] args) {
		System.out.println(SongDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB"));
	}

	public static String SongDecoder(String song) {
		// Your code is here...
		return Arrays.stream(song.split("WUB")).filter(x -> !x.isEmpty()).collect(Collectors.joining(" "));
	}
}
