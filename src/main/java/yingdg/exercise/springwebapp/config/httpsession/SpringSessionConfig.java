package yingdg.exercise.springwebapp.config.httpsession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by yingdg on 2017/9/4 0004.
 */
@Configuration
// 开启redis共享session
@EnableRedisHttpSession
public class SpringSessionConfig {
    /*
    Http Session数据在Redis中是以Hash结构存储的
     */
    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("localhost");
        connectionFactory.setPort(6379);
        connectionFactory.setDatabase(15);

        return connectionFactory;
    }
}
