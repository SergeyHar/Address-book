package com.data;

import com.model.User;

/**
 * Created by Sergo on 10-Sep-16.
 */
public class FriendMap extends User {
    private int id;
    private int value;

    public FriendMap() {
    }

    public FriendMap(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
