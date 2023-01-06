package projectDialog;

public class Project {
	private int id;
	private String projcetName;
	private int rewardExp;
	private int time;
	public Project(int id, String projcetName, int rewardExp, int time) {
		super();
		this.id = id;
		this.projcetName = projcetName;
		this.rewardExp = rewardExp;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjcetName() {
		return projcetName;
	}
	public void setProjcetName(String projcetName) {
		this.projcetName = projcetName;
	}
	public int getRewardExp() {
		return rewardExp;
	}
	public void setRewardExp(int rewardExp) {
		this.rewardExp = rewardExp;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projcetName=" + projcetName + ", rewardExp=" + rewardExp + ", time=" + time
				+ "]";
	}

}
