package com.earth.dystopia.guitars.pojo;

import com.earth.dystopia.guitars.enums.Builder;
import com.earth.dystopia.guitars.enums.Type;
import com.earth.dystopia.guitars.enums.Wood;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuitarSpec {
    Builder builder;
    String model;
    Type type;
    Wood backWood;
    Wood topWood;
}
