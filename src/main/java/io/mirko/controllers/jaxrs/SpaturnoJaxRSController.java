package io.mirko.controllers.jaxrs;

import io.mirko.controllers.vo.SpaturnoVO;
import io.mirko.model.Spaturno;
import io.mirko.services.SpaturnoService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Path("/test")
public class SpaturnoJaxRSController {
    @Inject
    @SuppressWarnings("unused")
    private SpaturnoService spaturnoService;

    @GET
    @Path("/spaturni")
    @Produces("application/json")
    public Collection<SpaturnoVO> getAllSpaturni() {
        final Collection<SpaturnoVO> spaturni = new ArrayList<>();
        spaturnoService.findAll().forEach(d -> spaturni.add(new SpaturnoVO(d.getName(), d.getSurname(), d.getAge(), d.getUuid())));
        return spaturni;
    }

    @GET
    @Path("/spaturni/{id}")
    @Produces("application/json")
    public SpaturnoVO getSpaturno(@PathParam("id") @NotNull String id) {
        final Spaturno spaturno = spaturnoService.findById(id);
        if (spaturno == null) {
            throw new NotFoundException();
        }
        return new SpaturnoVO(spaturno.getName(), spaturno.getSurname(), spaturno.getAge(), spaturno.getUuid());
    }

    @POST
    @Path("/spaturni")
    @Produces("application/json")
    public SpaturnoVO saveNew(@Valid SpaturnoVO spaturno) {
        spaturno.setId(spaturnoService.saveNew(spaturno.getName(), spaturno.getSurname(), spaturno.getAge()));
        return spaturno;
    }

    @PUT
    @Path("/spaturni")
    @Produces("application/json")
    public SpaturnoVO updateExisting(SpaturnoVO spaturno) {
        if (!spaturnoService.updateSpaturno(spaturno.getId(), spaturno.getName(), spaturno.getSurname(), spaturno.getAge())) {
            throw new NotFoundException();
        }
        return spaturno;
    }
}