package Model;

import java.io.Serializable;
import java.util.Vector;

public interface User extends Serializable {
	boolean authenticate(String login, String password);
	boolean changePassword(String oldPassword, String newPassword);
	void writeCommentInNews(String text, News news);
	Vector<News> viewNews();
	boolean doResearch();
	boolean addResearchPaper(String paper);
	boolean addResearchProject(String project);
}
