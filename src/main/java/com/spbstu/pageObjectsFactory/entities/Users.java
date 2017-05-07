package com.spbstu.pageObjectsFactory.entities;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;
/**
 * Created by luck on 16.04.17.
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    String login;
    String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
