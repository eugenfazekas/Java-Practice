package test;

import java.io.*;

/**
Perzistens objektum specifikáció.

@link.forrásfájl {@docRoot}/../data/serial/src Persistent.java
@since Java 2 Útikalauz programozóknak
@author  Eric R Williams
*/
public interface Persistent{
    public void write(Persistent.Output out) throws IOException;
    public void  read(Persistent.Input in)   throws IOException;

    /**
    Perzistens bemeneti adatfolyam specifikáció.

    @since Java 2 Útikalauz programozóknak
    @author  Eric R Williams
    */
    interface Input extends DataInput{
        Persistent readPersistent() throws IOException;
    }

    /**
    Perzistens kimeneti adatfolyam specifikáció.

    @since Java 2 Útikalauz programozóknak
    @author  Eric R Williams
    */
    interface Output extends DataOutput{
        void writePersistent(Persistent obj) throws IOException;
    }

    /**
    Perzistens bemeneti adatfolyam megvalósítás.

    @since Java 2 Útikalauz programozóknak
    @author  Eric R Williams
    */
    class InputStream extends DataInputStream implements Input {
        public InputStream(java.io.InputStream in) {
            super(in);
        }
        public final Persistent readPersistent() throws IOException {
            Persistent obj = null;
            String cname = readUTF();

            if ( "null".equals(cname) ) {
                obj = null;
            }
            else {
                try {
                    Class c = Class.forName(cname);
                    obj = (Persistent) c.newInstance();
                    obj.read(this);
                }
                catch( ClassNotFoundException ee )
                {    throw new IOException(ee.toString());   }
                catch( InstantiationException ee )
                {    throw new IOException(ee.toString());   }
                catch( IllegalAccessException ee )
                {    throw new IOException(ee.toString());   }
            }
            return obj;
        }
    }

    /**
    Perzistens kimeneti adatfolyam megvalósítás.

    @since Java 2 Útikalauz programozóknak
    @author  Eric R Williams
    */
    class OutputStream extends DataOutputStream implements Output {
        public OutputStream(java.io.OutputStream out) {
            super(out);
        }

        public final void writePersistent(Persistent obj) throws IOException {
            if ( obj == null ) {
                writeUTF("null");
            }
            else {
                writeUTF(obj.getClass().getName());
                obj.write(this);
            }
        }
    }
}