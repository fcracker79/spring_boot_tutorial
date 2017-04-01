package io.mirko.controllers.jaxrs;

import io.mirko.controllers.vo.Spaturno;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/test")
public class SpaturnoJaxRSController {
    private final Map<Integer, Spaturno> spaturni = new HashMap<>();
    @GET
    @Path("/spaturni")
    @Produces("application/json")
    public Collection<Spaturno> getAllSpaturni() {
        return spaturni.values();
    }

    @POST
    @Path("/spaturni")
    @Produces("application/json")
    public Spaturno saveNew(Spaturno spaturno) {

        spaturni.put(spaturno.getId(), spaturno);
        return spaturno;
    }
}