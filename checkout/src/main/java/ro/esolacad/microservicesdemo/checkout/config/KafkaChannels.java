package ro.esolacad.microservicesdemo.checkout.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaChannels {

    @Output
    MessageChannel stockChannelV2();

    @Output
    MessageChannel orderChannelV2();

    @Input
    SubscribableChannel paymentChannel();
}
