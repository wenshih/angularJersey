package com.stock.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.stock.implement.StockService;

@Path("/stockJersey")
public class StockJersey {
	@GET
	@Path("/getStock")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStock(@QueryParam(value="stock_id") String stock_id) throws JSONException{
		System.out.println(stock_id);
		JSONObject json = new JSONObject();
		json.put("stock_id", stock_id);
		
		try {
			StockService stock = new StockService();
			List<String> key = null;
			key = stock.stockDataJersey(json);
			System.out.println(key);
			
			List<String> detail = new ArrayList<String>();
			List<String> title = new ArrayList<String>();
			for(int i=0; i<key.size(); i++){
				if(i%2 == 0 && i != key.size()){
					title.add(key.get(i));
				}else{
					detail.add(key.get(i));
				}
			}
			System.out.println("detail: " +detail);
			System.out.println("title: " +title);
			return new JSONObject().put("detail", detail).put("title", title).toString();//json.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONObject().put("statuscode", 500).toString();
		}
		
		
	}
}
