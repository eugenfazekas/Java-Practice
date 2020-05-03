package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.sql.*;
import java.applet.Applet;

/**
Példaprogram a JDBC használatának szemléltetésére.
<P align="center"><APPLET code="elte.java2_utikalauz5.jdbc.JDBCTeszt.class"
archive="{@docRoot}/../data/jdbc/JDBCTeszt.jar" width=400 height=400>
<IMG src="{@docRoot}/../data/jdbc/img/JDBCTeszt.png"></APPLET></P>
Ez a program egy általános JDBC adatbázis-elérési felületet nyújt.
Használható alkalmazásként és appletként, ilyenkor figyelembe kell venni a már ismertetett megkötéseket.
A program felületelemei:
<ul>
<li><em>Meghajtóprogram</em>-nak meg kell adni a használni kívánt JDBC meghajtóprogram nevét.
A dinamikus betöltés miatt ezen osztály kódjának elérhetőnek kell lennie!
<li><em>Betölt</em> gomb :
megnyomásakor betöltődik a megadott meghajtóprogram.
<li><em>Adatforrás</em> :
az elérni kívánt adatbázis URL-je, vagy az adatforrás JNDI neve.
<li><em>Felhasználó</em>, <em>Jelszó</em> :
a kapcsolódáshoz szükséges felhasználói azonosító és jelszó.
<li><em>Megnyit</em> gomb :
kapcsolatot nyit a megadott adatforráshoz.
<li><em>Sql</em> :
a dinamikusan végrehajtandó SQL utasítás.
Ez lehet lekérdezés, adatmanipuláció, vagy bármi, amit az adott adatbáziskezelő értelmezni tud.
<li><em>Eredmény</em> :
az SQL végrehajtás, és minden más művelet eredménye is itt látható.
<li><em>Töröl</em> gomb :
megnyomásakor törlődnek a régi eredmények.
<li><em>Végrehajt</em> gomb :
megnyomásakor végrehajtódik a beírt SQL utasítás.
<li><em>Elérhető táblák</em> gomb :
megnyomva kilistázódnak az elérhető táblák jellemzői.
</ul>
A program használata:
<ul>
<li> Először töltsük be a használni kívánt meghajtóprogramot.
<li> Ezután adjuk meg az elérni kívánt adatforrást, esetleg adjuk meg az eléréshez szükséges felhasználói azonosítót és jelszót is, majd hozzuk létre a kapcsolatot a \is{Megnyit} gomb megnyomásával.
Adatbázis-URL megadása esetén (tehát ha az adatforrás mező tartalma a <tt>jdbc:</tt> prefixszel kezdődik) a {@code DriverManager} segítségével történik a kapcsolatfelvétel, egyébként pedig a megadott név alapján megpróbál a program egy {@code DataSource} objektumhoz jutni a JNDI-n keresztül.
<li> Ezután bármilyen beírt SQL utasítás végrehajtható a <em>Végrehajt</em> gombbal.
</ul>
Eredménytáblák listázásakor minden sor előtt kijelezzük, hogy az adott soron érzékeltünk-e beszúrást (<b>I</b> oszlop/1. jel), módosítást (<b>U</b> oszlop/2. jel), vagy törlést (<b>D</b> oszlop/3. jel).
Ha itt kérdőjel áll, akkor a változtatások érzékelése nem támogatott, egyébként <b>+</b> vagy <b>-</b> jelöli, hogy történt-e adott változtatás, vagy sem.

@link.forrásfájl {@docRoot}/../data/jdbc/src JDBCTeszt.java
@link.letöltés {@docRoot}/../data/jdbc JDBCTeszt.jar
@see java.sql
@see javax.sql
@since Java 2 Útikalauz programozóknak 1.1
*/
public class JDBCTeszt extends JApplet implements ActionListener {
  /** Verziószám */
  private final static long serialVersionUID = 15L;

  /** Meghajtó betöltési gomb */
  JButton registerButton=new JButton("Betölt");                 // Felületelemek

