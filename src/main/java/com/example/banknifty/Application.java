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
                    .setHeader("cookie", "D93B5CB3B8D4DCB97941A7E6FF4C004B~TA97tTDJ04+p7l0CmeA+BzkO3WVW1aKMBaml6SLoRcOO+Lc893UmoNbjm17qTn+stN840ga2IKed5ujj3q4ygQGJ4ncal6fnO1rxjQujFbhjmJ9qg5+SkxGpcM0eXu9p7FvDGtnY6XwgKfYzKH8TyhTyfYK6mOrImjrXeHhwPug=")
                    .setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.57")
                    .setHeader("accept-encoding", "gzip, deflate, br")
                    .setHeader("accept-language","en-US,en;q=0.9")
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
