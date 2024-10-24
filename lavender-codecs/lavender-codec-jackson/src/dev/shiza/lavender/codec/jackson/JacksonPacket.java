package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import dev.shiza.lavender.codec.Packet;
import java.io.Serializable;

@JsonTypeInfo(use = Id.CLASS, property = "type")
public abstract class JacksonPacket implements Packet, Serializable {}
