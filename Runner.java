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
    String[] eachLineStringArray;
    for (int i = 0; i < numOfLines; i++) {
      eachLineStringArray = buffer.readLine().split(" ");
      packageArray[i] = new Package (Double.parseDouble(eachLineStringArray[0]), Double.parseDouble(eachLineStringArray[1]), Double.parseDouble(eachLineStringArray[2]));
    }
    
    return packageArray;
  }

  //find the smallest package
  public static int smallestPackageIndex(Package[] packageArray) {
    int smallestPackageIndex = 0;
    double smallestPackageVolume = packageArray[0].getVolume();
    for (int i = 1; i < packageArray.length; i++) {
      if (smallestPackageVolume > (packageArray[i].getVolume())) {
        smallestPackageVolume = packageArray[i].getVolume();
        smallestPackageIndex = i;
      }
    }
    return smallestPackageIndex;
  }

  //find the largest package
  public static int largestPackageIndex(Package[] packageArray) {
    int largestPackageIndex = 0;
    double largestPackageVolume = packageArray[0].getVolume();
    for (int i = 1; i < packageArray.length; i++) {
      if (largestPackageVolume < (packageArray[i].getVolume())) {
        largestPackageVolume = packageArray[i].getVolume();
        largestPackageIndex = i;
      }
    }
    return largestPackageIndex;
  }

  //find amount of cubic packages
  public static int ammountOfCubicPackages(Package[] packageArray) {
    int ammountOfCubicPackages = 0;
    for (int i = 0; i < packageArray.length; i++) {
      if (packageArray[i].isCube()) {
        ammountOfCubicPackages++;
      }
    }
    return ammountOfCubicPackages;
  }

  //find the index of smallest cubic package
  public static int smallestCubicPackageIndex(Package[] packageArray) {
    int smallestCubicPackageIndex = -1;
    for (int i = 0; i > packageArray.length; i++) {
      if (packageArray[i].isCube() ) {
        double smallestCubicPackageVolume = packageArray[i].getVolume();
        if (smallestCubicPackageVolume > packageArray[i].getVolume()) {
          
        }
        smallestCubicPackageIndex = i;
        smallestCubicPackageVolume = packageArray[i].getVolume();
      }
    }
    return smallestCubicPackageIndex;
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

    //find the smallest package
    int smallestPackageIndex = smallestPackageIndex(packageArray);
    System.out.println("The index of the smallest package is: " + smallestPackageIndex);
    System.out.println("The width of the smallest package is: " + packageArray[smallestPackageIndex].getWidth());
    System.out.println("The height of the smallest package is: " + packageArray[smallestPackageIndex].getHeight());
    System.out.println("The length of the smallest package is: " + packageArray[smallestPackageIndex].getLength());
    System.out.println("The volume of the smallest package is: " + packageArray[smallestPackageIndex].getVolume());
    System.out.print("\n");

    //find the largest package
    int largestPackageIndex = largestPackageIndex(packageArray);
    System.out.println("The index of the largest package is: " + largestPackageIndex);
    System.out.println("The width of the largest package is: " + packageArray[largestPackageIndex].getWidth());
    System.out.println("The height of the largest package is: " + packageArray[largestPackageIndex].getHeight());
    System.out.println("The length of the largest package is: " + packageArray[largestPackageIndex].getLength());
    System.out.println("The volume of the largest package is: " + packageArray[largestPackageIndex].getVolume());
    System.out.print("\n");

    //find amount of cubic packages
    int ammountOfCubicPackages = ammountOfCubicPackages(packageArray);
    System.out.println("Number of cubic packages: " + ammountOfCubicPackages);
    System.out.print("\n");

    //find the index of smallest cubic package
    int smallestCubicPackageIndex = smallestCubicPackageIndex(packageArray);
    System.out.println("The index of the smallest cubic package is: " + smallestCubicPackageIndex);
    System.out.println("The width of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getWidth());
    System.out.println("The height of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getHeight());
    System.out.println("The length of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getLength());
    System.out.println("The volume of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getVolume());
    System.out.print("\n");

    
  }
}