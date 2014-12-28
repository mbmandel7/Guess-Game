package guessGame.server;

import guessGame.tasks.TaskFactory;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HttpHandler extends AbstractHandler {
	private TaskFactory tf = new TaskFactory();

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		boolean create = "true".equals(request.getParameter("create"));

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		response.setContentType("application/octet-stream");
		response.setStatus(HttpServletResponse.SC_OK);

		ObjectOutputStream out = new ObjectOutputStream(
				response.getOutputStream());

		out.writeObject(tf.getTask());
		out.flush();
		System.out.println("Handled");

		baseRequest.setHandled(true);

	}

}
