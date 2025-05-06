package net.joshuabrandes.soundtechwebui.boundary;

public class Constants {

    private Constants() {}

    public static final String CHANNEL_ROUTING_ID_PARAM = "channelRoutingId";
    public static final String CHANNEL_ROUTING_URI = "/v1/channelRoutings";
    public static final String CHANNEL_ROUTING_URI_WITH_PARAM = CHANNEL_ROUTING_URI + "/{" + CHANNEL_ROUTING_ID_PARAM + "}";
}
