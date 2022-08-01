package com.solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class parseTxtToCSV {
	
    public static void main(String[] args) throws IOException {
	
	  File file = new File(
	            "C:\\Users\\donga\\eclipse-workspace\\Nearest_Location\\src\\allCountries.txt");
	 
	        BufferedReader reader
	            = new BufferedReader(new FileReader(file));
	        BufferedWriter writer = null;
	        
	        Map<String,String> output = new HashMap<>();
		
	        String st;
	    
	        int i =0;
	        while ((st = reader.readLine()) != null) {
	        
	            String []arr = st.replaceAll(",", "-").split("\t");
	            //System.out.println(Arrays.toString(arr)+arr.length);
	            
	            output.put(arr[9]+","+arr[10]+",",arr[2]+" "+arr[3]+" "+arr[4] );
	          
	        }
	        
	        writer = new BufferedWriter(new FileWriter(new File("dataSet.csv")));
            for (Entry s : output.entrySet()) {
                writer.write((String) s.getKey()+s.getValue());
                System.out.println((String)s.getKey()+s.getValue());
                writer.newLine();
            }

            writer.flush();
            writer.close();
            
	       System.out.println("Parsing done");
	 
	}
}
