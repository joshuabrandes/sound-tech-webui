package net.joshuabrandes.soundtechwebui.control;

import lombok.RequiredArgsConstructor;
import net.joshuabrandes.soundtechwebui.boundary.model.ChannelRoutingsDTO;
import net.joshuabrandes.soundtechwebui.control.mapper.ChannelRoutingsMapper;
import net.joshuabrandes.soundtechwebui.entity.repository.ChannelRoutingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ChannelRoutingService {

    private final ChannelRoutingsMapper channelRoutingMapper;
    private final ChannelRoutingRepository channelRoutingRepository;

    public Mono<ChannelRoutingsDTO> saveChannelRoutings(Mono<ChannelRoutingsDTO> channelRoutingsDTO) {
        return channelRoutingsDTO
                .map(channelRoutingMapper::mapToEntity)
                .flatMap(channelRoutingRepository::save)
                .map(channelRoutingMapper::mapToDTO);
    }

    public Mono<ChannelRoutingsDTO> updateChannelRoutings(String channelRoutingsID, Mono<ChannelRoutingsDTO> channelRoutingsDTO) {
        return channelRoutingRepository.findChannelRoutingsById(UUID.fromString(channelRoutingsID))
                .flatMap(oldEntity -> channelRoutingsDTO
                        .map(channelRoutingMapper::mapToEntity)
                        // update the creation date with the current date from the database
                        .map(entity -> {
                            entity.setId(oldEntity.getId());
                            entity.setCreatedDate(oldEntity.getCreatedDate());
                            return entity;
                        })
                        .flatMap(channelRoutingRepository::save)
                        .map(channelRoutingMapper::mapToDTO)
                );
    }

    public Mono<Void> deleteChannelRoutings(UUID channelRoutingsID) {
        return channelRoutingRepository.deleteById(channelRoutingsID);
    }

    public Mono<ChannelRoutingsDTO> getChannelRoutingsByID(UUID channelRoutingsID) {
        return channelRoutingRepository.findChannelRoutingsById(channelRoutingsID)
                .map(channelRoutingMapper::mapToDTO);
    }
}
