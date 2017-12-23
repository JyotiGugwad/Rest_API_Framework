package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// 1 Get Method
	
	public void get(String url) throws ClientProtocolException, IOException{
    
	CloseableHttpClient httpClient= HttpClients.createDefault();
	HttpGet httppget = new HttpGet(url); //http get request 
	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httppget);	//hit the get URL
	int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println("Status Code--->" + statuscode);
	
	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	
	JSONObject responseJson = new JSONObject(responseString);
	System.out.println("response Json from API --->" + responseJson);
	
	Header[] headersArray =closeableHttpResponse.getAllHeaders();
	
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	
	for(Header header : headersArray){
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Header Array--->" + allHeaders);
	}
}
