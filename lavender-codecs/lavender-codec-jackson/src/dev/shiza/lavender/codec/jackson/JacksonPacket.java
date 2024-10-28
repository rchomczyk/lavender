package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import dev.shiza.lavender.codec.Packet;

@JsonTypeInfo(use = Id.CLASS, property = "type")
public abstract class JacksonPacket extends Packet {}
