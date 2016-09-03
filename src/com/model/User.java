package com.model;

import com.model.phonenumber.PhoneNumber;
import com.model.util.Util;
import com.model.util.Validate;

import java.util.List;

public class User {
    private String name;
    private String password;
    private int id = 0;
    private List<PhoneNumber> phonePhoneNumber;
    private List<User> friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Validate.md5(password);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public List<PhoneNumber> getPhonePhoneNumber() {
        return phonePhoneNumber;
    }

    public void setPhonePhoneNumber(List<PhoneNumber> phonePhoneNumber) {
        this.phonePhoneNumber = phonePhoneNumber;
    }

    public List<User> getFriend() {
        return friend;
    }

    public void setFriend(List<User> friend) {
        this.friend = friend;
    }

    public User() {

    }

    public User(String noMd5Password) {
        this.password = noMd5Password;
    }

    public User(String name, String password) {
        super();
        this.name = name;
        this.password = Validate.md5(password);
        this.id = ++Util.next_id;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((friend == null) ? 0 : friend.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((phonePhoneNumber == null) ? 0 : phonePhoneNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (friend == null) {
            if (other.friend != null)
                return false;
        } else if (!friend.equals(other.friend))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (phonePhoneNumber == null) {
            if (other.phonePhoneNumber != null)
                return false;
        } else if (!phonePhoneNumber.equals(other.phonePhoneNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

}
