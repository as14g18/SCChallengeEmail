import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeEmail {

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner (System.in);
		
		System.out.print("Enter ID: ");		
		URL url1 = new URL("https://www.ecs.soton.ac.uk/people/" + reader.nextLine());
		URLConnection connection = url1.openConnection();
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		Pattern p = Pattern.compile("property=\"name\">(.*?)</h1"); // regex: "property="name">$NAME<
		String line;
		while ((line = buffer.readLine()) != null) {
			Matcher m = p.matcher(line);
			if (m.find()) {
				System.out.println(m.group(1));
				return;
			}			
		}
		
		System.out.println("No users found with that email ID");
	}
}