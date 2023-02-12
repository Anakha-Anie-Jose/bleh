package com.example.restservice;

public record Book(long id, String content) {

    public String title(){
        return this.content;
    }
}