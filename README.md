NoteKeeperServerRepo
====================
Purpose:

The NoteKeeperServer is used for storing notes created on the Android app in a JSON array. The server contains a main servlet that responds to HTTP GET requests stating that the server is connected. A servlet used for updating the server with the notes created on the android app using an HTTP POST request and sending the notes stored on the server with a HTTP Get request. The final servlet is used to retrieve the notes stored on the server using a HTTP Post request or HTTP Get request.

File Descriptions:

MainServlet: The main servlet which only responds to HTTP Get requests with "Server is connected!" in plain text. If a resource that doesn't exist is requested, then the server responds with the main servlet's response.
GetNotesServlet: Retrieves the notes currently stored on the server. The format is JSON and each of the notes is stored with a note ID in an array list of hash maps. The servlet will respond to HTTP GET and POST requests under the /getnotes resource.
UpdateServlet: Updates the server with the changes made locally on the app. The resource is /updateserver and simply creates a JSON array to store each of the notes. Each note is identified by it's note ID which is an integer value.
Program Flow:

Initially, the client makes a request to the /getnotes resource in order to get the notes currently stored on the server. The client can only use an HTTP Get or Post request for this resource. Next, updates can be made to the server using the refresh button on the app. The resource /updateserver is sent an HTTP Post request containing the list of notes on the client. The server replaces the data stored on the server with the client's list of notes.

Next Version:

Handle images sent to the server by the client for face-lock login.
Add an extra field to the JSON array for each note to allow for note reminder's by location.
