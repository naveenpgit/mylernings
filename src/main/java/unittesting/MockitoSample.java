package unittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unittesting.vo.MockitoVO;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class MockitoSample {

	public String sayHello() {
		return format("Hi - {0}", MockitoVO.getKeyStore().get("Message"));
	}

}
