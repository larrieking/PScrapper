/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crownexponent.page;

import com.crownexponent.scraper.model.PageItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ISSAH OJIVO
 */
public class Page {

    private static final Logger LOG = Logger.getLogger(Page.class.getName());

    Document doc;

    public void connect(String url) {
        try {

            doc = Jsoup.parse(new ScrapePage().readURL(url));

        } catch (IOException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PageItem> readPage(int pageNo, String category, String url) {
        StringBuilder sb = new StringBuilder(url);
        if (pageNo > 0 && pageNo != 1) {
            sb.append(category).append("/page/").append(Integer.toString(pageNo)).append("/");

        } else if (pageNo == 1) {

            sb.append(category).append("/");
        } else {
            System.out.println("Finished");
            System.exit(0);
        }
        //System.out.println(sb.toString());
        connect(sb.toString());

        List<PageItem> pageItems = new ArrayList<>();
        Elements posts = doc.getElementsByClass("items col-sm-12");

        for (Element post : posts) {
            PageItem pageItem = new PageItem();
            String s = post.getElementsByClass("seg-image b-lazy").first().attr("data-src");

            pageItem.setImage(s);
            pageItem.setTitle(post.select("div.col-sm-8").first().select("h2.seg-title").text());
            pageItem.setSummary(post.select("div.seg-summary").first().text());
            pageItem.setTime(post.select("span.pull-right").last().text());
            pageItem.setCategory(category);
            pageItems.add(0, pageItem);
        }

        return pageItems;
    }

    /*public String getImage(String url){
            String status = "";
            try{
                Pattern pattern = Pattern.compile("(\".*?)\"\\)");
                Matcher matcher = pattern.matcher(url);
                if(matcher.find()){
                    status = matcher.group(1);
                }
            }catch(Exception e){
                LOG.log(Level.SEVERE, "Error");
                status = "";
            }
            return status;
        }
     */
}
