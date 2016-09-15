/*
Author: Edgar E. Rodriguez
TAs: Anthony M Ortiz Cepeda and Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 09/13/16
Goals: Read the widht, height, and length of packages from file, and calculate the following:
• find the smallest package
• find the largest package
• find amount of cubic packages
• find the index of smallest cubic package
• average volume of all packages
• average volume of cubic packages
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
      if (eachLineStringArray.length > 3) {
        try {
            throw new IOException("There should only be 3 values per line in the file.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }        
      }
      try {
        packageArray[i] = new Package (Double.parseDouble(eachLineStringArray[0]), Double.parseDouble(eachLineStringArray[1]), Double.parseDouble(eachLineStringArray[2]));
      } catch(NumberFormatException e) {
        System.err.println("The file should only contain numbers of double precision and single spaces (example: \"1.0 2.3 1.3\")");
        System.exit(1);
      }
      
    }
    
    return packageArray;
  }

    //sum double 1d array values
    public static double doubleArraySum (double[] d) {
      double doubleArraySum = 0;
      for (int i = 0; i < d.length; i++) {
        doubleArraySum = doubleArraySum + d[i];
      }
      return doubleArraySum;
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
    int ammountOfCubicPackages = ammountOfCubicPackages(packageArray);
    int smallestCubicPackageIndex = 0;
    double smallestCubicPackageVolume = packageArray[0].getVolume();

    if (ammountOfCubicPackages > 0) {
      for (int i = 0; i < packageArray.length; i++) {
        if ( (packageArray[i].isCube()) && (smallestCubicPackageVolume > packageArray[i].getVolume()) ) {
            smallestCubicPackageIndex = i;
            smallestCubicPackageVolume = packageArray[i].getVolume();
        }
      }
    } else {
      smallestCubicPackageIndex = -1;
    }

    return smallestCubicPackageIndex;

  }

  ////average volume of all packages
  public static double averageVolumeOfAllPackages (Package[] packageArray) {
    double averageVolumeOfAllPackages;
    double[] volumesArray = new double[packageArray.length];//craete array with the length of package arrays to store volumes
    // populate volumes array
    for (int i = 0; i < packageArray.length; i++) {
      volumesArray[i] = packageArray[i].getVolume();
    }

    averageVolumeOfAllPackages = doubleArraySum(volumesArray)/packageArray.length;

    return averageVolumeOfAllPackages;
  }
  
  //average volume of cubic packages (divided by amount of cubic packages)
  public static double averageVolumeOfCubicPackagesCubic (Package[] packageArray) {
    double averageVolumeOfCubicPackages = 0;
    int ammountOfCubicPackages = ammountOfCubicPackages(packageArray);// check if there are cubic packages

    if (ammountOfCubicPackages > 0) {
      double[] volumesArray = new double[ammountOfCubicPackages]; // create volumes array
      int volumesArrayCounter = 0;
      //pupulate volumes array
      for (int i = 0; i < packageArray.length; i++) {
        if (packageArray[i].isCube()) {
          volumesArray[volumesArrayCounter] = packageArray[i].getVolume();
          volumesArrayCounter++;
        }
      }
      averageVolumeOfCubicPackages = doubleArraySum(volumesArray) / ammountOfCubicPackages; //sum volumes array a nddivide by ammountOfCubicPackages
    } else {
      averageVolumeOfCubicPackages = -1;
    }

    return averageVolumeOfCubicPackages;
  }

  //average volume of cubic packages (divided by amount of ALL packages)
  public static double averageVolumeOfCubicPackagesAll (Package[] packageArray) {
    double averageVolumeOfCubicPackages = 0;
    int ammountOfCubicPackages = ammountOfCubicPackages(packageArray);// check if there are cubic packages

    if (ammountOfCubicPackages > 0) {
      double[] volumesArray = new double[ammountOfCubicPackages]; // create volumes array
      int volumesArrayCounter = 0;
      //pupulate volumes array
      for (int i = 0; i < packageArray.length; i++) {
        if (packageArray[i].isCube()) {
          volumesArray[volumesArrayCounter] = packageArray[i].getVolume();
          volumesArrayCounter++;
        }
      }
      averageVolumeOfCubicPackages = doubleArraySum(volumesArray) / packageArray.length; //sum volumes array and divide by ammount Of ALL Packages
    } else {
      averageVolumeOfCubicPackages = -1;
    }

    return averageVolumeOfCubicPackages;
  }

  /* ----------------------- main -------------------------- */
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
      System.err.println("File not found " + e.getMessage());
      System.exit(1);
    }
    
    //check if file has content
    if (packageArray.length == 0) {
      try {
        throw new IOException("File is empty! Please use a file with data.");
      } catch (IOException e) {
        System.out.println(e.getMessage());
        System.exit(1);
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
    if (smallestCubicPackageIndex > -1) {
      System.out.println("The index of the smallest cubic package is: " + smallestCubicPackageIndex);
      System.out.println("The width of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getWidth());
      System.out.println("The height of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getHeight());
      System.out.println("The length of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getLength());
      System.out.println("The volume of the smallest cubic package is: " + packageArray[smallestCubicPackageIndex].getVolume());
    } else {
      System.out.println("Can't find the index of smallest cubic package because there are no cubic packages.");
    }
    System.out.print("\n");

    //average volume of all packages
    double averageVolumeOfAllPackages = averageVolumeOfAllPackages(packageArray);
    System.out.println("Average volume of All packages: " + averageVolumeOfAllPackages);
    System.out.print("\n");

    //average volume of cubic packages (divided by amount of cubic packages)
    double averageVolumeOfCubicPackagesCubic = averageVolumeOfCubicPackagesCubic(packageArray);
    if (averageVolumeOfCubicPackagesCubic > -1) {
      System.out.println("Average volume of Cubic packages (sum divided by amount of CUBIC packages only): " + averageVolumeOfCubicPackagesCubic);
    } else {
      System.out.println("Can't calculate the average volume of cubic packages because there are no cubic packages.");
    }
    System.out.print("\n");

    //average volume of cubic packages (divided by amount of ALL packages)
    double averageVolumeOfCubicPackagesAll = averageVolumeOfCubicPackagesAll(packageArray);
    if (averageVolumeOfCubicPackagesAll > -1) {
      System.out.println("Average volume of Cubic packages (sum divided by amount of ALL packages): " + averageVolumeOfCubicPackagesAll);
    } else {
      System.out.println("Can't calculate the average volume of cubic packages because there are no cubic packages.");
    }
    System.out.print("\n");

  }
}