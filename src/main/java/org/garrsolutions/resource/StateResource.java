package org.garrsolutions.resource;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.State;
import org.garrsolutions.service.StateService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("state")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class StateResource {

    private final StateService stateService;

    public StateResource(StateService stateService) {
        this.stateService = stateService;
    }

    @GET
    public Uni<List<State>> getState() {
        return stateService.getStates();
    }
}
