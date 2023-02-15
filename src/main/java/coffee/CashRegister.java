package coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;


public class CashRegister {
  final int ticketWidth = 35;
  final String emptyLine = "                                   ";
  static Map<String, Double> offerings;
  static {
    offerings = new HashMap<>();
    offerings.put("Coffee small", 2.5 );
    offerings.put("Coffee medium", 3.0 );
    offerings.put("Coffee large", 3.5 );
    offerings.put("Bacon Roll", 4.5 );
    offerings.put("Fresh orange juice (0.25l)", 3.95 );
    offerings.put("Extra milk", 0.3 );
    offerings.put("Foamed milk", 0.5 );
    offerings.put("Special roast coffee", 0.9 );
  }	
  // Ticket data
  double total = 0;
  List< String > ticket = new ArrayList< String >();
  
	
  public boolean add( String item ) {
    if (!offerings.containsKey( item ))
      return false;
     
    // Could include some code to add a counter for items, as to show something like "2 Coffee medium  3.0 6.0"
    DecimalFormat df = new DecimalFormat("0.00");
    String line = df.format( offerings.get( item ));
    total += offerings.get( item );	
    line = item + emptyLine.substring(0, ticketWidth - item.length() - line.length() ) + line;
    ticket.add( line );	
	
    // Add item to store for client bought items, as to calculate bonuses
    // ...	
    return true;
  }
  
  
  public String[] prepareTicket( String client ) {
	  
    // Calculate bonuses

    // Add total
    DecimalFormat df = new DecimalFormat("0.00");
    String line = df.format( total );
    line = "Total:" + emptyLine.substring(0, ticketWidth - "Total:".length() - line.length() ) + line;
    ticket.add( "" );
    ticket.add( line );	
    return ticket.toArray( new String[ ticket.size() ] );
  }
  
  
  private String expand( String item ) {
    // Do some magic here to expand simple codes to full fledged descriptions
    // Simplifiy manual entries
    // I.e. cs for Coffee Small, etc. 
    return item;
  }


  void createTicket( String client ) {
    total = 0;
    ticket.clear();
    ticket.add( "Client: " + client );	  
    ticket.add( "" );
  }	  

  
  public void printTicket( String client, String[] items ) {
    createTicket( client );
    for (String item : items) {
      add( expand( item ));
    }
    String[] ticket = prepareTicket( client );
    for (String line : ticket) {
      System.out.println( line );
    }
  }


  public static void main( String[] args ) {
    CashRegister cashRegister = new CashRegister();
    String[] items = {
      "Coffee small",
      "Coffee large",
      "Extra milk",
      "Coffee medium",
      "Foamed milk",
      "Special roast coffee",
      "Bacon Roll"		
    };
    cashRegister.printTicket( "Client A", items );	  
  }

}

