package View;

import Model.News;

public class NewsView {
	public static void printNews() {
		if (News.news.size() == 0) {
			System.out.println("Empty news");
		}
		for (News news: News.news) {
			System.out.println(news);
		}
	}
}
