package com.fullstack.pwdgen.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty
    private String word;

    public String getWord() {
        return word;
    }

    public Request setWord(String word) {
        this.word = word;
        return this;
    }


}
