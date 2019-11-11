public class OptionParser
{
    public static MoveDirection[] parse(String[] tab)
    {
        MoveDirection[] dir = new MoveDirection[tab.length];
        int j = 0;
        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i].equals("f") || tab[i].equals("forward"))
            {
                dir[j] = MoveDirection.FORWARD;
                j++;
            }
            else if (tab[i].equals("b") || tab[i].equals("backward"))
            {
                dir[j] = MoveDirection.BACKWARD;
                j++;
            }
            else if (tab[i].equals("l") || tab[i].equals("left"))
            {
                dir[j] = MoveDirection.LEFT;
                j++;
            }
            else if (tab[i].equals("r") || tab[i].equals("right"))
            {
                dir[j] = MoveDirection.RIGHT;
                j++;
            }
            else
            {
                throw new IllegalArgumentException(tab[i] + " is not legal move specification");
            }
        }
        MoveDirection[] result = new MoveDirection[j];
        for (int i = 0; i < j; i++)
            result[i] = dir[i];
        return result;
    }
}
