package com.icoding.mybatisdemo.pojo;

public class WeightDto {

    private String key;

    private Integer weight;

    public WeightDto(String key, Integer weight){
        this.key = key;
        this.weight = weight;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
