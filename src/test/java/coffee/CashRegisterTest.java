package coffee;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class CashRegisterTest {

	@Test
	void testBasics() {
	   CashRegister cr = new CashRegister();
	   cr.createTicket( "C001" );
	   cr.add( "C001", "Coffee small" );	   
	   String[] res = cr.prepareTicket( "C001" );
	   Assertions.assertEquals( 5, res.length, "We expect five lines" );
	   Assertions.assertEquals( "Client: C001", res[0], "First line must contain client name" );
	   Assertions.assertEquals( "", res[1], "Second line must be empty" );
	   Assertions.assertEquals( 35, res[2].length(), "Lines with amounts shloud have a length of 35 !" );	   	   
	   Assertions.assertEquals( true, res[2].contains( "Coffee small" ), "Should be a Coffee small" );
	   Assertions.assertEquals( true, res[2].contains( "2.50" ), "The amount should read 2.50" );
	   Assertions.assertEquals( "", res[3], "This line should be empty too" );
	   Assertions.assertEquals( "Total:                         2.50", res[4], "This line does not look like it should (contents, formatting, length ?)" );	   
	}
	
}
