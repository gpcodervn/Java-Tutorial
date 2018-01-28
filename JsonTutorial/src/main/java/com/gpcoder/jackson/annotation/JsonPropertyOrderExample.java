package com.gpcoder.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "id" })
public class JsonPropertyOrderExample {
    public int id;
    public String name;
}