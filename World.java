public class World{
    public int height; //lebar
    public int width; //panjang
    private ArrayList<Point> listofRumah;
    private char[][] grid;


    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        listofRumah = new ArrayList<Point>;
    }

    public void Map() {
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '*');
        }
    }


    public void addRumah(int x, int y) {
        grid[y][x] = ' ';
        //masukin point rumah ke listofRumah
        listofRumah.add(x,y);


    }

    public void displayWorld() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void main(String[] args){
        displayWorld();
    }
}

