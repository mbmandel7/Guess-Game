package guessGame;

import org.eclipse.jetty.client.HttpClient;

public class Connection {
	
	private HttpClient client;
	
	public Connection() throws Exception{
		client = new HttpClient();
		client.start();
	}
	
	public HttpClient getClient(){
		return client;
	}

}
