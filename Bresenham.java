/*
This algorithm was developed to draw lines on digital plotters, line primitives in a bitmap image
through integer addition and subtraction
*/
import java.applet.Applet;
import java.awt.*;



public class Bresenham extends Applet {

    // Initial point
    int x0,y0 ;

    // Endpoints
    int xn , yn ;

    // Delta X & Y
    double dx,dy;

    // p0
    double  pX;

    int totalPoints ;



    public  Bresenham (  int  x0 , int y0 , int xn,  int yn ){
        this.x0=x0;
        this.y0=y0;
        this.xn=xn;
        this.yn=yn;
    }

    public Bresenham () {}


    public void paint(Graphics g) {
       x0= 0; y0= 0; xn=-4;yn= 2 ;
        g.fillOval(x0, y0, 5, 5);
        g.fillOval(xn, yn, 5, 5);
        dx = xn - x0;
        dy = yn - y0;



        //  Computes total number of  points  required to  plot the line
        if  ( Math.abs(xn) > Math.abs(x0))
            totalPoints = Math.abs(xn);
        else
            totalPoints=Math.abs(x0);

        double  grad = dy/dx;
        System.out.println(grad);
        if  (grad > 0.0  && grad <= 1.0 ) {
            System.out.println("Gradient is between 0 <= m <= 1");
            pX= (2 * dy)-dx;
            System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
            for (int k = 1; k < totalPoints-1; k++) {
                if (pX <= 0) {
                    g.fillOval(x0++, y0, 5, 5);
                    pX = pX + (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                } else {
                    g.fillOval(x0++, y0++, 5, 5);
                    pX = pX + (2 * (dy-dx));
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }

            }
        }
        else if(grad < 0 && grad >= -1) {

            System.out.println("Gradient is between 0 > m >= -1");
            pX= (-2 * dy)-dx;
            System.out.println( "pX : " + pX + " X : " + xn +" Y : " +yn );
            for (int k = 1; k < totalPoints+1; k++) {
                if (pX >= 0) {
                    g.fillOval(xn++, yn, 5, 5);
                    pX = pX - (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + xn +" Y : " +yn );
                } else {
                    g.fillOval(xn++, yn--, 5, 5);
                    pX = pX - (2 * (dy+dx));
                    System.out.println( "pX : " + pX + " X : " + xn +" Y : " +yn );
                }

            }

        } else {
            System.out.println("TBD ");
        }
    }
    public  void main(String[] args) {

        Graphics g = getGraphics();
        Bresenham bresenham = new Bresenham();
        bresenham.paint(g);




    }


}
