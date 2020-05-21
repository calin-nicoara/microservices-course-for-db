package ro.esolacad.microservicesdemo.acounting.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("kafka")
@Configuration
@EnableBinding(KafkaChannels.class)
public class KafkaConfig {
}
