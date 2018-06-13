package xyz.siomochkin.Utills;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import xyz.siomochkin.Servlets.HelloWorld;


public class LocalServerJetty {
    public static void start() {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        ServletHolder holder = new ServletHolder(new HelloWorld());
        handler.addServlet(holder, "/users");

        server.setHandler(handler);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
