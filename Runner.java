/*
Author: Edgar E. Rodriguez
TA: Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 8/30/16
*/

import java.util.*;
import java.io.*;

public class Runner {
  public static Package[] readFile (String fileName) throws IOException {
    String line;
    FileReader reader = new FileReader(fileName);
    BufferedReader buffer = new BufferedReader(reader);
    buffer.mark(1000); //here we assume that the file won't be longer than 1000 lines
    
    //count lines
    int numOfLines = 0;
    while ((line = buffer.readLine()) != null){
      numOfLines++;
    }
    
    //create empty array
    Package[] packageArray = new Package[numOfLines];
    
    //assign values to empty array
    buffer.reset();
    for (int i = 0; i < numOfLines; i++) {
      String[] eachLineStringArray = buffer.readLine().split(" ");
      packageArray[i] = new Package (Double.parseDouble(eachLineStringArray[0]), Double.parseDouble(eachLineStringArray[1]), Double.parseDouble(eachLineStringArray[2]));
    }
    
    return packageArray;
  }
  
  public static void main (String[] args) throws IOException {
    // ask for file name and build packageArray
    String fileName = "";
    Scanner scnr = new Scanner(System.in);
    System.out.println("What is the name of the file?");
    Package packageArray[] = null;
    try {
      fileName = scnr.nextLine();
      packageArray = readFile(fileName);
    }catch(FileNotFoundException e) {
      System.err.println("File not found" + e.getMessage());
      System.exit(1);
    }
    
    //check if file has content
    if (packageArray.length == 0) {
      try {
        throw new IOException("File is empty!");
      }catch(IOException e) {
        System.out.println(e.getMessage());
      }
    }
    for(int i = 0;  i < packageArray.length; i++){
      System.out.print(packageArray[i]);
    }
    
    
  }
}