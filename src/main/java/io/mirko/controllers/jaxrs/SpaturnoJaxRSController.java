package io.mirko.controllers.jaxrs;

import io.mirko.controllers.vo.SpaturnoVO;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@Path("/test")
public class SpaturnoJaxRSController {
    private static final Random RND = new Random();

    private final Map<Integer, SpaturnoVO> spaturni = new HashMap<>();

    public SpaturnoJaxRSController() {
        spaturni.put(1, new SpaturnoVO("John", "Smith", 25, 1));
    }

    @GET
    @Path("/spaturni")
    @Produces("application/json")
    public Collection<SpaturnoVO> getAllSpaturni() {
        return spaturni.values();
    }

    @GET
    @Path("/spaturni/{id}")
    @Produces("application/json")
    public SpaturnoVO getSpaturno(@PathParam("id") @NotNull int id) {
        final SpaturnoVO spaturno = spaturni.get(id);
        if (spaturno == null) {
            throw new NotFoundException();
        }
        return spaturno;
    }

    @POST
    @Path("/spaturni")
    @Produces("application/json")
    public SpaturnoVO saveNew(@Valid SpaturnoVO spaturno) {
        final int id = RND.nextInt();
        spaturno.setId(id);
        spaturni.put(spaturno.getId(), spaturno);
        return spaturno;
    }

    @PUT
    @Path("/spaturni")
    @Produces("application/json")
    public SpaturnoVO updateExisting(SpaturnoVO spaturno) {
        if (spaturni.get(spaturno.getId()) == null) {
            throw new NotFoundException();
        }
        spaturni.put(spaturno.getId(), spaturno);
        return spaturno;
    }
}