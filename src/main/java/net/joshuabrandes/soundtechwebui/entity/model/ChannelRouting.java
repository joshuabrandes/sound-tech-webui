package net.joshuabrandes.soundtechwebui.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("channel-routing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRouting {

    @Id
    private UUID id;
    
    private String channelName;
    private String mixerChannel;
    private String stageChannel;
    private Boolean phantomPowered;

    public ChannelRouting(UUID id, String channelName, String mixerChannel, String stageChannel) {
        this.id = id;
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = null;
    }
    
    public ChannelRouting(String channelName, String mixerChannel, String stageChannel) {
        this.id = UUID.randomUUID();
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = null;
    }
    
    public ChannelRouting(String channelName, String mixerChannel, String stageChannel, Boolean phantomPowered) {
        this.id = UUID.randomUUID();
        this.channelName = channelName;
        this.mixerChannel = mixerChannel;
        this.stageChannel = stageChannel;
        this.phantomPowered = phantomPowered;
    }
}