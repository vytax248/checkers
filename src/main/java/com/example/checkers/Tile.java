package com.example.checkers;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static com.example.checkers.ColorSet.notPlayableColor;
import static com.example.checkers.ColorSet.playableColor;

public class Tile
{
    private final StackPane stackPane;
    private final Rectangle rectangle;
    private Piece piece;
    private Circle circle;
    private boolean playable;

    private final int x;
    private final int y;

    private Color currentColor;

    private Color defaultColor;

    private final Color selectedColor = ColorSet.selectedColor;

    private final Color possibleColor = ColorSet.possibleColor;


    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
        stackPane = new StackPane();
        rectangle = new Rectangle(100, 100);
        stackPane.getChildren().add(rectangle);
        setPlayable(false);
    }

    void setColor(Color color)
    {
        rectangle.setFill(color);
        currentColor = color;
    }

    public void setPlayable(boolean playable)
    {
        this.playable = playable;
        defaultColor = playable ? playableColor : notPlayableColor;
        setColor(defaultColor);
    }

    public void setSelected(boolean selected)
    {
        setColor(selected ? selectedColor : defaultColor);
    }

    public void setPossible(boolean possible)
    {
        setColor(possible ? possibleColor : defaultColor);
    }

    public StackPane getStackPane()
    {
        return stackPane;
    }

    public boolean hasPiece()
    {
        return piece != null;
    }

    public boolean isPlayable()
    {
        return playable;
    }

    public void placePiece(Piece piece)
    {
        this.piece = piece;
        this.circle = piece.getCircle();
        stackPane.getChildren().add(circle);
    }

    public void removePiece()
    {
        stackPane.getChildren().remove(circle);
        circle = null;
        piece = null;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public PieceColor getPieceColor()
    {
        return piece.getPieceColor();
    }
}
