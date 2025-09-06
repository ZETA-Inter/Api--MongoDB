package com.example.ZETA_Api_MongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class Counter {
    @Id
    private String id;
    private int seq;

    // getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getSeq() { return seq; }
    public void setSeq(int seq) { this.seq = seq; }
}

