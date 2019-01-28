package ml.thedarkarmy.swt.pages;

import net.freeutils.httpserver.HTTPServer.*;

import java.io.IOException;

public class Pages {

    @Context("/example")
    public int example(Request req, Response resp) throws IOException {
        resp.getHeaders().add("Content-Type", "text/plain");
        resp.send(200, "Hello, World!");
        //code
        return 0;
    }

}
