package nl.thedarkarmy.swt.main;

import net.freeutils.httpserver.HTTPServer;

public class Main {

    private static HTTPServer httpServer;

    public static void main(String[] args) throws Exception{
        httpServer = new HTTPServer(443);
        httpServer.start();
    }

}
