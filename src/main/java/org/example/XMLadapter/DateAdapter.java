package org.example.XMLadapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String s) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").parse(s);
    }

    //with this method "marshal" we save the information form the classes into the Xml files
    //we get a String
    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").format(date);
    }
}
