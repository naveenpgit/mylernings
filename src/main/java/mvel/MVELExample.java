package mvel;

import org.mvel2.MVEL;
import util.json.JSONUtils;
import util.mvel.MVELUtils;

import java.util.Map;

public class MVELExample {
    public static void main(String[] args) {
//		Map<String, Object> responseMap = JSONUtils
//				.JsonToMap(JSONUtils.fromFile("resources/sample_1.json"));

//		System.out.println(MVELUtils.extractStringValue(
//				"dealsets.dealset[0].deals.deal[0].loans.loan[0].loandetail.extension.other.transactionId",
//				responseMap));

        Map<String, Object> pollResponseMap = JSONUtils
                .JsonToMap(JSONUtils
                        .fromFile("resources/poll_order_pending.json"));

        System.out.println(MVELUtils.extractStringValue(
                "dealsets.dealset[0].deals.deal[0].loans.loan[0].extension.other.documents.document[0].extension.other.documentStatus",
                pollResponseMap));


        MVEL.executeSetExpression(
                MVEL.compileSetExpression("?dealsets.?dealset[0].?deals.?deal[0].?loans.?loan[0].?extension.?other.?documents.?document[0].?extension.?other.documentStatus"),
                pollResponseMap,
                "Hellooooo");

        System.out.println(MVELUtils.extractStringValue(
                "dealsets.dealset[0].deals.deal[0].loans.loan[0].extension.other.documents.document[0].extension.other.documentStatus",
                pollResponseMap));
    }
}
