package coffee;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class CashRegisterTest {
	final int ticketWidth = 35;

	@Test
	void testBasics() {
	   CashRegister cr = new CashRegister();
	   cr.createTicket( "C001" );
	   cr.add( "Coffee small" );
	   String[] res = cr.prepareTicket( "C001" );
	   Assertions.assertEquals( 5, res.length, "We expect five lines" );
	   Assertions.assertEquals( "Client: C001", res[0], "First line must contain client name" );
	   Assertions.assertEquals( "", res[1], "Second line must be empty" );
	   Assertions.assertEquals( ticketWidth, res[2].length(), "Lines with amounts should have a length of 35 !" );
	   Assertions.assertEquals( true, res[2].contains( "Coffee small" ), "Should be a Coffee small" );
	   Assertions.assertEquals( true, res[2].contains( "2.50" ), "The amount should read 2.50" );
	   Assertions.assertEquals( "", res[3], "This line should be empty too" );
	   Assertions.assertEquals( "Total:                         2.50", res[4], "This line does not look like it should (contents, formatting, length ?)" );	   
	}


	@Test
	void testUnknownOffering() {
	   CashRegister cr = new CashRegister();
	   cr.createTicket( "C001" );
	   cr.add( "Coffee small" );
	   cr.add( "XXXXX" );
	   String[] res = cr.prepareTicket( "C001" );
	   Assertions.assertEquals( 5, res.length, "We expect five lines" );
	   Assertions.assertEquals( "Client: C001", res[0], "First line must contain client name" );
	   Assertions.assertEquals( "", res[1], "Second line must be empty" );
	   Assertions.assertEquals( ticketWidth, res[2].length(), "Lines with amounts should have a length of 35 !" );
	   Assertions.assertEquals( true, res[2].contains( "Coffee small" ), "Should be a Coffee small" );
	   Assertions.assertEquals( true, res[2].contains( "2.50" ), "The amount should read 2.50" );
	   Assertions.assertEquals( "", res[3], "This line should be empty too" );
	   Assertions.assertEquals( "Total:                         2.50", res[4], "This line does not look like it should (contents, formatting, length ?)" );	   
	}

	@Test
	void testRepeatedUse() {
		CashRegister cr = new CashRegister();
		String[] res = null;

		cr.createTicket( "C001" );
		cr.add( "Coffee small" );
		res = cr.prepareTicket( "C001" );
		Assertions.assertEquals( 5, res.length, "We expect five lines" );
		Assertions.assertEquals( "Client: C001", res[0], "First line must contain client name" );
		Assertions.assertEquals( "", res[1], "Second line must be empty" );
		Assertions.assertEquals( ticketWidth, res[2].length(), "Lines with amounts should have a length of 35 !" );
		Assertions.assertEquals( true, res[2].contains( "Coffee small" ), "Should be a Coffee small" );
		Assertions.assertEquals( true, res[2].contains( "2.50" ), "The amount should read 2.50" );
		Assertions.assertEquals( "", res[3], "This line should be empty too" );
		Assertions.assertEquals( "Total:                         2.50", res[4], "This line does not look like it should (contents, formatting, length ?)" );

		cr.createTicket( "C002" );
		cr.add( "Coffee medium" );
		res = cr.prepareTicket( "C002" );
		Assertions.assertEquals( 5, res.length, "We expect five lines" );
		Assertions.assertEquals( "Client: C002", res[0], "First line must contain client name" );
		Assertions.assertEquals( "", res[1], "Second line must be empty" );
		Assertions.assertEquals( ticketWidth, res[2].length(), "Lines with amounts should have a length of 35 !" );
		Assertions.assertEquals( true, res[2].contains( "Coffee medium" ), "Should be a Coffee medium" );
		Assertions.assertEquals( true, res[2].contains( "3.00" ), "The amount should read 3.00" );
		Assertions.assertEquals( "", res[3], "This line should be empty too" );
		Assertions.assertEquals( "Total:                         3.00", res[4], "This line does not look like it should (contents, formatting, length ?)" );
	}

}

