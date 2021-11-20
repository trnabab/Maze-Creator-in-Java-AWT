import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Cell {
    private int x;
    private int y;
    int row;
    int col;
    private int size = 40;
    public boolean visited = false;
    boolean[] walls = {true, true, true, true};

    public Cell(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.col = col;
        this.row = row;
    }

    void paint(Graphics g){
        if(this.visited){
            g.setColor(Color.MAGENTA);
            g.fillRect(x,y,size,size);
        }
        
        g.setColor(Color.BLACK);

        if (walls[0]){
            g.drawLine(x, y, x+size, y);
        }
        if (walls[1]){
            g.drawLine(x+size, y, x+size, y+size);
        }
        if (walls[2]){
            g.drawLine(x+size, y+size, x, y+size);
        }
        if (walls[3]){
            g.drawLine(x, y+size, x, y);
        }

    }

    Cell checkNeighbours(){
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        Random random = new Random();

        Cell top = null;
        Cell right = null;
        Cell bottom = null;
        Cell left = null;

        if(this.col-1>=0){
            top = Grid.cells[this.row][this.col-1];
        }
        if(this.row+1<Grid.cells.length){
            right = Grid.cells[this.row+1][this.col];
        }
        if(this.col+1<Grid.cells.length){
            bottom = Grid.cells[this.row][this.col+1];
        }
        if(this.row-1>=0){
            left = Grid.cells[this.row-1][this.col];
        }

        if(top!=null && !top.visited){
            neighbours.add(top);
        }
        if(right!=null && !right.visited){
            neighbours.add(right);
        }
        if(bottom!=null && !bottom.visited){
            neighbours.add(bottom);
        }
        if(left!=null &&  !left.visited){
            neighbours.add(left);
        }

        if(neighbours.size()>0){
            return neighbours.get(random.nextInt(neighbours.size()));
        }
        return null;
    }

}
