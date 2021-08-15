package spring.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RedisTemplateApplication implements CommandLineRunner {

	boolean enableCluster = false;

	@Autowired
	RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RedisTemplateApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hiiii");
		ValueOperations<String, Object> valueQuery = redisTemplate.opsForValue();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(valueQuery.get("7578_arc_min_ser")));
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		JedisConnectionFactory factory = null;
		if (enableCluster) {
			RedisClusterConfiguration config = new RedisClusterConfiguration();
			config.clusterNode("retaillo-redis-new.8h7pzw.clustercfg.use1.cache.amazonaws.com", 6379);
			factory = new JedisConnectionFactory(config);
		}
		else {
			factory = new JedisConnectionFactory();
			factory.setHostName("localhost");
			factory.setPort(6379);
		}
		factory.setUsePool(true);
		return factory;
	}

	@Bean
	RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
		return template;
	}

}
