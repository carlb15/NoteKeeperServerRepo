package com.example.notekeeperserver;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.json.JSONArray;

/**
 * @purpose The main servlet which displays the that the server is connected.
 * 
 * @author Carl Barbee
 * @param args
 * @throws Exception
 */
@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {

	protected static JSONArray userNotes;

	public static void main(String[] args) throws Exception {
		userNotes = new JSONArray();
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setWar("war");
		context.setContextPath("/");
		server.setHandler(context);
		server.start();
		server.join();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain");
		// Respond to client that the server connected.
		response.getWriter().write("Server is connected!");
	}
}
