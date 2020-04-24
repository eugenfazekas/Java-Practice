package teszt;

/**
Író/olvasó probléma synchronized megoldással.

@link.forrásfájl {@docRoot}/../data/thread/src RWTeszt.java
@link.letöltés {@docRoot}/../data/thread RWTeszt.jar
@since Java 2 Útikalauz programozóknak
*/
class RWTeszt extends Thread {

  // az adatterület
  static public Integer data = new Integer(0);
  // az olvasók aktuális száma
  static Integer readerNum = new Integer(0);

  int ID;
  boolean running = true;

  RWTeszt(int ID) { super(); this.ID = ID; }

  public void run() {
    int dummy;
    System.out.println("indulok");
    while (running) {
      write( (int) (100.0 * Math.random())); // egy írás
      for(int i = 0; i < 1 + (int) (10.0 * Math.random()); i++)  {
        dummy = read(); // több olvasás
        try { sleep(10 + (int) (490.0 * Math.random())); }
        catch (InterruptedException e) {}
      }
    }
  }

  public void finish() { running = false; }

  public int read() {
    int readData;

    synchronized( readerNum ) {
      ++readerNum; // megnöveljük az olvasók számát
    }
    readData = data;
    System.out.println( "Read: " + ID + "-->" + readData);
    synchronized( readerNum ) {
      --readerNum; // le csökkentjük az olvsók számát
    }
    return readData;
  }

  public void write( int writeData ) {
    boolean success = false;
    while( !success ) {
      synchronized( readerNum ) {
        if( readerNum == 0 ) { // csak akkor írunk, ha nincs olvasó
          System.out.println( "Write:" + ID + "-->" + writeData);
          data = writeData;
          success = true;
        }
      }
      if( success == false ) {
        Thread.currentThread().yield();
      }
    }
  }

  static public void main(String args[]) {
    int id = 0;
    RWTeszt[] workers = new RWTeszt[10];
    for (int i = 0; i < workers.length; ++i) {
      workers[i] = new RWTeszt(i);
      workers[i].start();
    }
    try {
      Thread.sleep(12000);
    } catch (InterruptedException e) {}
    for (RWTeszt worker : workers) {
      worker.finish();
    }
  }
}