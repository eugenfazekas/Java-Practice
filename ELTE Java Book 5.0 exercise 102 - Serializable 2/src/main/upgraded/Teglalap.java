package main.upgraded;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

class Teglalap implements java.io.Serializable {
    public Teglalap( Pont q1, Pont q2)  {
        p1 = q1;
        p2 = q2;
    }
    public void print() {
        System.out.println( "Téglalap ("+p1.x+","+p1.y+") ("+p2.x+","+p2.y+")" );
    }
    private Pont p1, p2;

    static final long serialVersionUID = 5830705690428599645L;

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("x1", Integer.TYPE),
        new ObjectStreamField("y1", Integer.TYPE),
        new ObjectStreamField("x2", Integer.TYPE),
        new ObjectStreamField("y2", Integer.TYPE),
    };
    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("x1", p1.x);
        fields.put("y1", p1.y);
        fields.put("x2", p2.x);
        fields.put("y2", p2.y);
        out.writeFields();
    }
    private void readObject(ObjectInputStream s) throws IOException {
	ObjectInputStream.GetField fields = null;
	try {
	    fields = s.readFields();
	} catch (Exception ClassNotFoundException) {
	throw new IOException();	    }

	int x1 = (int) fields.get("x1", 0);
	int y1 = (int) fields.get("y1", 0);
	int x2 = (int) fields.get("x2", 0);
	int y2 = (int) fields.get("y2", 0);
        p1 = new Pont( x1, y1);
	p2 = new Pont( x2, y2);
    }
    public static class Pont {
        public Pont( int ax, int ay)  {
            x = ax;
            y = ay;
        }
        public int x, y;
    }
}