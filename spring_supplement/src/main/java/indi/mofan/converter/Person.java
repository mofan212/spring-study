package indi.mofan.converter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author mofan
 * @date 2022/1/13 22:16
 */
@Getter
@Setter
@ToString
public class Person {
    private Long id;
    private Date birthday;
}
