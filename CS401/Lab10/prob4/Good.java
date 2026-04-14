package prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Good {
	public static void main(final String[] args) {
		Good good = new Good();
//
//		System.out.println(String.format("Friends with names that start"
//				+ " with 'N': "+ good.findStartsWithLetterOld(Folks.friends, "N")));
//
//		System.out.println(String.format("Editors with names that start"
//				+ " with 'N': " + good.findStartsWithLetterOld(Folks.editors, "M")));
//

		List<String> words = Arrays.asList(
				"apple", "banana", "cherry",
				"date", "grape", "kiwi",
				"apricot", "blue"
		);
		//
		int result = good.countWords(words, 'a', 'z', 5);
		System.out.println("Result = " + result);
	}

	public int countWords(List<String> words, char c, char d, int len) {
		return (int) words.stream()
				.filter(w -> w.length() == len)
				.filter(w -> w.indexOf(c) != -1) // that contain the character c
				.filter(w -> w.indexOf(d) == -1) // that do not contain the character d
				.count();
	}
	
	public List<String> findStartsWithLetterOld(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> name.startsWith(letter)) //returns filtered stream
         	     .map(name -> name.toUpperCase())  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public List<String> findStartsWithLetter(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	public List<String> findStartsWithLetterLimit(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .limit(2)
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public boolean starts(String word, String letr) {
		System.out.println("Looking at " + word + " to check if it starts with " + letr);
		return word.startsWith(letr);
	}
	public String toUpper(String word) {
		System.out.println("Looking at " + word + " to convert to upper case");
		return word.toUpperCase();
	}
}
