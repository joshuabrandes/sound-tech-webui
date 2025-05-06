package net.joshuabrandes.soundtechwebui.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table("channel_routings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRoutings {

    @Id
    private UUID id;
    private LocalDateTime createdDate = LocalDateTime.now();

    private String routingName;
    private List<ChannelRouting> channelRoutings;
    private String description;
}