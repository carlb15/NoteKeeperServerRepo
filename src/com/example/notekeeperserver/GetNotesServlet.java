//============================================================================
//Name        : GetNotesServlet.java
//Author      : Carl Barbee
//Description : Gets the notes currently stored in the server. 
//============================================================================

package com.example.notekeeperserver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class GetNotesServlet extends MainServlet
{
	
	/**
	 * Handles the POST request from the client where all the notes are sent from
	 * the client to be stored as a back-up on the server.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("plain/text");
		response.getWriter().write(userNotes.toString());
	}
}
