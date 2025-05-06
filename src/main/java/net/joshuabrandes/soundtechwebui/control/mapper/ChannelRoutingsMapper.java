package net.joshuabrandes.soundtechwebui.control.mapper;

import net.joshuabrandes.soundtechwebui.boundary.model.ChannelRoutingsDTO;
import net.joshuabrandes.soundtechwebui.entity.model.ChannelRoutings;
import org.mapstruct.Mapper;

@Mapper(uses = {ChannelRoutingMapper.class})
public interface ChannelRoutingsMapper {

    ChannelRoutings mapToEntity(ChannelRoutingsDTO source);
    ChannelRoutingsDTO mapToDTO(ChannelRoutings source);
}