  /** Meghajtóprogram neve */
  JTextField driver=new JTextField();

  /** Adatbáziskapcsolatot megnyitó nyomógomb */
  JButton connectButton=new JButton("Megnyit");

  /** Az elérni kívánt adatbázis url   jdbc:derby:sampleDB;create=true <--------------------*/ 
  JTextField url=new JTextField();

  /** A kapcsolódáshoz használt felhasználónév */
  JTextField userid=new JTextField(10);

  /** A kapcsolódáshoz használt jelszó */
  JPasswordField password=new JPasswordField(10);

  /** A végrehajtandó SQL utasítás */
  JTextArea sql=new JTextArea(5,80);

  /** Az SQL végrehajtás eredménye */
  JTextArea result=new JTextArea();

  /** Eredménykijelző törlése */
  JButton clearButton=new JButton("Töröl");

  /** SQL végrehajtás indítása */
  JButton execButton=new JButton("Végrehajt");

  /** Elérhető táblák kilistázása */
  JButton listButton=new JButton("Elérhető táblák");

  /** GUI-t felépítő konstruktor */
  public JDBCTeszt() {
    JPanel panel=new JPanel(new GridLayout(3, 1));         // Felület felépítése
    JPanel driverpanel=new JPanel(new BorderLayout());
    driverpanel.add("West", new JLabel("Meghajtóprogram: "));
    driverpanel.add("Center", driver);
    registerButton.addActionListener(this);
    driverpanel.add("East", registerButton);
    panel.add(driverpanel);
    JPanel urlpanel=new JPanel(new BorderLayout());
    urlpanel.add("West", new JLabel("Adatforrás: "));
    urlpanel.add("Center", url);
    urlpanel.add("East", connectButton);
    connectButton.addActionListener(this);
    panel.add(urlpanel);
    JPanel passpanel=new JPanel();
    passpanel.add(new JLabel("Felhasználó:"));
    passpanel.add(userid);
    passpanel.add(new JLabel("Jelszó:"));
    password.setEchoChar('*');
    passpanel.add(password);
    panel.add(passpanel);
    getContentPane().add("North", panel);
    JPanel textPanel=new JPanel(new BorderLayout());
    JPanel sqlPanel=new JPanel(new BorderLayout());
    sqlPanel.add("North", new JLabel("Sql:"));
    sqlPanel.add("Center", new JScrollPane(sql));
    textPanel.add("North", sqlPanel);
    JPanel resultPanel=new JPanel(new BorderLayout());
    resultPanel.add("North", new JLabel("Eredmény:"));
    result.setEditable(false);
    result.setFont(new Font("Monospaced", Font.PLAIN, 10));
    resultPanel.add("Center", new JScrollPane(result));
    textPanel.add("Center", resultPanel);
    getContentPane().add("Center", textPanel);
    JPanel buttonPanel=new JPanel();
    clearButton.addActionListener(this);
    buttonPanel.add(clearButton);
    execButton.addActionListener(this);
    buttonPanel.add(execButton);
    listButton.addActionListener(this);
    buttonPanel.add(listButton);
    getContentPane().add("South", buttonPanel);
    validate();                            // Lássuk a meghajtóprogram üzeneteit
    DriverManager.setLogWriter(new java.io.PrintWriter(System.out));
  }

  /**
    Gombnyomás kezelése.

    @param evt gombnyomás esemény
  */
  public void actionPerformed(ActionEvent evt) {             //gombok lekezelése
    if (evt.getSource()==clearButton) result.setText(""); //eredménymező törlése
    else if (evt.getSource()==registerButton)
        register(driver.getText());              //meghajtóprogram regisztrálása
    else if(evt.getSource()==connectButton) connect();//kapcsolódás adatbázishoz
    else if (evt.getSource()==listButton) tablelist();        //táblák listázása
    else if (evt.getSource()==execButton && sql.getText().trim().length()>0)
         execute(sql.getText());                                   //végrehajtás
    kiir("");                                                        //soremelés
  }

