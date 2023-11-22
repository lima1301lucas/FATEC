package com.esiii.backendjogodaonca.configs;

import com.esiii.backendjogodaonca.entities.redis.Partida;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class redisConfiguration {
    @Bean
    public RedisTemplate<String, Partida> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Partida> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
