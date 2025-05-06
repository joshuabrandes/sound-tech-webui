package net.joshuabrandes.soundtechwebui.boundary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRoutingsDTO {

    private UUID id;

    private String routingName;
    private List<ChannelRoutingDTO> channelRoutings;
    private String description;
}
