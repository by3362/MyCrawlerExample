package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/posts?fields=id,link,message,created_time,reactions.type(HAHA).limit(0).summary(true)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAFSuHrOzztTkiZBU0muXYlJZAGF5uSbK6aWZB6ozHZBIQJz2hbAK7brwkeTSZBsYU3eel4r9TVMfRjJFXZBdFtwD11ENkLngQRnbx3XMUw0rnMZCeKmPHhNZC8QKLaqEH9UOqZCLCLKIhrstasiTohtukDwbWamqk0NmZASSKN1mhJuBKBDnUzxB0ZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,內容,發布時間,哈哈的讚數\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String message = data.select("message").text();
			String created_time = data.select("created_time").text();
			String reactions = data.select("total_count").text();

			// FIXIT
			//String reactions = "";


			output += id + "," + message + "," +created_time +"," + reactions+"\n";
		}

		System.out.println( output );
	} 
}
