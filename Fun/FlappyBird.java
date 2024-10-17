package Fun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, KeyListener {

    // Game variables
    public static FlappyBird flappyBird;
    public final int WIDTH = 800, HEIGHT = 600;
    public Renderer renderer;
    public Rectangle bird;
    public ArrayList<Rectangle> pipes;
    public int ticks, yMotion, score;
    public boolean gameOver, started;
    public Random rand;

    public FlappyBird() {
        // Create a new JFrame (game window)
        JFrame frame = new JFrame();
        Timer timer = new Timer(20, this);  // Game updates every 20 ms

        renderer = new Renderer();
        rand = new Random();

        frame.add(renderer);
        frame.setTitle("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setVisible(true);

        // Initialize game components
        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        pipes = new ArrayList<>();

        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);

        timer.start();
    }

    public void addPipe(boolean start) {
        int space = 300;  // Space between top and bottom pipe
        int width = 100;  // Width of each pipe
        int height = 50 + rand.nextInt(300);  // Random height for pipes

        if (start) {
            pipes.add(new Rectangle(WIDTH + width + pipes.size() * 300, HEIGHT - height - 120, width, height));
            pipes.add(new Rectangle(WIDTH + width + (pipes.size() - 1) * 300, 0, width, HEIGHT - height - space));
        } else {
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, 0, width, HEIGHT - height - space));
        }
    }

    public void paintPipe(Graphics g, Rectangle pipe) {
        g.setColor(Color.green.darker());
        g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
    }

    public void jump() {
        if (gameOver) {
            bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
            pipes.clear();
            yMotion = 0;
            score = 0;

            addPipe(true);
            addPipe(true);
            addPipe(true);
            addPipe(true);

            gameOver = false;
        }

        if (!started) {
            started = true;
        }

        if (yMotion > 0) {
            yMotion = 0;
        }

        yMotion -= 10;  // Move the bird upwards
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;
        ticks++;

        if (started) {
            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);
                pipe.x -= speed;  // Move pipes left
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;  // Gravity effect
            }

            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);

                if (pipe.x + pipe.width < 0) {
                    pipes.remove(pipe);

                    if (pipe.y == 0) {
                        addPipe(false);
                    }
                }
            }

            bird.y += yMotion;  // Bird's movement

            for (Rectangle pipe : pipes) {
                if (pipe.intersects(bird)) {
                    gameOver = true;

                    if (bird.x <= pipe.x) {
                        bird.x = pipe.x - bird.width;
                    }
                }
            }

            if (bird.y > HEIGHT - 120 || bird.y < 0) {
                gameOver = true;
            }

            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
            }
        }

        renderer.repaint();
    }

    public void repaint(Graphics g) {
        // Background color
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Ground color
        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);

        g.setColor(Color.green);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        // Bird color
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        // Pipes
        for (Rectangle pipe : pipes) {
            paintPipe(g, pipe);
        }

        // Game state text
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 50));

        if (!started) {
            g.drawString("Press SPACE to Start", 100, HEIGHT / 2 - 50);
        }

        if (gameOver) {
            g.drawString("Game Over!", 300, HEIGHT / 2 - 50);
        }

        if (!gameOver && started) {
            g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }
}

class Renderer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FlappyBird.flappyBird.repaint(g);
    }
}