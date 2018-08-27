package maven.model;

import lombok.Data;

import java.util.List;

@Data
public class ChangeLog {

	String artifactId;

	String groupId;

	String currentVersion;

	String newVersion;

	List<String> usedBy;

	@Override
	public boolean equals(Object anObject) {
		ChangeLog changeLog = (ChangeLog) anObject;

		return changeLog.getArtifactId().equals(this.artifactId) &&
				changeLog.getGroupId().equals(this.groupId);
	}

	@Override
	public int hashCode() {
		return (this.getArtifactId() + this.getArtifactId()).hashCode();
	}
}
