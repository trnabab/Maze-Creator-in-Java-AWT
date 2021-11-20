import java.awt.*;

public class Grid {
    static Cell[][] cells = new Cell[10][10];
    Cell current;

    public Grid(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell(40*i,40*j, i, j);
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
        Cell next = current.checkNeighbours();
        if(next!=null){
            next.visited = true;

            removeWalls(current, next);

            current = next;
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
