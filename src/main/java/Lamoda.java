import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lamoda {

    public static void main(String[] args) throws IOException {
        List<Book> bookList = new ArrayList<>();
        Document document = Jsoup.connect("https://www.bookvoed.ru/books?genre=26").get();

        Elements pdElements = document.select(".pD");

        pdElements.forEach(pdElement->{
            String author =pdElement.child(0).text();
            String title = pdElement.child(1).text();
            String url = pdElement.child(1).attr("href");

            bookList.add(new Book(author,title,url));

        });

        bookList.forEach(System.out::println);
        /*Elements qDelements = document.select(".qD");

        qDelements.forEach(qDelement->{
            String author = qDelement.text();

            System.out.println(author);
        });
*/

    }


}
