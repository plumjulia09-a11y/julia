import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    private final int BREITE = 600;
    private final int HOEHE = 600;
    private final int FELD = 20;

    private ArrayList<Point> schlange;
    private Point essen;

    private int dx;
    private int dy;

    private int punkte;

    private Timer timer;
    private Random zufall = new Random();

    private boolean gameOver;


    public SnakeGame() {

        setPreferredSize(new Dimension(BREITE, HOEHE));
        setBackground(Color.BLACK);

        addKeyListener(this);
        setFocusable(true);

        spielStarten();
    }


    public void spielStarten() {

        schlange = new ArrayList<>();

        schlange.add(new Point(300, 300));
        schlange.add(new Point(280, 300));
        schlange.add(new Point(260, 300));

        dx = FELD;
        dy = 0;

        punkte = 0;
        gameOver = false;

        neuesEssen();


        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(100, this);
        timer.start();
    }



    public void neuesEssen() {

        int x = zufall.nextInt(BREITE / FELD) * FELD;
        int y = zufall.nextInt(HOEHE / FELD) * FELD;

        essen = new Point(x, y);
    }



    public void bewegen() {

        Point kopf = schlange.get(0);


        Point neuePosition = new Point(
                kopf.x + dx,
                kopf.y + dy
        );


        schlange.add(0, neuePosition);


        if (neuePosition.equals(essen)) {

            punkte++;
            neuesEssen();

        } else {

            schlange.remove(schlange.size() - 1);

        }



        if (kollision()) {

            gameOver = true;
            timer.stop();

        }
    }



    public boolean kollision() {

        Point kopf = schlange.get(0);


        // Wand
        if (kopf.x < 0 ||
                kopf.x >= BREITE ||
                kopf.y < 0 ||
                kopf.y >= HOEHE) {

            return true;
        }


        // eigener Körper
        for (int i = 1; i < schlange.size(); i++) {

            if (kopf.equals(schlange.get(i))) {

                return true;
            }
        }


        return false;
    }




    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);



        // Gitternetz
        g.setColor(new Color(45, 45, 45));


        for (int x = 0; x < BREITE; x += FELD) {

            g.drawLine(x, 0, x, HOEHE);

        }


        for (int y = 0; y < HOEHE; y += FELD) {

            g.drawLine(0, y, BREITE, y);

        }



        // Essen
        g.setColor(Color.RED);

        g.fillRect(
                essen.x,
                essen.y,
                FELD,
                FELD
        );



        // Schlange
        g.setColor(Color.GREEN);


        for (Point teil : schlange) {

            g.fillRect(
                    teil.x,
                    teil.y,
                    FELD,
                    FELD
            );
        }



        // Punkte
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));


        g.drawString(
                "Punkte: " + punkte,
                10,
                25
        );



        // Game Over Anzeige
        if (gameOver) {


            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));


            g.drawString(
                    "GAME OVER",
                    150,
                    280
            );


            g.setFont(new Font("Arial", Font.PLAIN, 20));


            g.drawString(
                    "Drücke R zum Neustarten",
                    150,
                    330
            );
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (!gameOver) {

            bewegen();

        }

        repaint();
    }





    @Override
    public void keyPressed(KeyEvent e) {


        int taste = e.getKeyCode();



        // Neustart
        if (taste == KeyEvent.VK_R && gameOver) {

            spielStarten();

        }



        // Bewegung
        if (taste == KeyEvent.VK_UP && dy == 0) {

            dx = 0;
            dy = -FELD;

        }



        if (taste == KeyEvent.VK_DOWN && dy == 0) {

            dx = 0;
            dy = FELD;

        }



        if (taste == KeyEvent.VK_LEFT && dx == 0) {

            dx = -FELD;
            dy = 0;

        }



        if (taste == KeyEvent.VK_RIGHT && dx == 0) {

            dx = FELD;
            dy = 0;

        }

    }



    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}





    public static void main(String[] args) {


        JFrame fenster = new JFrame("Snake");


        SnakeGame spiel = new SnakeGame();


        fenster.add(spiel);

        fenster.pack();

        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenster.setLocationRelativeTo(null);

        fenster.setVisible(true);

    }
}