package com.stock;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public interface IStockService {
	
	public List<String> stockDataJersey(JSONObject jsonInput) throws JSONException, Exception;
}
