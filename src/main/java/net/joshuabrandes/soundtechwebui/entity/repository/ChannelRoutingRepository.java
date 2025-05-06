package net.joshuabrandes.soundtechwebui.entity.repository;

import net.joshuabrandes.soundtechwebui.entity.model.ChannelRoutings;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ChannelRoutingRepository extends ReactiveCrudRepository<ChannelRoutings, UUID> {

    Mono<ChannelRoutings> findChannelRoutingsById(UUID id);
}
