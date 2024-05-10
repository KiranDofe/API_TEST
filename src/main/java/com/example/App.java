package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import java.util.Scanner;

public class App {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL to test: ");
        String url = scanner.nextLine();

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Status Code: " + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}