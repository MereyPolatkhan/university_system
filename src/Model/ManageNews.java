package Model;

import java.io.Serializable;

public interface ManageNews extends Serializable {
	boolean addNews(News news);
	boolean deleteNews(News news);
}
