package database.dblist;

public class Rank {
	private int rankId;
	private String nickname;
	private int score;
	public Rank(int rankId, String nickname, int score) {
		super();
		this.rankId = rankId;
		this.nickname = nickname;
		this.score = score;
	}
	public Rank(String nickname, int score) {
		super();
		this.nickname = nickname;
		this.score = score;
	}
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "rank [rankId=" + rankId + ", nickname=" + nickname + ", score=" + score + "]";
	}
	
}
