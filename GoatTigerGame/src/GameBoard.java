//<iframe src="https://docs.google.com/document/d/e/2PACX-1vSOmrJYAncRtGu2-jwqASUtNJWfECHw7ZeRrmU6yoQ3eUUhz_hXlLx8arDPqSiGXgfSX2oaxKzyxLqS/pub?embedded=true"></iframe>

      //  https://docs.google.com/document/d/e/2PACX-1vSOmrJYAncRtGu2-jwqASUtNJWfECHw7ZeRrmU6yoQ3eUUhz_hXlLx8arDPqSiGXgfSX2oaxKzyxLqS/pub

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameBoard extends GameEngine implements KeyListener {
    final int WIDTH = 800;
    final int HEIGHT = 800;
    final String tigerIcon = "🐯";
    final String goatIcon = "\uD83D\uDC10";
    Image tigerImage, goatImage;
    Image boardImage;
    boolean goatTurn = true;
    int selectedBox = 1;
    Tiger tiger;
    Goat goat;
    Box triangle;
    Point p1;
    Box start, end;

    ArrayList<Box> boxes;
    ArrayList<Tiger> tigers;
    ArrayList<Goat> goats;


    Box chosenBox;

    @Override
    public void init() {
        setWindowSize(WIDTH, HEIGHT);
        boardImage = loadImage("GoatTigerGame/src/boardImg.png");
        tigerImage = loadImage("GoatTigerGame/src/tigerImg.png");
        goatImage = loadImage("GoatTigerGame/src/goatImg.png");
        p1 = new Point();
        boxes = new ArrayList<>();
        tigers = new ArrayList<>();
        goats = new ArrayList<>();

        int id = 1;
        for (int ix = 150; ix < 600; ix += 110) {
            for (int iy = 150; iy < 600; iy += 110) {
                Box t = new Box(id, ix, iy);
                boxes.add(t);
                id++;
            }
        }
        //set rules
        setRules();

        final int MAX_TIGER = 4;

        //initialize tiger
        for (int i = 0; i < 4; i++) {
            Tiger tiger = new Tiger(10, 10);
            tigers.add(tiger);
        }
        //initialise goats
        for (int i = 0; i < 20; i++) {
            Goat goat = new Goat(0, 0);
            goats.add(goat);
        }
        System.out.println("Tigers: " + tigers.size());
        System.out.println("Goats: " + goats.size());

//        for(Box b: boxes) {
//            System.out.println("Box "+b.id + " ["+ b.top + "-"+b.bottom+"]");
//        }
    }

    public void setRules() {
        for (Box b : boxes) {
            int id = b.id - 1;
            switch (id) {
                case 0:
                    boxes.get(id).top = false;
                    boxes.get(id).left = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomLeft = false;
                    break;
                case 1:
                    boxes.get(id).left = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 2:
                    boxes.get(id).left = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottomLeft = false;
                    break;
                case 3:
                    boxes.get(id).left = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 4:
                    boxes.get(id).left = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottom = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 5:
                    boxes.get(id).top = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 7:
                    boxes.get(id).topRight = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 9:
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottom = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 10:
                    boxes.get(id).top = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    break;
                case 11:
                    boxes.get(id).topRight = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 12:
                    boxes.get(id).topRight = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 14:
                    boxes.get(id).bottom = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 15:
                    boxes.get(id).top = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 17:
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 19:
                    boxes.get(id).bottom = false;
                    boxes.get(id).bottomLeft = false;
                    boxes.get(id).bottomRight = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    break;
                case 20:
                    boxes.get(id).top = false;
                    boxes.get(id).right = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 21:
                    boxes.get(id).right = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomRight = false;
                    boxes.get(id).bottomLeft = false;
                    break;
                case 22:
                    boxes.get(id).right = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomRight = false;
                    break;
                case 23:
                    boxes.get(id).right = false;
                    boxes.get(id).topLeft = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomRight = false;
                    boxes.get(id).bottomLeft = false;
                    break;
                case 24:
                    boxes.get(id).bottom = false;
                    boxes.get(id).right = false;
                    boxes.get(id).topRight = false;
                    boxes.get(id).bottomRight = false;
                    boxes.get(id).bottomLeft = false;
                    break;

            }
        }
    }


    @Override
    public void update(double dt) {

    }

    @Override
    public void paintComponent() {
        saveCurrentTransform();
        changeBackgroundColor(Color.darkGray);
        clearBackground(WIDTH, HEIGHT);

        changeColor(Color.WHITE);
        drawImage(boardImage, 150, 150, 480, 480);

        changeColor(Color.ORANGE);

        //draw board
        for (Box b : boxes) {
            String id = String.valueOf(b.id);
            drawText(b.x, b.y, id, "", 15);
            drawRectangle(b.x, b.y, b.width, b.height);

            if (b.id == 1 || b.id == 5 || b.id == 21 || b.id == 25) {
                drawImage(tigerImage, b.x, b.y, b.width, b.height);
               // drawText(b.x, b.y + 30, tigerIcon, "", 35);
                b.isEmpty = false;
            }
        }

        for (Box b : boxes) {
            if (selectedBox == b.id) {
                Box box = boxes.get(b.id - 1);
                changeColor(Color.GREEN);
                drawRectangle(box.x, box.y, box.width, box.height);
            }
        }


        if (!goatTurn) {
            //draw control
            changeColor(Color.ORANGE);
            drawRectangle(250, 670, 90, 50);
            drawImage(tigerImage, 255, 670, 50, 50 );
            //drawText(255, 680, tigerIcon, "", 40);
        } else {
            changeColor(Color.GRAY);
            drawRectangle(250, 670, 90, 50);
            drawImage(tigerImage, 255, 670, 50, 50 );
        }

        if (goatTurn) {
            //draw control
            changeColor(Color.GRAY);
            drawSolidRectangle(140, 670, 90, 50);
            drawImage(goatImage, 155, 670, 70, 50);
            //drawText(155, 680, goatIcon, "", 40);
        } else {
            //draw control
            changeColor(Color.WHITE);
            drawRectangle(140, 670, 90, 50);
            drawImage(goatImage, 155, 670, 70, 50);
            //drawText(155, 680, goatIcon, "", 40);
        }

        //draw goat
        if (goatTurn && !goats.isEmpty()) {
            for (Goat g : goats) {
                drawImage(goatImage, g.x, g.y, g.goatWidth+15, g.goatHeight+15);
                //drawText(g.x, g.y + 25, goatIcon, "", 40);

            }
        }

        restoreLastTransform();

    }


    //key listener
    @Override
    public void mouseClicked(MouseEvent event) {
        p1.x = event.getX();
        p1.y = event.getY();

        for (Box b : boxes) {
            if (((b.x + b.width) >= event.getX() && b.x <= event.getX()) && (b.y + b.height >= event.getY()) && (b.y <= event.getY())) {
                System.out.println("ID: " + b.id);
                selectedBox = b.id;
                if (goatTurn && b.isEmpty) {
                    goats.add(new Goat(b.x, b.y));
                    b.isEmpty = false;
                }
                break;
            }
        }
    }
    //mouse drag to move



    @Override
    public void mousePressed(MouseEvent event) {
        super.mouseDragged(event);
        // System.out.println(event.getPoint());
        for (Box b : boxes) {
            if (((b.x + b.width) >= event.getX() && b.x <= event.getX()) && (b.y + b.height >= event.getY()) && (b.y <= event.getY())) {
                start = b;
                break;
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        super.mouseReleased(event);
        for (Box b : boxes) {
            if (((b.x + b.width) >= event.getX() && b.x <= event.getX()) && (b.y + b.height >= event.getY()) && (b.y <= event.getY())) {
                end = b;
                break;
            }
        }
    }

    public static void main(String[] args) {
        createGame(new GameBoard(), 60);
    }
}
