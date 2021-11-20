import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Grid {
    static Cell[][] cells = new Cell[50][50];
    Cell current;
    List<Cell> stack = new ArrayList<Cell>();

    public Grid(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell(Cell.size*i,Cell.size*j, i, j);
            }
        }

        current = cells[0][0];

    }

    public void paint(Graphics g){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j].paint(g);
            }
        }
        current.visited = true;
        current.highlight(g);
        Cell next = current.checkNeighbours();
        if(next!=null){
            next.visited = true;

            stack.add(current);

            removeWalls(current, next);

            current = next;
        } else if (stack.size()>0){
            current = stack.remove(stack.size()-1);
        }
    }

    void removeWalls(Cell a, Cell b){
        int x = a.row - b.row;
        if(x==1){
            a.walls[3] = false;
            b.walls[1] = false;
        }else if(x==-1){
            a.walls[1] = false;
            b.walls[3] = false;
        }

        int y = a.col- b.col;
        if(y==1){
            a.walls[0] = false;
            b.walls[2] = false;
        }
        if(y==-1){
            a.walls[2] = false;
            b.walls[0] = false;
        }
    }
}
