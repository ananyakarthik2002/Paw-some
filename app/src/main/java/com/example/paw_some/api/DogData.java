package com.example.paw_some.api;

import java.util.Map;

public class DogData {
    private String name;
    private String temperament;
    private String life_span;
    private String url;
    private Map<String,String> image;



    public DogData(String name, String temperament, String life_span, String url, Map<String, String> image) {
        this.name = name;
        this.temperament = temperament;
        this.life_span = life_span;
        this.url = url;
        this.image = image;
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
