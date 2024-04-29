package com.example.instructors.Redis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/set")
    public ResponseEntity<Void> set(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam String key) {
        String value = redisService.get(key);
        return value != null ? ResponseEntity.ok(value) : ResponseEntity.notFound().build();
    }
}
