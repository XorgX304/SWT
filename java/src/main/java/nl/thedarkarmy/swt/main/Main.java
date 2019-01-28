package ml.thedarkarmy.swt.main;

import net.freeutils.httpserver.HTTPServer;
import ml.thedarkarmy.swt.pages.Pages;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static HTTPServer httpServer;

    public static void main(String[] args) throws Exception {
        httpServer = new HTTPServer(443);

        doSSL();

        httpServer.start();
        httpServer.getVirtualHost(null).addContexts(new Pages());
    }

    private static void doSSL() {
        try{
            IO.touch();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

    }


    private static class IO{
        public static XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());

        public static void touch() throws IOException {
            File f = new File("/sslconfig.xml");
            if(!f.exists()){
                Element root = new Element("ssl");
                Document document = new Document(root);
                Element file = new Element("file");
                file.setAttribute("location", "./key.jks");
                root.addContent(file);
                Element password = new Element("password");
                password.setText("password");
                root.addContent(password);
                f.createNewFile();
                System.out.println(f.getAbsolutePath());
                FileWriter fileWriter = new FileWriter(f);
                xmlOutputter.output(document, fileWriter);
            }
        }

    }
}
