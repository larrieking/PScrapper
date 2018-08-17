/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crownexponent.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author whsys7
 */
public class ScrapePage {

    
    public String readURL(String url) throws MalformedURLException, IOException{
            URL theurl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)theurl.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/4.76"); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder output = new StringBuilder();
            String count = null;
            while((count = reader.readLine())!=null){
                output.append(count);
            
        }
            reader.close();
            return output.toString();
                    
        }
}
