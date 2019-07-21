package ru.geekbrains.lesson.a;

import java.awt.*;

public class BackGround extends GameCanvas{

    //3. Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
    private int drawSkipAll = 50; //пропуски отрисовок
    private int countDrawSkip = 0;

    BackGround(MainCircles gameWindow) {
        super(gameWindow);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        countDrawSkip++;

        if (countDrawSkip == drawSkipAll) {
            countDrawSkip = 0;
            setColorBackGround(this);
        }
    }

    void setColorBackGround(GameCanvas gameCanvas) {
        int red = (int)(Math.random() * 256f);
        int green = (int)(Math.random() * 256f);
        int blue = (int)(Math.random() * 256f);

        gameCanvas.setBackground(new Color(red, green, blue));

    }

}
