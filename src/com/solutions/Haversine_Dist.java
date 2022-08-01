package com.solutions;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.solutions.*;

public class Haversine_Dist {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        ;

        // TODO Auto-generated method stub
        File file = new File("C:\\Users\\donga\\eclipse-workspace\\Nearest_Location\\dataSet.csv");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Latitude :");
        Float lat = Float.parseFloat("1.3270");
        System.out.println(lat);

        
        System.out.println("Enter Longitude :");
        Float longi = Float.parseFloat("103.7111");
        System.out.println(longi);

        double min = Double.MAX_VALUE;

        String ans = "";
        String st = "";

        while ((st = reader.readLine()) != null) {

            String[] stArr = st.split(",");

            double dist = calculateDistance((double) lat, (double) longi, (double) Float.parseFloat(stArr[0]),
                    (double) Float.parseFloat(stArr[1]));

            if (min > dist) {
                min = dist;
                ans = st;
            }
        }
        System.out.print("Nearest Loc -> ");
        System.out.println(ans);

        long end = System.currentTimeMillis();
        System.out.println("Time - " + (end - start) + " ms");

    }

    // Haversine Formula
    static double calculateDistance(double latP1, double lngP1, double latP2, double lngP2) {

        double radius = 6371.0;

        latP1 = Math.toRadians(latP1);
        lngP1 = Math.toRadians(lngP1);
        latP2 = Math.toRadians(latP2);
        lngP2 = Math.toRadians(lngP2);

        double distance = Math.pow(Math.sin((latP2 - latP1) / 2.0), 2)
                + Math.cos(latP1) * Math.cos(latP2) * Math.pow(Math.sin((lngP2 - lngP1) / 2.0), 2);
        distance = 2.0 * radius * Math.asin(Math.sqrt(distance));

        return distance;
    }

}
