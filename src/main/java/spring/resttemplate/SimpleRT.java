package spring.resttemplate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;

public class SimpleRT {

	public static void main_(String[] args) throws Exception {

		String uri =
				"https://media-pod0-ep3.elliemae.com/v2/media/instance/TEBE11169373/loans/5fe5fe12-f71b-4851-9a30-571223b0c362/files/pResponse-ep3_15b46dc1-4ee9-4877-8dc4-7a351c9b8a2c_fqOByYR.txt?tokencreator=encompass&tokenexpires=1546415696&token=QCgIBad%2f2FDmHkaLUz%2fLFFx8qCqgnmlqS4jIl1908CA%2biexcTWj2NsjV%2bqxb00z%2bHxMz004Mqm0HiVIB%2f8k%2fNA%3d%3d";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		uri = URLDecoder.decode(uri, "UTF-8");
		//headers.set(HttpHeaders.ACCEPT, "*/*");
//		headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
//		headers.setCacheControl("no-cache");
//		headers.set("Host", "media-pod0-ep3.elliemae.com");
//		headers.set("Postman-Token", "d486fadf-05ac-4fbb-8b88-c8d74ad8863a");
//		headers.set("User-Agent", "PostmanRuntime/7.4.0");
		try {
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			ResponseEntity<String> res = restTemplate
					.exchange(uri, HttpMethod.GET, entity, String.class);
			System.out.println("------------");
			System.out.println(res.getBody());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getUnFormattedSSN("333-123-2345"));
	}

	protected static String getUnFormattedSSN(String ssn) {
		return StringUtils.replaceAll(ssn,
				"-",
				"");
	}
}
