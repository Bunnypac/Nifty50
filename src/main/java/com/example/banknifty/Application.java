package com.example.banknifty;

import com.example.banknifty.dao.BankNiftyDAO;
import com.example.banknifty.util.JsonBodyHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("https://www.nseindia.com/api/equity-stockIndices?index=SECURITIES%20IN%20F%26O")
                   // .setHeader(HttpHeaders.ACCEPT, "application/json")
                    .setHeader("cookie", "ak_bmsc=6227CBA8CB9D2C7770611F0251CE9034~000000000000000000000000000000~YAAQS3xBF3XF73l+AQAA6vp3gQ4t25fdZgL29F/A9GTrx7Gq9lgOGoHf8D139U1sJip3MOTJB0el838nCq5VaJg+tVAer9lGTcxEey3MJmCVXyQwS6kUOt6Z4SuQakr51AdEksMcKFKkYAsTilwoaQZoYny6+3cmDMnkuvFCmt42GvsgV0EIVm06NKvBQXf7nJyIaxBoBgYcFjUMSLTQ2b9BwVMsO8+cAs778eJzMwRCEuhtHxavnDWCed4i/ePASQsvaS37danBD1erf+oZXTSa4BR7nfjzEOeBoZDS260q4tWzeWe/MrcDoU/Cp3DRR4J82QHcQtTTzMjZ+xiMqVqg6zbepitYUyoFS+thxabanJwIYd2WDx1oN5VX5P/j")
                   // .setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57")
                   // .setHeader("accept-encoding", "gzip, deflate, br")
                   // .setHeader(HttpHeaders.CONTENT_TYPE,"application/json; charset=utf-8")
                   // .setHeader(HttpHeaders.CONTENT_ENCODING,"gzip")

                    .build();

            BankNiftyDAO response = client.execute(request, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), BankNiftyDAO.class));

            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
