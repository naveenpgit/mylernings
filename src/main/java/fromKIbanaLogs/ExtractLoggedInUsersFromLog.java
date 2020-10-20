package fromKIbanaLogs;

import org.apache.commons.lang3.StringUtils;
import org.mvel2.MVEL;

import java.util.List;
import java.util.Map;

import static org.mvel2.MVEL.eval;
import static util.json.JSONUtils.JsonToMap;
import static util.json.JSONUtils.fromFile;

public class ExtractLoggedInUsersFromLog {
	// NOT ( msg : *voa* OR msg:*voi*) and "Login request received for user"
	public static void main(String[] args) {
		Map<String, Object> log = JsonToMap(
				fromFile(
						"/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/resources/logs/LoggedINUserLog.json"));

		List<Map<String, Object>> hits = (List<Map<String, Object>>) eval(
				"responses[0].hits.hits", log);
		hits.stream()
				.map(x -> MVEL.evalToString("_source.message", x))
				.map(s -> StringUtils.substringAfterLast(s, "for user - "))
				.forEach(x -> System.out.println(x));

	}
}
