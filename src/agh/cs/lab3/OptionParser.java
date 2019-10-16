package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class OptionParser
{
    public static MoveDirection[] parse(String[] tab)
    {
        MoveDirection[] dir = new MoveDirection[tab.length];
        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i].equals("f") || tab[i].equals("forward"))
                dir[i] = MoveDirection.FORWARD;
            else if (tab[i].equals("b") || tab[i].equals("backward"))
                dir[i] = MoveDirection.BACKWARD;
            else if (tab[i].equals("l") || tab[i].equals("left"))
                dir[i] = MoveDirection.LEFT;
            else if (tab[i].equals("r") || tab[i].equals("right"))
                dir[i] = MoveDirection.RIGHT;
        }
        return dir;
    }
}
