package Model;

public interface ManageNews {
	boolean addNews(News news);
	boolean deleteNews(News news);
	boolean editNews(News oldNews, News newNews);
}
