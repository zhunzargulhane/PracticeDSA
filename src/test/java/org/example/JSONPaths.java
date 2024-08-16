/*
package org.example;

import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class JSONPaths {

    public static void main(String[] args) {
        String newJson = "{\r\n" +
                "    \"store\": {\r\n" +
                "        \"book\": [\r\n" +
                "            {\r\n" +
                "                \"category\": \"reference\",\r\n" +
                "                \"author\": \"Nigel Rees\",\r\n" +
                "                \"title\": \"Sayings of the Century\",\r\n" +
                "                \"price\": 8.95\r\n" +
                "            },\r\n" +
                "            {\r\n" +
                "                \"category\": \"fiction\",\r\n" +
                "                \"author\": \"Evelyn Waugh\",\r\n" +
                "                \"title\": \"Sword of Honour\",\r\n" +
                "                \"price\": 12.99\r\n" +
                "            },\r\n" +
                "            {\r\n" +
                "                \"category\": \"fiction\",\r\n" +
                "                \"author\": \"Herman Melville\",\r\n" +
                "                \"title\": \"Moby Dick\",\r\n" +
                "                \"isbn\": \"0-553-21311-3\",\r\n" +
                "                \"price\": 8.99\r\n" +
                "            },\r\n" +
                "            {\r\n" +
                "                \"category\": \"fiction\",\r\n" +
                "                \"author\": \"J. R. R. Tolkien\",\r\n" +
                "                \"title\": \"The Lord of the Rings\",\r\n" +
                "                \"isbn\": \"0-395-19395-8\",\r\n" +
                "                \"price\": 22.99\r\n" +
                "            }\r\n" +
                "        ],\r\n" +
                "        \"bicycle\": {\r\n" +
                "            \"color\": \"red\",\r\n" +
                "            \"price\": 19.95\r\n" +
                "        }\r\n" +
                "    },\r\n" +
                "    \"expensive\": 10\r\n" +
                "}\r\n" +
                "";
        // String jsonObject=JsonPath.read(newJson,"store.book");
      */
/*  org.json.JSONArray jsonArray = new org.json.JSONArray(newJson);
        org.json.JSONObject jo=jsonArray.getJSONObject(0);*//*

        System.out.println(JsonPath.read(newJson, "store.book[1].category"));
        String newJsonString = JsonPath.parse(newJson).set("store.book[1].category", "hellosir").jsonString();
        System.out.println(JsonPath.read(newJsonString, "store.book[1].category"));
        String finalJson = "";
        String array = JsonPath.read(newJson, "store.book").toString();
        JSONArray jsonArray = new JSONArray(array);
        System.out.println(jsonArray);
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            if (jsonObject.get("author").toString().contains("Herman Melville")) {
                jsonArray.put(2,JsonPath.parse(jsonObject.toString()).set("author", "zhunzarGulhane").json());
            }
        }
        System.out.println(jsonArray);
    }
}
*/
