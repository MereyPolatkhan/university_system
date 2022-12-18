package Model;

import java.util.Vector;

public interface User {
	boolean authenticate(String login, String password);
	boolean changePassword(String oldPassword, String newPassword);
	void writeCommentInNews(String text, News news);
	Vector<News> viewNews();
}
