package indi.mofan.converter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mofan
 * @date 2022/1/13 22:25
 */
@Getter
@Setter
public class MyDateConverter implements Converter<String, Date> {

    private String pattern;

    @Override
    public Date convert(String s) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
