package com.earth.dystopia.guitars.service;

import com.earth.dystopia.guitars.pojo.Guitar;
import com.earth.dystopia.guitars.pojo.GuitarSpec;
import com.earth.dystopia.guitars.repository.GuitarRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuitarService {

    GuitarRepository guitarRepository;

    public GuitarService() {
        guitarRepository = new GuitarRepository();
    }

    public void addGuitar(@NonNull final Guitar guitar) {
        guitarRepository.addGuitar(guitar);
    }

    public List<Guitar> search(@NonNull final GuitarSpec searchSpec) {
        List<Guitar> guitars = guitarRepository.fetchAllGuitars();
        if (guitars == null || guitars.isEmpty()) {
            return new ArrayList<>();
        }
        List<Guitar> matches = new ArrayList<>();
        for (Guitar guitar : guitars) {
            GuitarSpec guitarSpec = guitar.getSpec();
            if (searchSpec.getType() != null && searchSpec.getType() != guitarSpec.getType()) {
                continue;
            }
            if (searchSpec.getBackWood() != null && searchSpec.getBackWood() != guitarSpec.getBackWood()) {
                continue;
            }
            if (searchSpec.getTopWood() != null && searchSpec.getTopWood() != guitarSpec.getTopWood()) {
                continue;
            }
            if (searchSpec.getModel() != null && !searchSpec.getModel().toLowerCase().equals(guitarSpec.getModel())) {
                continue;
            }
            if (searchSpec.getBuilder() != null && searchSpec.getBuilder() != guitarSpec.getBuilder()) {
                continue;
            }
            matches.add(guitar);
        }
        return matches;
    }

}
