package es.art83.rest.utils.listString;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import es.art83.rest.utils.HelloRest;

@Path("/resources")
public class Resource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String msg() {
        LogManager.getLogger(HelloRest.class).info("GET/ Hello");
        return ">>>Hola, desde RESTful";
    }

    @Path("/listString")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public ListStringWrapper readListString() {
        List<String> list = Arrays.asList("test", "as");
        LogManager.getLogger(HelloRest.class).info("GET/ listString" + list);
        return new ListStringWrapper(list);
    }

}
