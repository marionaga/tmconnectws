package com.id.tmli.intranet.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by hito.mario on 28/12/2016.
 */
public class Config {

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public void getProperties(Properties prop) throws IOException {
        prop.load(getClass().getClassLoader().getResourceAsStream(
                "config.properties"));
        /*prop.load(new FileInputStream("sms_broadcast.properties"));*/
        /*prop.load(new FileInputStream("src/main/resources/config.properties"));*/
    }

    public static String dateNow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date dateNow = new Date();
        String logDate = dateFormat.format(dateNow);
        return logDate;
    }


}
