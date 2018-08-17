package com.crownexponent.page;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author whsys7
 */
public class NewsDetails {

    public String pageDetail(String url) throws IOException{
        StringBuilder sb =  new StringBuilder();
        Document doc = Jsoup.parse(new ScrapePage().readURL(url));
        Element item = doc.getElementsByClass("entry-content").first();
        Elements p = item.getElementsByTag("p");
        for(Element i : p){
            sb.append(i.text());
        }
        return sb.toString();
        
    }
    
    public static void main(String[]arg){
        try {
         System.out.println(new NewsDetails().pageDetail("https://punchng.com/resolve-lautech-crisis-asuu-tells-ajimobi-aregbesola/"));
        } catch (IOException ex) {
            Logger.getLogger(NewsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
