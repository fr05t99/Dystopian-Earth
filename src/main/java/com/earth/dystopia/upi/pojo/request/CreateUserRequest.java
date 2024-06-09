package com.earth.dystopia.upi.pojo.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserRequest {
    @NonNull
    String phoneNumber;

    @NonNull
    String name;
}
