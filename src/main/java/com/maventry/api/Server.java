package com.maventry.api;

import static spark.Spark.*;

import spark.Spark;
import spark.Filter;
import spark.Request;
import spark.Response;

public class Server {
	public Server (int port, int minThreads, int maxThreads, int timeOutMilis) {
		//apply configuration then start the server
		Spark.port(port);
		threadPool(maxThreads,minThreads,timeOutMilis);
		//start routing server path
		Spark.get("/test", (req,res) -> "you got it");
		//apply filter for response header json
		apply();
	}
	
	//apply function for header response using json
	public final static void apply() {
		Filter filter = new Filter() {
			@Override
			public void handle(Request request, Response response) throws Exception{
				response.type("application/json");
			}
		};
		Spark.after(filter);
	}
}
