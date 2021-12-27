package io.github.pancakeboiii.core.OrdinalAPI.DataManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSON {
    public static String GetFromURL(String URL, String RequestedData) throws org.json.simple.parser.ParseException, IOException {
    	URL url = new URL(URL);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); 
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
        JsonObject rootobj = root.getAsJsonObject(); 
        String Data = rootobj.get(RequestedData).getAsString(); 
		return Data;  
    }
    	
    }


