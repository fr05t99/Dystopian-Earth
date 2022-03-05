package com.earth.dystopia.guitars.repository;

import com.earth.dystopia.guitars.enums.Builder;
import com.earth.dystopia.guitars.enums.Type;
import com.earth.dystopia.guitars.enums.Wood;
import com.earth.dystopia.guitars.pojo.Guitar;
import com.earth.dystopia.guitars.pojo.GuitarSpec;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuitarRepository {

    List<Guitar> guitarList;

    public GuitarRepository() {
        guitarList = new ArrayList<>();
        GuitarSpec guitarSpec1 = new GuitarSpec(Builder.GIBSON, "model1", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
        Guitar guitar1 = new Guitar("1", 23.75, guitarSpec1);
        guitarList.add(guitar1);

        GuitarSpec guitarSpec2 = new GuitarSpec(Builder.GIBSON, "model2", Type.ELECTRIC, Wood.ADIRONDACK, Wood.ALDER);
        Guitar guitar2 = new Guitar("2", 23.45, guitarSpec2);
        guitarList.add(guitar2);
    }

    public void addGuitar(@NonNull final Guitar guitar) {
        guitarList.add(guitar);
    }

    public List<Guitar> fetchAllGuitars() {
        return guitarList;
    }
}
