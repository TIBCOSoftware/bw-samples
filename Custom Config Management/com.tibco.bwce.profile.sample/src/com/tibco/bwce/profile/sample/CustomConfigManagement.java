package com.tibco.bwce.profile.sample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.tibco.bwce.profile.resolver.ProfileResolverHelper;
import com.tibco.bwce.profile.resolver.Type;
import com.tibco.bwce.profile.resolver.Value;

public class CustomConfigManagement {
	public CustomConfigManagement() {}
		  
		  public static void main(String[] args) throws Exception {
			  String message = "Message from config server";
			  Map<String, Value> tokenMap = new HashMap<String, Value>();
			  tokenMap.put("Message", new Value(message, Type.APPCONFIG));
			  Map<String, Value> tmpMap = new HashMap<String, Value>();
			  try
			  {
		      Iterator<String> il = ProfileResolverHelper.getKeysForConfig().iterator();
		      Iterator<Map.Entry<String, Value>> im; 
		      for (;il.hasNext();im.hasNext())
		      {
		        String s = (String)il.next();
		        im = tokenMap.entrySet().iterator();
		        Map.Entry<String, Value> entry = (Map.Entry<String, Value>)im.next();
		        if (((String)entry.getKey()).equals(s)) {
		          tmpMap.put((String)entry.getKey(), (Value)entry.getValue());
		          System.out.println(tmpMap);
		        }
		      }
		    }
		    catch (IOException e)
		    {
		      System.err.println("Unable to fetch values from config server due to error: " + 
		        e.getMessage());
		    }
		    ProfileResolverHelper.replaceProfileValues(tmpMap);
		  }
}
