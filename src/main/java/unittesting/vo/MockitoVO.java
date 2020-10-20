package unittesting.vo;

import java.util.HashMap;
import java.util.Map;

public class MockitoVO {
	private static Map<String, String> keyStore = new HashMap<>();
	static {
		keyStore.put("Message", "Naveen");
	}

	public static Map<String, String> getKeyStore() {
		return keyStore;
	}
}
