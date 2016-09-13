public class Package {
  //variables
  private double width;
  private double height;
  private double length;

  //constructors
  public Package () {
  }
  public Package (double newWidth , double newHeight, double newLength) {
    width = newWidth;
    height = newHeight;
    length = newLength;
  }
  
  //accessors
  public double getWidth() {
    return width;
  }
  public double getHeight() {
    return height;
  }
  public double getLength() {
    return length;
  }

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