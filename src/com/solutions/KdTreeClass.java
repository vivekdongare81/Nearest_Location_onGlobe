package com.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import net.sf.javaml.core.kdtree.KDTree;

public class KdTreeClass {
	public static void main(String[] args) throws IOException {

		KDTree kt = new KDTree(2);
	

		File file = new File("C:\\Users\\donga\\eclipse-workspace\\Nearest_Location\\dataSet.csv");

		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Latitude :");
		Float lat = Float.parseFloat("1.3270");
		System.out.println("Enter Longitude :");
		Float longi = Float.parseFloat("103.7111");
		
		double[] req = {lat,longi};
		String st = "";
		
		while ((st = reader.readLine()) != null) {

			String[] stArr = st.split(",");
			double arr[] = {Double.parseDouble(stArr[0]),Double.parseDouble(stArr[1])};
			kt.insert(arr, (Object)stArr[2]);
		}
		long start = System.currentTimeMillis();; 
		
		System.out.println(kt.nearest(req));
		
		long end = System.currentTimeMillis();
		System.out.println("Time - " + (end - start) + " ms");
		
		
	}

}
