package vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
 

public class Planning extends JPanel {
	
  protected int yy;
  protected int mm, dd;
  protected JButton labs[][];
  protected int leadGap = 0;
 
  Calendar calendar = new GregorianCalendar();
 

  protected final int thisYear = calendar.get(Calendar.YEAR);
  protected final int thisMonth = calendar.get(Calendar.MONTH);
  private JButton b0;
 
  private JComboBox monthChoice;
  private JComboBox yearChoice;
  
  private JButton b_inscrire ;
  private JButton b_desinscrire ;
  private JPanel p_button, p_grille, p_south ;
  
 
  /**
   * Construit un calendrier commencant � la date actuelle
   */
  public Planning() {
    super();
    setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println(buildGUI());
    recompute();
    print_button() ;
  }
 
  /**
   * Construit un calendrier, en donnant le jour, mois, ann�e
   *
   * @exception IllegalArgumentException
   *                Si l'ann�e n'est pas correcte
   */
   public Planning(int year, int month, int today) {
    super();
    setYYMMDD(year, month, today);
    System.out.println(buildGUI());
    recompute();
    print_button() ;
  }
 
  private void setYYMMDD(int year, int month, int today) {
    yy = year;
    mm = month;
    dd = today;
  }
 
  String[] months = { "Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin",
      "Juillet", "Ao�t", "Septembre", "Octobre", "Novembre", "D�cembre" };
 

  private String buildGUI() {
    getAccessibleContext().setAccessibleDescription(
        "Calendrier non disponible, d�sol�");
    setBorder(BorderFactory.createEtchedBorder());
 
    setLayout(new BorderLayout());
 
    JPanel tp = new JPanel();
    tp.add(monthChoice = new JComboBox());
    
    for (int i = 0; i < months.length; i++)
      monthChoice.addItem(months[i]);
    
    monthChoice.setSelectedItem(months[mm]) ;
   
    monthChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        int i = monthChoice.getSelectedIndex();
        if (i >= 0) {
          mm = i;
        System.out.println("Mois=" + mm);
          recompute();
        }
      }
    });
    
    monthChoice.getAccessibleContext().setAccessibleName("Mois");
    monthChoice.getAccessibleContext().setAccessibleDescription(
        "Choisir mois");
 
    tp.add(yearChoice = new JComboBox());
    yearChoice.setEditable(true);
    
    for (int i = yy - 5; i < yy + 5; i++)
      yearChoice.addItem(Integer.toString(i));
    
    yearChoice.setSelectedItem(Integer.toString(yy));
    
    yearChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        int i = yearChoice.getSelectedIndex();
        if (i >= 0) {
          yy = Integer.parseInt(yearChoice.getSelectedItem()
              .toString());
          System.out.println("Annee=" + yy);
          recompute();
        }
      }
    });
    add(BorderLayout.NORTH, tp);
 
    JPanel bp = new JPanel();
    bp.setLayout(new GridLayout(7, 7));
    labs = new JButton[6][7];
 
    bp.add(b0 = new JButton("Dimanche"));
    bp.add(new JButton("Lundi"));
    bp.add(new JButton("Mardi"));
    bp.add(new JButton("Mercredi"));
    bp.add(new JButton("Jeudi"));
    bp.add(new JButton("Vendredi"));
    bp.add(new JButton("Samedi"));
 
    ActionListener dateSetter = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String num = e.getActionCommand();     
        
        if (!num.equals("")) {
          // met le jour actuel d'une couleur
          setDayActive(Integer.parseInt(num));
        }    
      }
    };
 
    
    // Ajout des boutons
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++) {
        bp.add(labs[i][j] = new JButton(""));
        labs[i][j].addActionListener(dateSetter);
      }
 
    add(BorderLayout.CENTER, bp);
    
    return (Integer.toString(yy) + Integer.toString(mm)) ;
  }
 
  public final static int dom[] = { 31, 28, 31, 30, /* jan fev mar avr */
  31, 30, 31, 31, /* mai juin juil aout */
  30, 31, 30, 31 /* sep oct nov dec */
  };
 
  /** Compute which days to put where, in the Cal panel */
  protected void recompute() {
    if (mm < 0 || mm > 11)
      throw new IllegalArgumentException("Mois " + mm
          + " bad, must be 0-11");
    clearDayActive();
    calendar = new GregorianCalendar(yy, mm, dd);
 
    leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;
 
    int daysInMonth = dom[mm];
    if (isLeap(calendar.get(Calendar.YEAR)) && mm == 1)
      ++daysInMonth;
 
    // R�initialise le label
    for (int i = 0; i < leadGap; i++) {
      labs[0][i].setText("");
    }
 
    for (int i = 1; i <= daysInMonth; i++) {
      JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
      b.setText(Integer.toString(i));
    }
 
    for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
      labs[(i) / 7][(i) % 7].setText("");
    }

    
    if (thisYear == yy && mm == thisMonth)
    	setDayActive(dd);
    
    // Recharge l'�cran
    repaint();
  }
 
  /**
   * isLeap() returns true if the given year is a Leap Year.
   *
   * "a year is a leap year if it is divisible by 4 but not by 100, except
   * that years divisible by 400 *are* leap years." -- Kernighan &#038; Ritchie,
   * _The C Programming Language_, p 37.
   */
  public boolean isLeap(int year) {
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
      return true;
    return false;
  }
 
  /** Set l'ann�e, le mois et le jour */
  public void setDate(int yy, int mm, int dd) {
    this.yy = yy;
    this.mm = mm; // commence a 0
    this.dd = dd;
    recompute();
  }
 
  /** Met � jour le jour actuel */
  private void clearDayActive() {
    JButton b;
 
    if (activeDay > 0) {
      b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
      b.setBackground(b0.getBackground());
      b.repaint();
      activeDay = -1;
    }
  }
 
  private int activeDay = -1;
 

  public void setDayActive(int newDay) {
 
    clearDayActive();
 
    // Entre le nouveau
    if (newDay <= 0)
      dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
    else
      dd = newDay; 

    Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
    square.setBackground(Color.red);
    square.repaint();
    activeDay = newDay;
    
  }
  
   public void setTaskDay(int newDay){  
	  	   
      Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];  

      square.setBackground(Color.yellow);  
      square.repaint();   
} 
   
  
  private void print_button() {
	  // rajouter bouton inscrire / d�sinscrire, si jour dispo ou non
	    
	    this.b_inscrire = new JButton("S'inscrire") ;
	    this.b_desinscrire = new JButton("Se d�sinscrire") ;
	       
	    b_inscrire.setEnabled(true) ;
	    b_desinscrire.setEnabled(false) ;
	    
	    this.p_grille = new JPanel() ;
	    this.p_button = new JPanel() ;
		this.p_south = new JPanel() ;
		
	    p_button.setLayout(new FlowLayout()) ;
	    p_grille.setLayout(new GridLayout(1, 2));
	    
	    p_button.add(p_grille) ;
	    p_grille.add(b_inscrire);
	    p_grille.add(b_desinscrire) ;
	    
	    p_south.add(p_button) ;
	    this.add(p_south, BorderLayout.SOUTH) ;
  }
  
  public void color_date(int day) {
	  setTaskDay(day) ;
  }

  
} 
