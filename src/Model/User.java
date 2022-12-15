package Model;

import java.util.Vector;

public interface User {
	boolean authenticate();
	void writeCommentInNews(String text, News news);
	Vector<News> viewNews();
}
