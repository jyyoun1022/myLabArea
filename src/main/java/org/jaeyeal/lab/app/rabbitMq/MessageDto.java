package org.jaeyeal.lab.app.rabbitMq;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageDto {

    private String title;
    private String message;

    @Builder
    public MessageDto(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
