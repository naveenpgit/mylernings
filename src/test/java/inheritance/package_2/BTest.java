package inheritance.package_2;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;

public class BTest {

    public static final String NEWWW = "newww";

    @InjectMocks
    B b = PowerMockito.spy(new B());

    @Test
    public void voila() throws Exception {
//        B b = PowerMockito.spy(new B());
        PowerMockito.doReturn(NEWWW).when(b, "sayHello", Matchers.anyString());
        Assert.assertEquals(NEWWW, b.voila("Test"));
    }
}
