//import java.io.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Map;
//
//// Main class should be named 'Solution'
//class Solution {
//    public static void main(String[] args) throws IOException {
//      
//        URL url = new URL("http://localhost/deviceStatus");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//        
//        if (conn.getResponseCode() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + conn.getResponseCode());
//        }
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//            (conn.getInputStream())));
//
//        String output;
//        System.out.println("Output from Server .... \n");
//        while ((output = br.readLine()) != null) {
//            System.out.println(output);
//        }
//        
//        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
//        String deviceName = (String) map.get("deviceName");
//        String deviceStatus = (String) map.get("deviceStatus");
//        
//        System.out.println(deviceName + " " +  deviceStatus);
//        
//    }
//}
