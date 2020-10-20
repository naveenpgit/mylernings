package rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import util.json.JSONUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyRestClient {
	private static  Class<?> responseType = String.class;
	static String IP = "10.210.25.72";
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		String registerLoanURL = MessageFormat.format("http://{0}/encompasswrapper/encompass/api/v1/loans/registerloan", IP);

		String beginSessionURL = MessageFormat.format("http://{0}/encompasswrapper/encompass/api/v1/usersessions/usersession/begin", IP);

		String payLoad = JSONUtils.fromFile("/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/resources/CreateLOanPaylod.json");
		LinkedMultiValueMap requestHeader = new LinkedMultiValueMap();
		requestHeader.put("x-api-key", Arrays.asList("3dad59cf-3911-4f3a-a579-43729499ec82"));
		HttpEntity<?> entity = new HttpEntity(payLoad, requestHeader);
		Map<String, String> uriVariables = new HashMap<>();
		ResponseEntity<?> responseEntity = restTemplate
				.exchange(beginSessionURL, HttpMethod.POST, entity, responseType,
						uriVariables);
		System.out.println(responseEntity.getBody());
	}
}
