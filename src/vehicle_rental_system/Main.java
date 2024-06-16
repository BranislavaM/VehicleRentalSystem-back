package vehicle_rental_system;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		LocalDate invoiceDate = LocalDate.parse("2024-06-13");
		
		LocalDate startDate = LocalDate.parse("2024-06-03");
	    LocalDate endDate = LocalDate.parse("2024-06-13");
	    LocalDate actualReturnDate = LocalDate.parse("2024-06-13");
		  
		Invoice carInvoice = new Invoice("John Doe", invoiceDate, startDate, endDate, actualReturnDate, new Car("Mitsubishi", "Mirage", 15000, 3));
		carInvoice.createInvoice();
		
		Invoice motorcycleInvoice = new Invoice("Mary Johnson", invoiceDate, startDate, endDate, actualReturnDate, new Motorcycle("Triumph", "Tiger Sport 660", 10000, 20));
		motorcycleInvoice.createInvoice();

	    LocalDate endDate1 = LocalDate.parse("2024-06-18");
		Invoice cargoVanInvoice = new Invoice("John Markson", invoiceDate, startDate, endDate1, actualReturnDate, new CargoVan("Citroen", "Jumper", 20000, 8));
		cargoVanInvoice.createInvoice();
	}
}


