package sandbox;

import java.util.ArrayList;
import java.util.List;

public class Trigonomy {


    public static void main(String[] args) {
        Trigonomy trigonomy = new Trigonomy();
      List<Point> inSquare = new ArrayList<>();
      List<Point> inCircle = new ArrayList<>();
        List<Point> points = trigonomy.generatePoints();
        points.forEach(point -> {
            if(point.getRadius()>1.0){
                inSquare.add(point);
            }else{
                inCircle.add(point);
            }
        });
        System.out.println(trigonomy.countPi(inCircle.size(),points.size()));
    }
    public float countPi(int inCircle, int inSquare){
        System.out.println(inCircle);
        System.out.println(inSquare);
        return (float)inCircle/inSquare;
    }
    public List<Point> generatePoints(){
        List<Point> points = new ArrayList<>();
        for(int i=0; i<100000;i++){
            Point point = new Point(Math.random(),Math.random());
            points.add(point);
        }
        return points;
    }
    public class Square{
        //площадь
        private Double s = 4.0;
    }
    public class Circle{
        //площадь
        private Double s = 3.14;
        private Double x;
        private Double y;
        private Double r = 1.0;

    }
    public class Point{

        private Double x;
        private Double y;
        private Double radius;
        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
            radius = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        }

        public Double getRadius() {
            return radius;
        }
    }
}
