package Collections;
import java.util.*;
class Point {
	    int x, y;

	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj instanceof Point) {
	            Point other = (Point) obj;
	            return this.x == other.x && this.y == other.y;
	        }
	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
	

	    public static void main(String[] args) {
	        HashSet<Point> pointSet = new HashSet<>();
	        pointSet.add(new Point(1, 2));
	        pointSet.add(new Point(3, 4));
	        pointSet.add(new Point(1, 2)); // Duplicate
	        pointSet.add(new Point(5, 6));

	        System.out.println("Unique points count: " + pointSet.size()); // Output: 3
	    }
	}


