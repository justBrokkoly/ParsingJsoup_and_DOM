import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParsingBlog {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("http://www.codenuclear.com/category/java/").get();

        Elements h3Elements = document.select(".widget-title");
        h3Elements.forEach(h3Element->{
            String a = h3Element.text();
            System.out.println(a);
        });

    }
}
