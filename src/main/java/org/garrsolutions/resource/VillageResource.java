package org.garrsolutions.resource;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.Village;
import org.garrsolutions.service.VillageService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("village")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class VillageResource {

    private final VillageService villageService;

    public VillageResource(VillageService villageService) {
        this.villageService = villageService;
    }

    @GET
    public Uni<List<Village>> getVillages() {
        return villageService.getVillages();
    }
}
