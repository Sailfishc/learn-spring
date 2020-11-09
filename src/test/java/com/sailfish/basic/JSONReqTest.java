package com.sailfish.basic;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class JSONReqTest {


    /**
     * 如果JSONReq中的data没有指定具体的类型，那么经过JSON.parseArray之后，data的数据类型是JSONObject
     */
    @Test
    public void testJSONToArray() {
        String data = "[\n" +
                "\t{\n" +
                "\t\"name\": \"xxx\",\n" +
                "\t\"age\": \"xxx\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"name\": \"xxx\"\n" +
                "\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\"name\": \"xxx\",\n" +
                "\t\"age\": \"xxx\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"name\": \"xxx\"\n" +
                "\t}\n" +
                "}\n" +
                "]";

        List<JSONReq> param = JSON.parseArray(data, JSONReq.class);


    }
}