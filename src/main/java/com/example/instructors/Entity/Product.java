package com.example.instructors.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private double price;
}
