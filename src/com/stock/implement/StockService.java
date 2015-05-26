package com.stock.implement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.stock.IStockService;

public class StockService implements IStockService{

	public List<String> stockDataJersey(JSONObject jsonInput) throws JSONException, Exception {
		
		List<String> key = new ArrayList<String>();
		
		URL url;
		try {
			//爬yahoo股市
			url = new URL("http://tw.stock.yahoo.com/q/q?s=" + jsonInput.get("stock_id"));
			
			Document doc = Jsoup.parse(url, 3000);
			Elements tables = doc.select("center>table");
			
			Element  table;
			//標頭
	        table = tables.get(1).select("table").get(0);
	       
	        //內容        
	        table = tables.get(1).select("table").get(1);

	        System.out.println("--------------------------------------------------");
	        for(int i=0; i<table.getElementsByTag("th").size();i++){
	        	if(table.getElementsByTag("th").eq(i).hasAttr("align")){
		        	key.add(table.getElementsByTag("th").eq(i).text());
		        }
	        	if(table.getElementsByTag("td").eq(i).hasAttr("align") && !table.getElementsByTag("td").eq(i).hasClass("tt")){
	        		key.add(table.getElementsByTag("td").eq(i).text());
	        	}
	        }
	        System.out.println(key);
	        return key;
	        
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return key;
		
		
	}
	
	
}
