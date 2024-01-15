package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLab {
    private int id;
    private String name;
    private String emailAddress;
    private boolean verified;
}
