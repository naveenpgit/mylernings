package maven;

import maven.model.ChangeLog;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static maven.util.LoadAllPOMModels.getResult;
import static maven.util.LoadAllPOMModels.init;

public class Application {
	static String root;

	static String module;

	static String changeType;

	static Set<ChangeLog> changeLogs = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			throw new Exception(
					"Project root directory, module name  and change type should be passed");
		}
		root = args[0];
		module = args[1];
		changeType = args[2];

		init(root); //loads all poms into memory, which can be accessed via LoadAllPOMModels.getResult()
		prepareChangeLog(module);
		changeLogs.forEach(x->{
			System.out.println(String.format("%s\t\033[1m upgrade version from %s --to-> %s \033[0m" , x.getArtifactId() , x.getCurrentVersion() , x.getNewVersion()));
			System.out.print("\t|\n\t\033[1m used_by - - : \033[0m");
			System.out.println(x.getUsedBy().stream().collect(Collectors.joining(", ")));
		});

		System.out.println("Do you wish to update? type Y/N?");
		Scanner scanner = new Scanner(System.in);
		boolean update = StringUtils.startsWithIgnoreCase(scanner.nextLine() , "Y" );
		if(update) {
			System.out.println("*** updating the pom files *****");
			changeLogs.forEach(x -> {
				Model model = getResult().stream().filter(y -> y.getArtifactId()
						.equalsIgnoreCase(x.getArtifactId())).findFirst().get();
				model.setVersion(x.getNewVersion());
				MavenXpp3Writer writer = new MavenXpp3Writer();
				try {
					writer.write(new FileWriter("pom.xml"), model);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	static void prepareChangeLog(String artifactId) {
		ChangeLog changeLog = new ChangeLog();
		Model model = getResult().stream()
				.filter(x -> x.getArtifactId().equals(artifactId)).findFirst()
				.orElseThrow(IllegalArgumentException::new);

		changeLog.setArtifactId(model.getArtifactId());
		changeLog.setGroupId(model.getGroupId());
		changeLog.setCurrentVersion(model.getVersion());
		changeLog.setNewVersion(model.getVersion() + "+1");

		List<String> dependants = findDependants(model.getArtifactId());
		changeLog.setUsedBy(dependants);

		if(CollectionUtils.isNotEmpty(dependants)){
			dependants.forEach(x-> prepareChangeLog(x));
		}
		 changeLogs.add(changeLog);
	}

	private static List<String> findDependants(String artifactId) {
		List<String> dependants = new ArrayList<>();
		getResult().stream().filter(x -> !x.getArtifactId().equals(artifactId)).forEach(y->{
			Optional<Dependency> first = y.getDependencies().stream()
					.filter(d -> d.getArtifactId().equalsIgnoreCase(artifactId))
					.findFirst();
			if(first.isPresent()){
				dependants.add(y.getArtifactId());
			};
		});
		return  dependants;
	}
}
