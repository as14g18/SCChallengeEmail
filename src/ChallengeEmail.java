import java.util.Scanner;

public class ChallengeEmail {

	public static void main(String[] args) {
		Scanner reader = new Scanner (System.in);
		
		System.out.print("Enter ID: ");
		String emailID = reader.nextLine();
		String url = "https://www.ecs.soton.ac.uk/people/" + emailID;
		
		
	}

}
