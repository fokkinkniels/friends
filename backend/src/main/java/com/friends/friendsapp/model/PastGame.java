package com.friends.friendsapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class PastGame {

    @Id
    private String id;
    private String userId;
    private String category_id;
    private String result_link;

    public PastGame() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String user_id) {
        this.userId = user_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getResult_link() {
        return result_link;
    }

    public void setResult_link(String result_link) {
        this.result_link = result_link;
    }
}
