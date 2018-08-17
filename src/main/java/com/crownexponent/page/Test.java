/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crownexponent.page;

import com.crownexponent.scraper.model.PageItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ISSAH OJIVO
 */

public class Test {
    static List<PageItem> items = new ArrayList<>();
    public static void main(String[]args){
        List<PageItem> p;
        int counter = 959;
        do{
      p= new Page().readPage(counter, "news", "https://punchng.com/topics/");
      counter -=1;
       items.addAll(p);
      
    }
         
      while(counter>958);
        
        Iterator<PageItem>iterator = items.iterator();
      while(iterator.hasNext()){
          System.out.println(iterator.next().getSummary());
      }
    }
}
