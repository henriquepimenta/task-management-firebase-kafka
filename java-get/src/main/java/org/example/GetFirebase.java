package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetFirebase {
    public static void main(String[] args) throws IOException {
        while (true) {
            Firebase.get();
        }
    }
}