package unittesting;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestLambda {

    public List<String> namesToUpper(List<String> names) {
        return names.stream().map(name -> toupper().apply(name)).collect(Collectors.toList());
    }

    public Function<String, String> toupper() {
        return (input) -> {
            return input.toUpperCase();
        };
    }

    protected Function<Map<String, Object>, Object> sixPieceWithProductInfoIndSuccess() {
        return (Map<String, Object> loanInfo) -> {
            return ((Map<String, Object>) loanInfo.get("LOAN")).put("SIX_PIECE_WITH_PRODUCT_INFO_IND", true);
        };
    }
}
