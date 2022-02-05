package indi.mofan.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mofan
 * @date 2021/10/11 23:29
 */
@Getter
@Setter
public class User {
    private String username;
    private String password;

    private Person person;
}
