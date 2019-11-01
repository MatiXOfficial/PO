package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.*;

import java.util.LinkedList;

public class RectangularMap implements IWorldMap
{
    private int width;
    private int height;
    private LinkedList<Animal> animals;

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
        animals = new LinkedList<>();
    }

    public Animal getAnimal(int pos)
    {
        if (pos >= animals.size())
            return null;
        return animals.get(pos);
    }

    public int getAnimalSize()
    {
        return animals.size();
    }

    private boolean isInTable(Vector2d position)
    {
        if (position.x < 0 || position.x >= width || position.y < 0 || position.y >= height)
            return false;
        return true;
    }

    public boolean canMoveTo(Vector2d position)
    {
        if (!isInTable(position))
            return false;
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public boolean place(Animal animal)
    {
        if (isOccupied(animal.getPosition()) || !isInTable(animal.getPosition()))
            return false;
        else
        {
            animals.add(animal);
            return true;
        }
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }

    public void run(MoveDirection[] directions)
    {
        for (int i = 0; i < directions.length; i++)
        {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Vector2d position)
    {
        if (!isInTable(position))
            return false;
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position)
    {
        if (!isInTable(position))
            return null;
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
}
