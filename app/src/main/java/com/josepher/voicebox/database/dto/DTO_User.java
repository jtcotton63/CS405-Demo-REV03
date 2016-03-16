package com.josepher.voicebox.database.dto;

import java.sql.Timestamp;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DTO_User {
    public Integer id = null;
    public String username;
    public String password;
    public Timestamp joinedDate;
    public String lastName;
    public String firstName;
    public Integer locality_id = null;
    public Integer university_id = null;

    public DTO_User(String username, String password, Timestamp joinedDate, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.joinedDate = joinedDate;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
