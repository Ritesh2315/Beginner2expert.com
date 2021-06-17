package JavaProgramsStudy;

public class StringPrograms {

	public static void main(String[] args) {
		String sentence = "Go work";
	    String reversed = reversePractice(sentence);
	    System.out.println("The reversed sentence is: " + reversed);

	}

	public static String reversePractice(String sentence) {
	    if (sentence.isEmpty())
	      return sentence;
	    //System.out.println(sentence.substring(1));
	    //System.out.println(sentence.charAt(0));
	    return reversePractice(sentence.substring(1)) + sentence.charAt(0);
	    
	  }
}
