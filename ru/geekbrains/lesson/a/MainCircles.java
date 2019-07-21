package ru.geekbrains.lesson.a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

/*
	1. Полностью разобраться с кодом
	2. Прочитать методичку к следующему уроку
	3. Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	4. * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	5. ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
* */

public class MainCircles extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private int countBalls = 10;
    private int maxcountBalls = 20;
    private Sprite[] sprites = new Sprite[countBalls];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        mouseCliks();
        //3. Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
        BackGround gameCanvas = new BackGround(this);
        initBalls(0);
        add(gameCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

    private void mouseCliks() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    //4. * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
                    if (countBalls < maxcountBalls) {
                        countBalls++;
                        initBalls(countBalls-1);
                    }
                 //5. ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (countBalls > 0) {
                        countBalls--;
                        initBalls(countBalls);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

    }

    void initBalls(int index) {

       // System.arraycopy(sprites, 0, temp, 0, countBalls);
        Sprite[] temp = Arrays.copyOf(sprites, countBalls);
        sprites = temp;
        for (int i = index; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
