package teszt;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.text.*;

/**
Elérhető nyelvi környezetek listázása.
<P align="center"><APPLET code="elte.java2_utikalauz5.util.LocaleTeszt.class"
archive="{@docRoot}/../data/util/LocaleTeszt.jar" width=400 height=300>
<IMG src="{@docRoot}/../data/util/img/LocaleTeszt.png"></APPLET></P>

@link.forrásfájl {@docRoot}/../data/util/src LocaleTeszt.java
@link.letöltés {@docRoot}/../data/util LocaleTeszt.jar
@since Java 2 Útikalauz programozóknak
*/
public class LocaleTest extends Applet implements ItemListener {
    /** Verziószám. */
    private final static long serialVersionUID = 15L;

  private Locale locales[];
  boolean isStandalone = false;
  java.awt.List list = new java.awt.List();
  TextField textField = new TextField();

  public void init() {
    list.addItemListener(this);
    this.setLayout(new BorderLayout());
    this.add(list, BorderLayout.CENTER);
    this.add(textField, BorderLayout.NORTH);
    locales=DateFormat.getAvailableLocales();
    for (int i=0; i<locales.length; i++) {
        list.add(
        locales[i].getDisplayCountry()+"("+locales[i].getCountry()+
        ")["+locales[i].getISO3Country()+"]    "+
        locales[i].getDisplayLanguage()+"("+locales[i].getLanguage()+
        ")["+locales[i].getISO3Language()+"]"
        );
    }
  }

  
  public void itemStateChanged(ItemEvent e) {
      textField.setText(DateFormat.getDateTimeInstance(
                   DateFormat.SHORT, DateFormat.SHORT,
                   locales[list.getSelectedIndex()]).format(new Date()));
  }
}