package crawler.example;

import com.github.abola.crawler.CrawlerPack;


/**
 * 簡易練習
 * 
 * 找出所有文章中按推的id
 * 
 * @author Abola Lee
 *
 */
public class PttHomework {
	
	public static void main(String[] args) {
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1459002519.A.DEC.html";
		

		System.out.println( 
			CrawlerPack.start()
			    .addCookie("over18", "1")
				.getFromHtml(uri)
				.select("span.push-tag:contains(推)~span") // 如何取得按推的id ? >>>Fill here<<< 

				.toString()
		);
	}
}
