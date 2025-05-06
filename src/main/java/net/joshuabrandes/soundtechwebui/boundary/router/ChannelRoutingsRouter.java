package net.joshuabrandes.soundtechwebui.boundary.router;

import lombok.RequiredArgsConstructor;
import net.joshuabrandes.soundtechwebui.boundary.Constants;
import net.joshuabrandes.soundtechwebui.boundary.handler.ChannelRoutingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class ChannelRoutingsRouter {

    private final ChannelRoutingHandler handler;

    @Bean
    RouterFunction<ServerResponse> saveChannelRoutings() {
        return route(POST(Constants.CHANNEL_ROUTING_URI), handler::saveChannelRoutings);
    }

    @Bean
    RouterFunction<ServerResponse> updateChannelRoutings() {
        return route(PUT(Constants.CHANNEL_ROUTING_URI_WITH_PARAM), handler::updateChannelRoutings);
    }

    @Bean
    RouterFunction<ServerResponse> deleteChannelRoutings() {
        return route(POST(Constants.CHANNEL_ROUTING_URI_WITH_PARAM), handler::deleteChannelRoutings);
    }

    @Bean
    RouterFunction<ServerResponse> getChannelRoutings() {
        return route(POST(Constants.CHANNEL_ROUTING_URI_WITH_PARAM), handler::getChannelRoutings);
    }
}
