package main.test;

class Teglalap implements java.io.Serializable {
    /** Nem változó verziószám */
    static final long serialVersionUID = 5830705690428599645L;

    public Teglalap( int ax1, int ay1, int ax2, int ay2)  {
        x1 = ax1;  y1 = ay1;  x2 = ax2;  y2 = ay2;
    }
    public void print() {
        System.out.println( "Téglalap ("+x1+","+y1+","+x2+","+y2+")" );
    }
    private int x1, y1, x2, y2;
}