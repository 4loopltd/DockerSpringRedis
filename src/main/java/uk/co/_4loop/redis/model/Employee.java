package uk.co._4loop.redis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Employee")
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    private String id;
    private String department;
    private String name;
    private String email;

}
