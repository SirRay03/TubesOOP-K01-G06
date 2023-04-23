
// file sementara buat manggil rumah di sim

import java.util.*;

public class Rumah {
    private Point location; 
    private ArrayList<Ruangan> listofRuangan;

    public Rumah(Point location)
    {
        this.location = location;
        listofRuangan = new ArrayList<Ruangan>();
    }
}