  /**
    Indítás alkalmazásként.

    @param args Indítási paraméterek
  */
  public static void main (String args[]) {            // indítás alkalmazásként
    JDBCTeszt myJDBCtest=new JDBCTeszt();
    JFrame frame=new JFrame(myJDBCtest.getClass().getName()+" alkalmazás");
    frame.addWindowListener(
        new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                   System.exit(0);                        //kilépés a programból
            }
        }
    );
    frame.getContentPane().add("Center", myJDBCtest);
    frame.setSize(400, 400);
    frame.setVisible(true);
  }

  /**
    Szöveg megjelenítése az eredménymezőben.

    @param text A megjelenítendő szöveg
  */
  private void kiir(String text) {
    result.append(text+"\n");
  }

  /**
    Szöveg adott hosszra formázása.

    @param s A formázandó szöveg
    @param width Szöveg kívánt hossza karakterekben
  */
  private String formaz(String s, int width) {
    StringBuffer sb;
    if (s==null) sb=new StringBuffer("null");
    else sb=new StringBuffer(s);
    sb.setLength(width);
    while (width>0 && sb.charAt(--width)=='\u0000') sb.setCharAt(width, ' ');
    return sb.toString();
  }

  /**
    Hiba kijelzése.

    @param s Hibaszöveg
    @param e A fellépett kivétel
  */
  private void hiba(String s, Throwable e) {
    kiir("--- HIBA ---");
    kiir(s+"!");
    kiir(e.toString());
    if (e instanceof SQLException) SQLhibu((SQLException)e);
  }

  /**
    SQL hiba kijelzése.
    A hiba fajtájától függően részletes adatokat jelenít meg, valamint a hibaláncon is végigmegy.

    @param e Listázandó hiba
  */
  private void SQLhibu(SQLException e) {    //hibák/figyelmeztetések kilistázása
    String s=e instanceof SQLWarning ? "Figyelmeztetés" : "Hiba";
    while (e!=null) {
          kiir("SQLState: "+e.getSQLState());
          kiir(s+" szövege: "+e.getMessage());
          kiir(s+" kódja: "+e.getErrorCode());
          if (e instanceof DataTruncation) {         //DataTruncation lekezelése
             DataTruncation dt=(DataTruncation)e;
             String ds=". ";
             ds+=dt.getParameter() ? "paraméter " : "oszlop ";
             ds+=dt.getRead() ? "olvas" : "ír";
             kiir("Adatcsonkítás a(z) "+dt.getIndex()+ds+"ásakor: "+
                  dt.getDataSize()+" -> "+dt.getTransferSize());
          }
          e=e instanceof SQLWarning ? ((SQLWarning)e).getNextWarning()    //lánc
                                    : e.getNextException();          // követése
       }
  }

  /**
    SQL figyelmeztetés kijelzése.

    @param w Listázandó figyelmeztetés
  */
  private boolean figyu(SQLWarning w) {           //figyelmeztetések kilistázása
    if (w!=null) {
       kiir("--- FIGYELMEZTETÉS ---\n"+w);
       kiir(w.toString());
       SQLhibu(w);
       return true;
    }
    return false;
  }

  /**
    Eredménytábla kilistázása.

    @param rs A listázandó eredménytábla
    @throws java.sql.SQLException Kijelzés közben fellépett hiba
  */
  private void tablakiir(ResultSet rs) throws SQLException {     //eredménytábla
    boolean insert = false;
    boolean update = false;
    boolean delete = false;
    int widths[];                                                 // kilistázása
    String s="   ";            // Insert Update Delete detektálását jelző oszlop
    kiir("IUD --- Tábla eleje ---");
    ResultSetMetaData rsmd = rs.getMetaData();
    int numCols = rsmd.getColumnCount();
    widths=new int[numCols];
    for (int i=1; i<=numCols; i++) {              //oszlopok fejléceinek kiírása
        s+=" ";
        widths[i-1]=Math.max(rsmd.getColumnDisplaySize(i),
                             rsmd.getColumnLabel(i).length());
        s+=formaz(rsmd.getColumnLabel(i), widths[i-1]);
    }
    kiir(s);
    boolean jdbc2 = true;
    try {                                                             //JDBC 2.0
        DatabaseMetaData meta = rs.getStatement().getConnection().getMetaData();
        insert = meta.insertsAreDetected(rs.getType());
        update = meta.updatesAreDetected(rs.getType());
        delete = meta.deletesAreDetected(rs.getType());
        rs.setFetchDirection(ResultSet.FETCH_FORWARD);
    } catch (Exception se) {jdbc2=false;}                       //nem támogatott
    while (rs.next()) {                            //tábla tartalmának listázása
          if (jdbc2) try {                                            //JDBC 2.0
              rs.refreshRow();                //a legaktuálisabb adatok kellenek
          } catch (SQLException se) {jdbc2=false;} //régi JDBC még nem tudta ezt
          s="";                             // detektált változtatások listázása
          if (insert) s+=(rs.rowInserted() ? "+" : "-");
          else s+="?";
          if (update) s+=(rs.rowUpdated() ? "+" : "-");
          else s+="?";
          if (delete) s+=(rs.rowDeleted() ? "+" : "-");
          else s+="?";
          for (int i=1; i<=numCols; i++) {       //aktuális sor mezőinek kiírása
              s+=" ";
              s+=formaz(rs.getString(i), widths[i-1]);
          }
          kiir(s);
          if (figyu(rs.getWarnings())) rs.clearWarnings();        //adatvesztés?
    }
    kiir("    --- Tábla vége ---");
    if (figyu(rs.getWarnings())) rs.clearWarnings();
  }

  /**
    Meghajtóprogram regisztrálása.

    @param meghajtóprogramnév A regisztrálandó meghatóprogram neve
  */
  private void register(String meghajtóprogramnév) {      //driver regisztrálása "org.apache.derby.jdbc.EmbeddedDriver"
    try {
        Driver d=(Driver)Class.forName(meghajtóprogramnév).newInstance();
        kiir("Regisztrált meghajtóprogram: "+driver.getText());
        kiir("Verzió: "+d.getMajorVersion()+"."+d.getMinorVersion());
        String s;
        if (!d.jdbcCompliant()) s=" nem ";
        else s=" ";
        kiir("Ez a meghajtóprogram"+s+"JDBC-megfelelő.");
    } catch (IllegalAccessException iae) {
        hiba("Nem sikerült a regisztráció", iae);
    } catch (InstantiationException ie) {
        hiba("Nem sikerült a regisztráció", ie);
    } catch (ClassNotFoundException cnfe) {
        hiba("Nem található a meghajtóprogram", cnfe);
    }
  }

  /**
    Adatbáziskapcsolat kérése.

    @throws java.sql.SQLException Fellépett hiba
    @return új adatbáziskapcsolat és törli a figyelmeztetéseket
  */
  private Connection getConnection() throws SQLException {    //kapcsolat kérése
    return getConnection(true);                       //figyelmeztetések törlése
  }

  /**
    Adatbáziskapcsolat kérése.

    @param clearwarnings Törölje-e az eddigi figyelmeztetéseket
    @throws java.sql.SQLException Fellépett hiba
    @return új adatbáziskapcsolat
  */
  private Connection getConnection( boolean clearwarnings ) throws SQLException{
    String adatbázisurl = url.getText();
    String felhasználónév = userid.getText();
    String jelszó = new String(password.getPassword());

    Connection con = null;
    if (adatbázisurl.startsWith("jdbc:")) con =     //adatbázis URL-en keresztül
       DriverManager.getConnection( adatbázisurl, felhasználónév, jelszó );
    else try { con =                               //vagy adatforráson keresztül
         ((DataSource)new javax.naming.InitialContext().lookup(adatbázisurl)).
                      getConnection(felhasználónév, jelszó );
    } catch (javax.naming.NamingException ne) {
         throw new SQLException("JNDI hiba: " + ne);
    }
    if (clearwarnings) con.clearWarnings(); //esetleges figyelmeztetések törlése
    return con;
  }

  /**
    Adatbáziskapcsolat bontása.

    @param con Lezárandó adatbáziskapcsolat
  */
  private void closeConnection(Connection con) {             //kapcsolat bontása
    if (con != null ) try {
        if (figyu(con.getWarnings())) con.clearWarnings();    //figyelmeztetések
        con.close();
    } catch (SQLException se) {
        hiba("Kapcsolat lezárása sikertelen", se);
    }
  }

  /** Kapcsolódás az adatbázishoz */
  private void connect() {
    Connection con = null;
    try {
        con = getConnection(false);             //figyelmeztetések nem törlôdnek
        DatabaseMetaData meta=con.getMetaData();            //adatbázisjellemzők
        kiir("Megnyitott adatbázis címe: "+meta.getURL());
        kiir("Felhasználó azonosítója: "+meta.getUserName());
        kiir("Adatbázis típusa: "+meta.getDatabaseProductName()+
             " "+meta.getDatabaseProductVersion());
        kiir("Felhasznált meghajtóprogram: "+meta.getDriverName()+
             " "+meta.getDriverVersion());
    } catch (SQLException se) {
      hiba("Nem sikerült a kapcsolat megnyitása", se);
    } finally {
      closeConnection(con);
    }
  }

  /** Táblák kilistázása */
  private void tablelist() {
    Connection con = null;
    try {
        con = getConnection();                            //kapcsolat felépítése
        kiir("Táblák listázása:");
        tablakiir( con.getMetaData().getTables(null, null, null, null) );
    } catch (SQLException se) {
        hiba("Nem sikerült a táblák listázása", se);
    } finally {
      closeConnection(con);
    }
  }

  /**
    Utasítás lezárása.

    @param stmt lezárandó utasítás
  */
  private void closeStatement( Statement stmt ) {
    if (stmt != null ) try {
        if (figyu(stmt.getWarnings())) stmt.clearWarnings();  //figyelmeztetések
        stmt.close();
    } catch (SQLException se) {
        hiba("Statement lezárása sikertelen", se);
    }
  }

  /**
    SQL végrehajtása.

    @param sql végrehajtandó sql
  */
  private void execute( String sql ) {
    Connection con = null;
    Statement stmt = null;
    try {
        con = getConnection();                            //kapcsolat felépítése
        kiir("Végrehajtandó SQL: "+con.nativeSQL(sql));
        try {                                                         //JDBC 2.0
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException se) {        //talán csak a régebbi verzió működik
            stmt = con.createStatement();
        }
        boolean wasRS = stmt.execute(sql);
        int rowCount;
        while (true)  {                       //eredménykomponensek feldolgozása
              if (wasRS) {           //következő eredménykomponens eredménytábla
                 ResultSet rs = stmt.getResultSet();
                 if (rs != null) {
                    tablakiir(rs);                     //eredménytábla kiiratása
                    wasRS=stmt.getMoreResults();   //következő eredménykomponens
                    continue;                                     //feldolgozása
                 }
                 break;                           //nincs több eredménykomponens
              }
              rowCount = stmt.getUpdateCount();           //sormódosítás történt
              if (rowCount >= 0) {
                 kiir("Megváltozott sorok száma = " + rowCount);
                 wasRS = stmt.getMoreResults();    //következő eredménykomponens
                 continue;                                        //feldolgozása
              }
              break;                              //nincs több eredménykomponens
        }
        kiir("Végrehajtás befejezve.");
    } catch (SQLException se) {
      hiba("Nem sikerült a végrehajtás", se);
    } finally {
      closeStatement(stmt);
      closeConnection(con);
    }
  }
}