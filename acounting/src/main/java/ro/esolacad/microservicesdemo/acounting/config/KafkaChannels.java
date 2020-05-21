package ro.esolacad.microservicesdemo.acounting.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@Profile("kafka")
public interface KafkaChannels {

    @Input
    SubscribableChannel orderChannel();

    @Output
    MessageChannel paymentChannel();

    @Output
    MessageChannel emailOutChannel();

    @Input
    SubscribableChannel emailInChannel();
}
