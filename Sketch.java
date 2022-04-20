import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  PImage imgBackground;
	PImage imgPlane;

  float fltPlaneX = 0;
  float fltPlaneY = 400;
  int intPlaneSpeedX = 1;
  int intPlaneSpeedY = 2;

  float fltSunX = 0;
  float fltSunY = 100;
  int intSunSpeedX = 2;
  int intSunSize = 50;

   /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(400, 400);
  }

   /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() { 

    imgBackground = loadImage("skyBackground.jpg");

    imgPlane = loadImage("ship_0009.png");
    imgPlane.resize(imgPlane.width*2, imgPlane.height*2);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  image(imgBackground, 0, 0); 

    noStroke();
    fill(241, 245, 130);
    circle(fltSunX, fltSunY, intSunSize);

    fltSunX += intSunSpeedX;

    if(fltSunX < 0 || fltSunX > width){
    intSunSpeedX *= -1;
    }

    image(imgPlane, fltPlaneX - imgPlane.width/2, fltPlaneY);

    fltPlaneY -= intPlaneSpeedY;
    fltPlaneX += intPlaneSpeedX;

    if(fltPlaneX >= width/2 && fltPlaneY <=0){
      intPlaneSpeedY *= -1;
      intPlaneSpeedX *= 1;
    }
    else if (fltPlaneX >= width - imgPlane.width && fltPlaneY >= height - imgPlane.height){
      intPlaneSpeedY *= -1;
      intPlaneSpeedX *= -1; 
    }
    else if (fltPlaneX <= 0 && fltPlaneY >= height){
      intPlaneSpeedY *= -1;
      intPlaneSpeedX *= -1;
    }
  }
}