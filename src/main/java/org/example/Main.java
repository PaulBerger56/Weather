package org.example;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Main {
    public static void main(String[] args) throws Exception{

        // Take user input for city and state
        Scanner scanner = new Scanner(System.in);

        System.out.print("What City's weather would you like to know?  ");
        String city = scanner.nextLine();

        System.out.print("What state is " + city + " in?  ");
        String state = scanner.nextLine();

        // Input the city and state into the call to the API
        String inputString = "YOUR_API_KEY_HERE";

        // Call to the api
        HttpResponse<String> response = Unirest.get(inputString)
                .header("X-RapidAPI-Key", "5faae8c877msh39b36d450f4b78ap185e5bjsnce9403e8d822")
                .header("X-RapidAPI-Host", "visual-crossing-weather.p.rapidapi.com")
                .asString();

        // splits the original String input
        String[] temp = response.getBody().split("\\R");

        // splits the second line which is the current day
        String[] currentLineSplit = temp[1].split(",");

        // removes quotation marks
        for(String s: currentLineSplit) {
            s = s.replaceAll("\"", "");
        }

        // prints out the city, high, and low temp
        System.out.println("Today's temperature in " + currentLineSplit[0].replaceAll("\"", "") + " is a high of " + currentLineSplit[14] + " and a low of " + currentLineSplit[15]);


    }
}