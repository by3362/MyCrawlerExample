package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class Pttexam {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481394359.A.855.html";

		Document jsoup=CrawlerPack.start().addCookie("over18","1").getFromHtml(uri);

				//CrawlerPack.start()
				// 參數設定
			    //.addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    //.getFromHtml(uri);
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
			    //.select(".css .selector "
				//.select(".push span.hl")//所有class擁有hl的
				//.select(".push span[class^=hl]")//都是推
				//.select(".push span:contains(推)")//所有有"推"這個字的


				for(Element elem : jsoup.select("#main-content *")){
					//System.out.println(elem.toString());
					elem.remove();
		}
			System.out.println(jsoup.select("#main-content").text());//印出內文，

	}
}
