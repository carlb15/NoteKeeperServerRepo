//============================================================================
//Name        : UpdateServlet.java
//Author      : Carl Barbee
//Description : Updates the server. Is located in /updateserver.
//							The client sends all of the notes created on the phone to 
//							the server as a back-up.
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
public class UpdateServlet extends MainServlet {

	/**
	 * Displays the notes currently on the server.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// Displays the notes sent to the server.
		response.setContentType("application/json");
		response.getWriter().write(userNotes.toString());
	}

	/**
	 * Handles the POST request from the client where all the notes are sent from
	 * the client to be stored as a back-up on the server.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creates a note ID for each note.
		final String noteID = "Note ID: ";
		JSONArray newNotesArray = new JSONArray();

		// Set the new note ID and get the data from the client.
		for (int i = 0; i < request.getParameterMap().size(); i++) {
			// Adds the a new note ID 
			String newNoteID = noteID + i;
			String clientNote = request.getParameter(newNoteID);

			try {
				// Creates the JSON array.
				newNotesArray.put(new JSONObject().put(newNoteID, clientNote));
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		userNotes = newNotesArray;
	}
}