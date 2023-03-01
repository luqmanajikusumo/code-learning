// rest api practice using library framework spark
// http://sparkjava.com
// as written in: 
// https://qomarullah.medium.com/belajar-java-cara-cepat-membuat-rest-api-a28241dad6ca
// but not totally copied from the source
package com.maventry.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App 
{
	public static Properties prop;
	
    public static void main( String[] args )
    {
        
        prop = new Properties();
        if(args.length>0) {
        	loadProperties(prop, args[0]);
        }
        else {
        	System.out.println("Parameter properties are empty");
        	System.exit(0);
        }
        
        //server configurations
        int port = Integer.parseInt(prop.getProperty("server.port","9001"));
        int maxThreads = Integer.parseInt(prop.getProperty("server.maxthread", "200"));
        int minThreads = Integer.parseInt(prop.getProperty("server.minthread", "30"));
        int timeOutMilis = Integer.parseInt(prop.getProperty("server.timeout", "20000"));
        
        //start server
        Server server = new Server(port,minThreads,maxThreads,timeOutMilis);
    }
    
    //load properties function
    public static void loadProperties(Properties prop, String filename) {
    	InputStream input = null;
    	try {
    		input =  new FileInputStream(filename);
    		//load a properties file
    		prop.load(input);
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		if(input!=null) {
    			try {
    				input.close();
    			}
    			catch(IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
}
