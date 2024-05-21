import java.util.ArrayList;

public class Box {
    public Box(int id, int x, int y) {
        selected = new ArrayList<>();
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.top = true;
                this.bottom = true;
                        this.left = true;
                                this.right = true;

                                this.topLeft = true;
                                this.topRight = true;
                                this.bottomLeft = true;
                                this.bottomRight = true;
                                this.isEmpty = true;

    }

    int id;
    int x;
    int y;
    int width, height;
    boolean top, bottom, left, right;
    boolean topLeft,topRight, bottomLeft, bottomRight;
    ArrayList<Integer> selected;
    boolean isEmpty;









}
