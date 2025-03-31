package javasem;

//Point class to store (x, y) coordinates
class Point {
 double x, y;

 public Point(double x, double y) {
     this.x = x;
     this.y = y;
 }

 public double distance(Point other) {
     return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
 }
}
class ClosestPair {
	
	    public static Point[] findClosestPair(Point[] points) {
	        double minDist = Double.MAX_VALUE;
	        Point[] closestPair = new Point[2];

	        for (int i = 0; i < points.length; i++) {
	            for (int j = i + 1; j < points.length; j++) {
	                double dist = points[i].distance(points[j]);
	                if (dist < minDist) {
	                    minDist = dist;
	                    closestPair[0] = points[i];
	                    closestPair[1] = points[j];
	                }
	            }
	        }
	        return closestPair;
	    }
	    
	    public class ClosestPoint{
	    public static void main(String[] args) {
	        Point[] points = {new Point(1, 2), new Point(4, 6), new Point(5, 5), new Point(3, 3)};
	        Point[] closest = findClosestPair(points);
	        System.out.println("Closest Points: (" + closest[0].x + ", " + closest[0].y + ") and (" + closest[1].x + ", " + closest[1].y + ")");
	    }
}
}
 

