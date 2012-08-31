package net.straininfo2.grs.idloader;

import com.sun.jersey.api.client.Client;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DumpTest {

    /**
     * Constructs a loader and downloads all the mappings to disk, to have a
     * dataset to test with.
     *
     * Also convenient if you don't want to bother with a database really.
     *
     * @param args command line arguments (ignored)
     * @throws XMLStreamException
     */
    public static void main(String[] args) throws XMLStreamException {
        Loader loader = new Loader();
        loader.setXmlParser(new EutilsXmlParser());
        Client client = Client.create();
        Map<Integer, List<Mapping>> mappings = loader.createMapping(
                loader.downLoadIds(loader.createEutilsSearchResource(client)),
                loader.createEutilsLinkResource(client)
        );
        // save this to file
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("mappings.obj"));
            o.writeObject(mappings);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("FATAL");
        }
    }

    @Test
    public void testSerializeMapping() throws IOException, ClassNotFoundException {
        Mapping m = new Mapping("http://blah", "something", "link name", new Category("blah"), new Provider("straininfo", "straininfo", 1, "http://www.straininfo.net/"));
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(m);
        oo.close();
        ObjectInputStream ii = new ObjectInputStream(new ByteArrayInputStream(bo.toByteArray()));
        Mapping m2 = (Mapping)ii.readObject();
        ii.close();
        assertTrue(m.equals(m2));
    }

}
