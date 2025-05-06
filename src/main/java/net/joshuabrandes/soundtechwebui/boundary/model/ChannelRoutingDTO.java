package net.joshuabrandes.soundtechwebui.boundary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRoutingDTO {

    private UUID id;

    private String channelName;
    private String mixerChannel;
    private String stageChannel;

    private Boolean phantomPowered;

    public ChannelRoutingDTO(UUID id, String channelName, String mixerChannel, String stageChannel) {
        this.id = id;
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = null;
    }

    public ChannelRoutingDTO(String channelName, String mixerChannel, String stageChannel) {
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = null;
    }

    public ChannelRoutingDTO(String channelName, String mixerChannel, String stageChannel, Boolean phantomPowered) {
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = phantomPowered;
    }
}
