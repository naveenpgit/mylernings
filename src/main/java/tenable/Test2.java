package tenable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test2 {
	public static void main(String[] args) {
		getNumberOfMovies("maze");
	}

	static int getNumberOfMovies(String substr) {
		/*
		 * Endpoint: "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=substr"
		 */
		String result = "";
		try {
			URL url = new URL("https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=" + substr);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(httpURLConnection.getInputStream()))) {
				for (String line; (line = reader.readLine()) != null; ) {
					if (line.contains("\"total\"")) {
						result = line;
						break;
					}
				}
			}
			System.out.println(result);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
