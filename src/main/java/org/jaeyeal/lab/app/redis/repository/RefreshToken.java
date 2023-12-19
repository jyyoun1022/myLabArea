package org.jaeyeal.lab.app.redis.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash(value = "refresh_token") // 설정한 값을 Redis 의 key 값 Prefix로 사용
public class RefreshToken {

    @Id // key 가 되며 refresh_token:{id} 위치에 auto-increment 된다.
    private String authId;

    @Indexed // 갑승로 검색할 시에 추가한다.
    private String token;

    private String role;

    @TimeToLive // 만료시간을 초(sec) 단위로 설정
    private long ttl;

    public RefreshToken update(String token, long ttl) {
        this.token = token;
        this.ttl = ttl;
        return this;
    }
}
