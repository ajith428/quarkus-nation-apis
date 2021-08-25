package org.garrsolutions.resource;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.Nation;
import org.garrsolutions.service.NationService;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("nation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class NationResource {

    private final NationService nationService;

    public NationResource(NationService nationService) {
        this.nationService = nationService;
    }

    @Transactional
    @POST
    public Uni<Nation> saveNation(Nation nation) {
        return nationService.saveNation(nation);
    }

    @Transactional
    @GET
    public Uni<List<Nation>> getNations() {
        return nationService.getNations();
    }

    @Transactional
    @GET
    @Path("{id}")
    public Uni<Nation> getNation(@PathParam("id") UUID nationId) {
        return nationService.getNation(nationId);
    }
}