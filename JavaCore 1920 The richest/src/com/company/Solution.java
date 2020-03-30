package com.company;

/*

1920 The richest
In the main method, the first parameter is the name of the file.
In this file, each line has the following form:
name value
where [name] is String, [value] is double. [name] and [value] are separated by a space.
For each name, calculate the sum of all its values.
Print the names in alphabetical order with the maximum amount in the console.
Separate names with a space or print from a new line.
Close streams.
Example input file:
Petrov 0.501
Ivanov 1.35
Petrov 0.85
Output Example:
Petrov

Requirements:
1. The program should NOT read data from the console.
2. The program should read the contents of the file (use FileReader).
3. The stream of reading from the file (FileReader) should be closed.
4. The program should display the names of the console with the maximum amount.


*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
     TreeMap<String, Double> map = new TreeMap<>();
     BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
     double max = Double.MIN_VALUE;
     while(fileReader.ready()) {
         String s = fileReader.readLine();
         String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
         String key = strs[0];
         double value = Double.parseDouble(strs[1]);
         if(map.containsKey(key)) {
             map.put(key, map.get(strs[0])+value);
         } else
             map.put(key, value);
     }
     fileReader.close();
     for (Double a : map.values())
         if(max < a)
             max = a;
         for (Map.Entry<String, Double> pair : map.entrySet())
             if (pair.getValue().equals(max))
                 System.out.println(pair.getKey());
    }
}
