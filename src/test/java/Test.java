import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
//		
		Document htmlDoc = Jsoup.connect("http://gxrb.gxnews.com.cn/html/2016-06/24/content_1280068.htm")
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
//		
//		
		String ss=htmlDoc.select("font[color='#05006C']").text();
//		
		System.out.println(ss);
		
//		System.out.println(send("http://www.cqrb.cn/html/cqrb/2016-07/18/001/content_137771.htm"));
//		
//		String time="2016-06/24";
//		String url="http://hbrb.hebnews.cn/html/%yyyy-MM/dd%/content_109761.htm";
//		
//		Pattern pattern=Pattern.compile("%(\\S*)%");
//		
//		Matcher matcher=pattern.matcher(url);
//		
//		if(matcher.find(1)){
//			String tmp=matcher.group(1);
//			SimpleDateFormat simpleDateFormat=new SimpleDateFormat(tmp);
//			System.out.println(url.replaceAll("%(\\S*)%", simpleDateFormat.format(Calendar.getInstance().getTime())));
//		}
//	
//		String result=send(url);
//		
//		System.out.println(result);
//		
//		Matcher matcher;
//		Pattern mapPattern = Pattern.compile("<\\s*?[mM][aA][pP][\\s\\S]*?>([\\s\\S]*?)</\\s*?[mM][aA][pP]\\s*?>");
//		Pattern pattern = Pattern.compile("<\\s*?[aA][rR][eE][aA]\\s[\\s\\S]*?href=\"([\\s\\S]*?)\">?");
//		matcher=mapPattern.matcher(result);
//		if(matcher.find()){
//			String map=matcher.group(1);
//			matcher=pattern.matcher(map);
//			while(matcher.find()){
//				String tmp=url.substring(0,url.lastIndexOf("/")+1)+matcher.group(1);
//				
//				System.out.println(tmp);
//				
//			}
//		}
		
		

		
	}
	
	static String send(String url) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			System.out.println(connection.getHeaderFields());

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	private static String getEncode(InputStream inputStream){
        String code = "gb2312";
        try {
            byte[] head = new byte[3];
            inputStream.read(head);
            if (head[0] == -17 && head[1] == -69 && head[2] == -65)
                code = "UTF-8";
            if (head[0] == -1 && head[1] == -2)
                code = "UTF-16";
            if (head[0] == -2 && head[1] == -1)
                code = "Unicode";
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return code;
    }
}
