package unittesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class TestLambdaTest {

    TestLambda testLambda = new TestLambda();

    @Test
    public void namesToUpper() {
        List<String> names = Arrays.asList("Naveen" , "james" , "peter");
        System.out.println(testLambda.namesToUpper(names));
    }

    @Test
    public void toupper() {
        Function<String, String> toupper = testLambda.toupper();
        assertEquals("NAVEEN", toupper.apply("naveen"));
    }

    @Test
    public void sixPieceWithProductInfoIndSuccess(){
        Map<String, Object> loanInfo = new HashMap<>();
        Map<String, Object> loan = new HashMap<>();
        loanInfo.put("LOAN" , loan);

        Function<Map<String, Object>, Object>  temp = testLambda.sixPieceWithProductInfoIndSuccess();
        temp.apply(loanInfo);
        assertTrue((boolean)(loan.get("SIX_PIECE_WITH_PRODUCT_INFO_IND")));
    }
}
