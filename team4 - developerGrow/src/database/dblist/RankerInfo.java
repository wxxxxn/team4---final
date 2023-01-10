package database.dblist;

public class RankerInfo {
	
	private int date;
	private int time;
	private int usedCiga;
	
	public RankerInfo(int date, int time, int usedCiga) {
		super();
		this.date = date;
		this.time = time;
		this.usedCiga = usedCiga;
	}

	public int getDate() {
		return date;
	}

	public int getTime() {
		return time;
	}

	public int getUsedCiga() {
		return usedCiga;
	}
}
