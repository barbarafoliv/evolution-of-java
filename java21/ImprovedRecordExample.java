public class ImprovedRecordExample {
    private static int beforeRecordPattern(Object obj) {
        int sum = 0;
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            sum = x + y;
        }
        return sum;
    }

    private static int afterRecordPattern(Object obj) {
        if (obj instanceof Point(int x, int y)) {
            return x + y;
        }
        return 0;
    }

    private static Color getRamdomPointColor(RandomPoint r) {
        if (r instanceof RandomPoint(ColoredPoint cp)) {
            return cp.color();
        }
        return null;
    }

    enum Color {RED, GREEN, BLUE}

    record Point(int x, int y) {
    }

    record ColoredPoint(Point point, Color color) {
    }

    record RandomPoint(ColoredPoint cp) {
    }
}
