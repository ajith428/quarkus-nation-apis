package org.garrsolutions.service;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.District;
import org.garrsolutions.repository.DistrictRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public Uni<List<District>> getDistricts() {
        return districtRepository.listAll();
    }
}
