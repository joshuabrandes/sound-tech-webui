package net.joshuabrandes.soundtechwebui.control.mapper;

import net.joshuabrandes.soundtechwebui.boundary.model.ChannelRoutingDTO;
import net.joshuabrandes.soundtechwebui.entity.model.ChannelRouting;
import org.mapstruct.Mapper;

@Mapper
public interface ChannelRoutingMapper {

    ChannelRouting mapToEntity(ChannelRoutingDTO source);
    ChannelRoutingDTO mapToDTO(ChannelRouting source);
}
