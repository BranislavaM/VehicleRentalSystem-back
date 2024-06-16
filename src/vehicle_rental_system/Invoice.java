package vehicle_rental_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Invoice {

	private LocalDate invoiceDate;
	private String user;

	private Vehicle vehicle;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate actualReturnDate;

	public Invoice(String user, LocalDate invoiceDate, LocalDate startDate, LocalDate endDate, LocalDate actualReturnDate, Vehicle vehicle) {
		super();
		
		this.user = user;
		this.invoiceDate = invoiceDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.actualReturnDate = actualReturnDate;
		this.vehicle = vehicle;
	}

	public void createInvoice () {
		long reservedRentalDays = ChronoUnit.DAYS.between(startDate, endDate);
		long actualRentalDays = ChronoUnit.DAYS.between(startDate, actualReturnDate);

		double rentalCostPerDay = vehicle.getRentalCostForSingleDay((int)actualRentalDays);

		System.out.println("XXXXXXXXXXX");
		System.out.println("Date: " +  Helper.formatDate(invoiceDate));
		System.out.println("Customer Name: " + user);
		System.out.println("Rented Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + "\n");
		
		System.out.println("Reservation start date: " + Helper.formatDate(startDate));
	    System.out.println("Reservation end date: " + Helper.formatDate(endDate));
	    System.out.println("Reserved rental days: " + reservedRentalDays + " days\n");
	    
	    System.out.println("Actual return date: " + Helper.formatDate(actualReturnDate));
	    System.out.println("Actual rental days: " + actualRentalDays + " days\n");
	    
	    System.out.println("Rental cost per day: " + Helper.formatCurrency(rentalCostPerDay));
	    
	    double totalInsurance = vehicle.calculateTotalInsurance((int)actualRentalDays);
	    double totalRent = vehicle.calculateTotalRent((int)actualRentalDays, (int)reservedRentalDays);
	    
	    System.out.println("Total rent:" + Helper.formatCurrency(totalRent));
	    System.out.println("Total insurance:" + Helper.formatCurrency(totalInsurance));
	    System.out.println("Total:" + Helper.formatCurrency(totalInsurance + totalRent));
	    System.out.println("XXXXXXXXXX\n");
	}
	
}
