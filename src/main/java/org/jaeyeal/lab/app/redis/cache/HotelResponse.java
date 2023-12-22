package org.jaeyeal.lab.app.redis.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class HotelResponse {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;

}
