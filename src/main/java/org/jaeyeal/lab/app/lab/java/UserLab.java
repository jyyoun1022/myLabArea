package org.jaeyeal.lab.app.lab.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLab {
    private int id;
    private String name;
    private String emailAddress;
    private boolean verified;
    @Builder.Default
    private List<Integer>  friendUserIds = new ArrayList<>();
}
