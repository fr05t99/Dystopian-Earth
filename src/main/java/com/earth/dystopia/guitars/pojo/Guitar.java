package com.earth.dystopia.guitars.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Guitar {
    String serialNumber;
    Double price;
    GuitarSpec spec;
}
