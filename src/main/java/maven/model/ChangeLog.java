package maven.model;

import lombok.Data;

import java.util.List;

@Data
public class ChangeLog {

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public List<String> getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(List<String> usedBy) {
		this.usedBy = usedBy;
	}

	public String getNewVersion() {
		return newVersion;
	}

	public void setNewVersion(String newVersion) {
		this.newVersion = newVersion;
	}

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
