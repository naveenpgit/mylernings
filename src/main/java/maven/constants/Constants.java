package maven.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Constants {
	Set<String> EXCLUDE = new HashSet<>(Arrays.asList(
			"finx_brokerui",
			"finx_config",
			"target",
			".git",
			"src",
			"resources/logs",
			".idea"));
}
