import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
    private int totalMoves;
    private int moves;
    private List<Vampire> vampires;
    private int playerX;
    private int playerY;
    private final int maxX;
    private final int maxY;
    private final char[][] map;
    private int numberOfVampires;

    {
        this.vampires = new ArrayList<Vampire>();
    }

    public Dungeon(int maxX, int maxY, int numberOfVampires, int moves) {
        this.maxX = maxX;
        this.maxY = maxY;
        map = new char[maxX][maxY + 1];
        this.moves = moves;
        this.totalMoves = moves;
        this.numberOfVampires = numberOfVampires;
        addVampires(this.numberOfVampires);
    }

    public void reload() {
        this.playerX = 0;
        this.playerY = 0;
        for(int i = 0; i < this.maxX; i++)
            for(int j = 0; j < this.maxY; j++)
                this.map[i][j] = '.';
        this.vampires.clear();
        addVampires(this.numberOfVampires);
        this.moves = this.totalMoves;
    }

    public int getMoves() {
        return moves;
    }

    public void printStatus() {
        System.out.println("Current coordinates: (" + playerX + ", " + playerY + ")");
        if (vampires != null)
            vampires.forEach(System.out::println);
        System.out.println("Moves left: " + moves);
    }

    public void refreshMap() {
        moveVampires();
        checkStatus();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                map[i][j] = '.';
            }
            map[i][maxY] = '\n';
        }
        
        for(var v : this.vampires)
        {
            this.map[v.getX()][v.getY()] = 'v';
        }
        this.map[this.playerX][this.playerY] = '@';
    }

    public void drawMap() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    public boolean isItWin() {
        return vampires != null && vampires.size() == 0;
    }

    public void movePlayer(Direction direction) {
        if(((this.playerX + direction.getY()) < this.maxX)
        && ((this.playerY + direction.getX()) < this.maxY)
        && ((this.playerX + direction.getY()) >= 0)
        && ((this.playerY + direction.getX()) >= 0))
        {
            // :')
            this.playerX += direction.getY();
            this.playerY += direction.getX();
            this.moves--;
        }
    }

    private void checkStatus() {
        for(int i = 0; i < this.vampires.size(); i++)
        {
            if(this.vampires.get(i).getX() == this.playerX
            && this.vampires.get(i).getY() == this.playerY)
            {
                this.vampires.remove(i);
            }
        }
    }

    private void moveVampires() {
        Random r = new java.util.Random();
        for(var v : this.vampires)
        {
            if(r.nextBoolean())
            {
                var rnd = r.nextInt(4);
                switch(rnd)
                {
                    case 0: v.move(Direction.LEFT, this.maxX, this.maxY); break;
                    case 1: v.move(Direction.RIGHT, this.maxX, this.maxY); break;
                    case 2: v.move(Direction.UP, this.maxX, this.maxY); break;
                    case 3: v.move(Direction.DOWN, this.maxX, this.maxY); break;
                }
            }
        }
    }

    private void addVampires(int number) {
        for(int i = 0; i < number; i++)
        {
            var vamp = new Vampire(this.maxX, this.maxY);
            boolean add = true;
            for(int j = 0; j < this.vampires.size(); j++)
            {
                if(!vamp.isDifferentThanCoordinates(this.vampires.get(j))
                || !vamp.isDifferentThanCoordinates(playerX, playerY))
                {
                    add = false;
                    i--;  // if addition failed, try again
                    break;
                }
            }
            if(add)
            {
                this.vampires.add(vamp);
            }
        }
    }
}
