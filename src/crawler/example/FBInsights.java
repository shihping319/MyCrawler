package crawler.example;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.abola.crawler.CrawlerPack;


/**
 * 資料探索練習 Facebook Graph Api Search 
 * 
 * 重點
 * 1. 利用Graph Api調整出需要的資料
 * 2. 取得一組Access Token (long term token)
 * 3. 試著用你會的方式，先行探索資料
 * 
 * @author Abola Lee
 *
 */
public class FBInsights {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑
		// >>>Fill here<<< 
		String uri = 
				"https://graph.facebook.com/v2.0"
				+ "/search?q=%E9%9D%A0%E5%8C%97&type=page&fields=id,name,likes,talking_about_count"  // 補完
				+ "&access_token=CAAAAJG3ZAXBMBADAEgBywf5zgva0b3ZCRNjZBsoHZB3e5FcPxRyTZAY6AtbY4NXnH1g1mNT5Im6FbzoFGDEbT4QHhKLhCUF6I51Qy18Nwb8D8IBLUUfLMvHM0U3VAFAhKZBOqn7QZCdUZAHy59ymwaGMXinXJktNc1XukHKzVJMmZCrtrF768JQzk";  

		// Jsoup select 後回傳的是  Elements 物件
		System.out.println(uri);
		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,按讚數,名稱,討論人數\n";
		
		// 遂筆處理
		for( Element data: elems ){
			
//			{
//			      "id": "1632027893700148",
//			      "name": "靠北工程師",
//			      "likes": 112673,
//			      "talking_about_count": 79477
//			    }
			
			// 如何取出資料??
			// >>>Fill here<<< 
			String id =  data.select("id").text();
			String likes = data.select("likes").text();
			String name = data.select("name").text();
			String talking_about_count = data.select("talking_about_count").text();
			
			output += id+","+likes+",\""+name+"\","+talking_about_count+"\n";
		}
		
		System.out.println( output );
	} 
}
