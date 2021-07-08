package org.garrsolutions.resource;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.District;
import org.garrsolutions.service.DistrictService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("district")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class DistrictResource {

    private final DistrictService districtService;

    public DistrictResource(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GET
    public Uni<List<District>> getDistricts() {
        return districtService.getDistricts();
    }
}
