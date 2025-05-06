package net.joshuabrandes.soundtechwebui.boundary.handler;

import lombok.RequiredArgsConstructor;
import net.joshuabrandes.soundtechwebui.boundary.Constants;
import net.joshuabrandes.soundtechwebui.boundary.model.ChannelRoutingsDTO;
import net.joshuabrandes.soundtechwebui.control.ChannelRoutingService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChannelRoutingHandler {

    private final ChannelRoutingService channelRoutingService;

    public Mono<ServerResponse> saveChannelRoutings(ServerRequest request) {
        var channelRoutingsDTO = request.bodyToMono(ChannelRoutingsDTO.class);
        return channelRoutingService.saveChannelRoutings(channelRoutingsDTO)
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

    public Mono<ServerResponse> updateChannelRoutings(ServerRequest serverRequest) {
        var channelRoutingsID = serverRequest.pathVariable(Constants.CHANNEL_ROUTING_ID_PARAM);
        var channelRoutingsDTO = serverRequest.bodyToMono(ChannelRoutingsDTO.class);
        return channelRoutingService.updateChannelRoutings(channelRoutingsID, channelRoutingsDTO)
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

    public Mono<ServerResponse> deleteChannelRoutings(ServerRequest serverRequest) {
        var channelRoutingsID = serverRequest.pathVariable(Constants.CHANNEL_ROUTING_ID_PARAM);
        return channelRoutingService.deleteChannelRoutings(UUID.fromString(channelRoutingsID))
                .then(Mono.defer(() -> ServerResponse.ok().build()));
    }

    public Mono<ServerResponse> getChannelRoutings(ServerRequest serverRequest) {
        var channelRoutingsID = serverRequest.pathVariable(Constants.CHANNEL_ROUTING_ID_PARAM);
        return channelRoutingService.getChannelRoutingsByID(UUID.fromString(channelRoutingsID))
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }
}
