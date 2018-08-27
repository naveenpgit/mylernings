package maven.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static maven.constants.Constants.EXCLUDE;

public class LoadAllPOMModels {
	private static List<Model> result = new ArrayList<>();

	public static void init(String directoryName) {
		listAllPomFiles(directoryName);
	}

	private static void listAllPomFiles(String directoryName) {
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] files = directory.listFiles(
				(d) -> d.getName().equals("pom.xml") ||
						(d.isDirectory() && !d.isHidden() &&
								!EXCLUDE.contains(d.getName())));
		Arrays.stream(files).forEach(x -> {
			if (x.isFile()) {
				loadMavenModel(x.getPath());
			}
			else {
				listAllPomFiles(x.getPath());
			}
		});
	}

	private static void loadMavenModel(String path) {
		MavenXpp3Reader reader = new MavenXpp3Reader();
		try {
			result.add(reader.read(new FileReader(path)));
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static List<Model> getResult() {
		if (CollectionUtils.isEmpty(result))
			throw new IllegalStateException("Pom models list is empty");
		return result;
	}
}
