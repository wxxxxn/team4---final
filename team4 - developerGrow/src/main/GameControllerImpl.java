package main;

import java.util.Timer;
import java.util.TimerTask;

import database.controllDB.InsertDB;
import database.controllDB.SelectDB;
import database.controllDB.UpdateDB;
import database.dblist.Rank;
import database.dblist.UserInfo;
import main.project.ProjectEventImpl;

public class GameControllerImpl implements GameController {

	private MainFrame mainFrame;
	private UpdateDB updateDB = new UpdateDB();;

	public GameControllerImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	private int minutes = 0;

	@Override
	public void timeController() {

		Timer currentTime = new Timer();
		currentTime.scheduleAtFixedRate(timerTask, 250, 250);
	}

	private TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			if (minutes == 1440) {
				minutes = 0;
				updateDate();
				updateTime(minutes);
			} else {
				minutes++;
				updateTime(minutes);
			}

			if (((minutes % 60) % 10) == 0) {
				saveUserInfoData();
				saveUserProjcet();
				saveRanking();
			}
			checkProject();
		}
	};

	private void updateTime(int minutes) {

		mainFrame.getHourlbl().setText(String.format("%02d", minutes / 60));
		mainFrame.getMinutelbl().setText(String.format("%02d", minutes % 60));
	}

	private void updateDate() {

		int day = 0;

		day++;
		mainFrame.getDatelbl().setText(String.format("%02d", day) + "일차");
	}

	@Override
	public void readyGame(int userId) {
		mainFrame.setUserId(userId);
		SelectDB selectDB = new SelectDB();
		InsertDB insertDB = new InsertDB();

		mainFrame.setUserList(selectDB.selectUser(userId));
		mainFrame.setUserInfoList(selectDB.selectUserinfo(userId));
		mainFrame.setUserInfo(selectDB.searchNowGame(mainFrame.getUserInfoList()));
		if (mainFrame.getUserInfo() == null) {
			insertDB.insertUserInfo(userId);
			mainFrame.setUserInfoList(selectDB.selectUserinfo(userId));
			mainFrame.setUserInfo(selectDB.searchNowGame(mainFrame.getUserInfoList()));
		}

		int infoId = mainFrame.getUserInfo().getInfoId();
		mainFrame.setInfoId(infoId);
		mainFrame.setSkillList(selectDB.selectSkillList());
		mainFrame.setUserSkillList(selectDB.selectUserSkill(userId, infoId));
		if (mainFrame.getUserSkillList().size() == 0) {
			insertDB.insertUserSkill(userId, infoId);
			mainFrame.setUserSkillList(selectDB.selectUserSkill(userId, infoId));
		}

		mainFrame.setProjectList(selectDB.selectProject());
		mainFrame.setUserProjectList(selectDB.selectUserProject(userId, infoId));
		if (mainFrame.getUserProjectList().size() == 0) {
			insertDB.insertUserProject(userId, infoId);
			mainFrame.setUserProjectList(selectDB.selectUserProject(userId, infoId));
		}

		mainFrame.setUserRankList(selectDB.selectRank());
		if (mainFrame.getUserRankList().size() == 0) {
			insertDB.insertUserRank(userId, infoId, scoreCalculator(),
					mainFrame.getUserList().get(0).getUserNickname());
			mainFrame.setUserRankList(selectDB.selectRank());
		}

		mainFrame.setCigaLogList(selectDB.selectCigaLog(userId, infoId));
	}

	@Override
	public void applyDB() {

		UserInfo userInfo = mainFrame.getUserInfo();

		System.out.println(userInfo);

		try {
			mainFrame.getDatelbl().setText(String.format("%02d", userInfo.getDate()) + "일차");
			minutes = userInfo.getTime();
			updateTime(minutes);
			mainFrame.getLevellbl().setText(String.valueOf(userInfo.getLevel()));
			mainFrame.getExpbar().setValue(userInfo.getExp());
			mainFrame.getHpbar().setValue(userInfo.getHp());
			mainFrame.getHealthbar().setValue(userInfo.getHealth());
			mainFrame.getStressbar().setValue(userInfo.getStress());
			mainFrame.getNumOfcigalbl().setText(String.valueOf(userInfo.getCiga()));
			mainFrame.setCiga(userInfo.getCiga());
			mainFrame.setUsedCiga(userInfo.getUsedCiga());
			mainFrame.setUserId(userInfo.getUserId());
			applyProject();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveUserInfoData() {
		String strDate = mainFrame.getDatelbl().getText();
		int date = Integer.parseInt(strDate.substring(0, 2));
		int time = minutes;
		int level = Integer.parseInt(mainFrame.getLevellbl().getText());
		int exp = mainFrame.getExpbar().getValue();
		int hp = mainFrame.getHpbar().getValue();
		int health = mainFrame.getHealthbar().getValue();
		int stress = mainFrame.getStressbar().getValue();
		int ciga = mainFrame.getCiga();
		int usedCiga = mainFrame.getUsedCiga();
		boolean gameover = mainFrame.getUserInfo().isGameover();

		UserInfo userInfo = new UserInfo(mainFrame.getInfoId(), date, time, level, exp, hp, health, stress, ciga,
				usedCiga, gameover, mainFrame.getUserId());

		updateDB.updateUserInfo(userInfo);
	}

	public int getMinutes() {
		return minutes;
	}

	private void applyProject() {
		ProjectEventImpl projectEventImpl = new ProjectEventImpl(mainFrame);
		int searchProject = projectEventImpl.searchNowProject(mainFrame.getUserProjectList());
		if (searchProject != -1) {
			int index = mainFrame.getUserProjectList().get(searchProject).getProjectId() - 1;
			String projectName = mainFrame.getProjectList().get(index).getProjectName();
			int projectHour = mainFrame.getUserProjectList().get(searchProject).getLastHour();
			int projcetMin = mainFrame.getUserProjectList().get(searchProject).getLastMin();
			int time = mainFrame.getProjectList().get(index).getTime();
			mainFrame.getNowProjectlbl().setText(projectName);
			mainFrame.getProjectHour().setText(String.valueOf(projectHour));
			mainFrame.getProjectMinute().setText(String.valueOf(projcetMin));
			projectEventImpl.projectTimeControll(time);
		}
	}

	private void saveUserProjcet() {

		int searchProject = mainFrame.getProjectEventImpl().searchNowProject(mainFrame.getUserProjectList());
		if (searchProject != -1) {
			mainFrame.setNowProjectId(searchProject);
			mainFrame.getUserProjectList().get(searchProject)
					.setLastHour(Integer.valueOf(mainFrame.getProjectHour().getText()));
			mainFrame.getUserProjectList().get(searchProject)
					.setLastMin(Integer.valueOf(mainFrame.getProjectMinute().getText()));
		}
		updateDB.updateUserProject(mainFrame.getUserProjectList());
	}

	private void checkProject() {
		if (mainFrame.getNowRatinglbl().getText().equals("완료")) {
			int index = mainFrame.getNowProjectId();
			mainFrame.getUserProjectList().get(index).setComplete(true);
			mainFrame.getNowRatinglbl().setText("완료!");
			expProgressBar(mainFrame.getProjectList().get(index).getRewardExp());
			mainFrame.revalidate();
			mainFrame.repaint();
		}
	}

	private void saveRanking() {

		Rank userRank = new Rank(mainFrame.getUserList().get(0).getUserNickname(), scoreCalculator(),
				mainFrame.getUserInfo().getInfoId(), mainFrame.getUserInfo().getUserId());
		updateDB.updateRanking(userRank);
		System.out.println(userRank);
	}

	private int scoreCalculator() {

		int usedCiga = mainFrame.getUserInfo().getUsedCiga();
		int level = mainFrame.getUserInfo().getLevel();

		int score = (usedCiga * 50) + (level * 200);

		return score;
	}

	public void expProgressBar(int addExp) {
		int levelExp = mainFrame.getUserInfo().getLevel() * 100;
		int charExp = mainFrame.getExpbar().getValue();
		int input = (int) (charExp + (((double) addExp / (double) levelExp) * 100));
		if (input >= 100) {
			int level = Integer.valueOf(mainFrame.getLevellbl().getText());
			mainFrame.getLevellbl().setText(String.valueOf(level + 1));
			mainFrame.getUserInfo().setLevel(level + 1);
			double a = ((double) level / (double) (level + 1));
			input = (int) ((input - 100) * a);
			mainFrame.getExpbar().setValue(input);
		} else {
			mainFrame.getExpbar().setValue(input);
		}
	}
}
