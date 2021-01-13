import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        ret.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                // 按照先x再y，从小到大的顺序排序
                return  Comparator.comparing(Point::getX)
                        .thenComparing(Point::getY)
                        .compare(p1,p2);
            }
        });
        return ret;
    }
}
