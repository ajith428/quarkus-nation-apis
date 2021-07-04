package org.garrsolutions.resource;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.Nation;
import org.garrsolutions.repository.NationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/nation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class NationResource {

    private final NationRepository nationRepository;

    public NationResource(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    //@Transactional
    @POST
    @Path("save")
    public Uni<Nation> saveNation(Nation nation) {
        return Panache.withTransaction(nation::persist);
//        if (nationRepository.isPersistent(nation)) {
//            System.out.println("Nation can be persisted:  " + nation);
//        }
//        return nationRepository.persist(nation);
    }

    @GET
    public Uni<List<Nation>> getNations() {
        return nationRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Nation> getNation(@PathParam("id") UUID id) {
        return nationRepository.findById(id);
    }
}