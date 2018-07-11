package unittesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticUtil.class)
public class MockStaticUsingPowerMockTest {

    @InjectMocks
    MockStaticUsingPowerMock mockStaticUsingPowerMock;

    @Before
    public void setup() {
        PowerMockito.mockStatic(StaticUtil.class);
        Mockito.when(StaticUtil.add(Matchers.anyInt() , Matchers.anyInt())).thenReturn(33);
    }

    @Test
    public void testAddition() {
        assertEquals(33, mockStaticUsingPowerMock.addition(1, 2));
    }
}
