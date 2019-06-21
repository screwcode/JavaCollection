import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 笛卡尔坐标系中的一个点
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static List<Point> sort(List<Point> list) {
        List<Point> ret = new ArrayList<>(list);
        ret.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        return ret;
    }
}
