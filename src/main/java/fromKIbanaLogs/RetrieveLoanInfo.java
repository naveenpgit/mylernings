package fromKIbanaLogs;

import org.apache.commons.lang3.StringUtils;
import org.mvel2.MVEL;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.text.MessageFormat.format;
import static org.mvel2.MVEL.eval;
import static util.json.JSONUtils.JsonToMap;
import static util.json.JSONUtils.fromFile;

public class RetrieveLoanInfo {
	// (application : *loan* or application : *gateway*) and NOT ( msg : *voa* OR msg:*voi*) and "Time Taken :" and "retrieveloanurl"
	public static void main(String[] args) {
		Map<String, Object> log = JsonToMap(
				fromFile(
						"/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/resources/logs/retrieveloanurl_log.json"));
		AtomicInteger start = new AtomicInteger(1);
		List<Map<String, Object>> hits = (List<Map<String, Object>>) eval(
				"responses[0].hits.hits", log);
		hits.stream()
				.map(x -> MVEL.evalToString("_source.message", x))
				.map(s -> StringUtils.substringAfterLast(s, "Time Taken : "))
				.map(s -> format("{0} : {1}", start.getAndIncrement(), s))
				.forEach(x -> System.out.println(x));

	}
}
