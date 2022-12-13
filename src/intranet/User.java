package intranet;

import java.util.Vector;

public interface User {
	public boolean authenticate();
	public void writeCommentInNews(String text, News news);
	public Vector<News> viewNews();
}
