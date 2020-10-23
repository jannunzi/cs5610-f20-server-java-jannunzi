package com.example.cs5610f20serverjavajannunzi.models;

public class Widget {
    private String id;
    private String name;
    private String type;
    private String topicId;

    public Widget(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Widget() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
