public class Package {
  //variables
  private double width;
  private double height;
  private double length;

  //constructors
  public Package () {
  }
  public Package (double width , double height, double length) {
    width = width;
    height = height;
    length = length;
  }
  
  //accessors
  public double getVolume(){
    return (width * height * length);
  }

  public boolean isCube(){
    boolean isCube = false;
    if((width == height) && (height == length)) {
      isCube = true;
    }
    return isCube;
  }

}