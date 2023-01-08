package database.dblist;

public class UserProject {
	private int id;
	private int userId;
	private int infoId;
	private int projectId;
	private boolean complete;
	private int lastTime;
	
	public UserProject(int id, int userId, int infoId, int projectId, boolean complete, int lastTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.infoId = infoId;
		this.projectId = projectId;
		this.complete = complete;
		this.lastTime = lastTime;
	}
	
	public UserProject(int userId, int infoId, int projectId, boolean complete, int lastTime) {
		super();
		this.userId = userId;
		this.infoId = infoId;
		this.projectId = projectId;
		this.complete = complete;
		this.lastTime = lastTime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public int getLastTime() {
		return lastTime;
	}
	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "UserProject [id=" + id + ", userId=" + userId + ", infoId=" + infoId + ", projectId=" + projectId
				+ ", complete=" + complete + ", lastTime=" + lastTime + "]";
	}
}