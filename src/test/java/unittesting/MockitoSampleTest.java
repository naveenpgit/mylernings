package unittesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import unittesting.vo.MockitoVO;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MockitoVO.class })
public class MockitoSampleTest {

	@Test
	public void sayHello() {
	}

}