import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeEmail { // looking for property="name">NAME<

	public static void main(String[] args) throws Exception {
		// Setting up BufferedReader object
		// Telling java to use main proxy server to get through university firewall
		Scanner reader = new Scanner (System.in);
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "152.78.128.51");
		System.getProperties().put("proxyPort", "3128");
		
		System.out.print("Enter ID: ");
		String emailID = reader.nextLine();
		String url = "https://www.ecs.soton.ac.uk/people/" + emailID;
		
		URL url1 = new URL(url);
		URLConnection connection = url1.openConnection();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String source = "";
		String line;
		while ((line = buffer.readLine()) != null) {
			source += line;
		}
		
		Pattern p = Pattern.compile("property=\"name\">.*</h1");
		Matcher m = p.matcher(source);
		while (m.find()) {
			String g = m.group();
			System.out.println(g.substring(16, g.length() - 4));
		}
		
	}

}
