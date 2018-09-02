import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingHtml {

    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document document = Jsoup.connect("https://www.wildberries.ru/catalog/obuv/muzhskaya?pagesize=200").get();

        Elements h1Elements = document.getElementsByAttributeValue("class","dtlist-inner-brand-name");

        h1Elements.forEach(h1Element->{Element aElement = h1Element.child(0);
        String url = aElement.attr("href");
        String title = aElement.child(0).text();

        articleList.add(new Article(url,title));});

        articleList.forEach(System.out::println);


        Elements divElements = document.select(".dtlist-inner-brand");

        divElements.forEach(divElement->{
            Element strongElement = divElement.child(0);
            String brand = strongElement.text();
        });
    }


}
