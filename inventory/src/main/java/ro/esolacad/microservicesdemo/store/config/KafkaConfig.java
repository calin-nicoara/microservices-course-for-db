package ro.esolacad.microservicesdemo.store.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableBinding(KafkaChannels.class)
@Profile("kafka")
public class KafkaConfig {
}
