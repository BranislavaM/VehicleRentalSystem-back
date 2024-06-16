package vehicle_rental_system;

public abstract class Vehicle {

	protected String brand;
	protected String model;
	protected int value;
    protected double costPerDayLessThanSevenDays;
    protected double costPerDayMoreThanSevenDays;
    
	public Vehicle() {
		super();
	}

	public Vehicle(String brand, String model, int value, double costPerDayLessThanSevenDays, double costPerDayMoreThanSevenDays) {
		super();
		this.brand = brand;
		this.model = model;
		this.value = value;
		this.costPerDayLessThanSevenDays = costPerDayLessThanSevenDays;
		this.costPerDayMoreThanSevenDays = costPerDayMoreThanSevenDays;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public double getCostPerDayLessThanSevenDays() {
		return costPerDayLessThanSevenDays;
	}

	public void setCostPerDayLessThanSevenDays(double costPerDayLessThanSevenDays) {
		this.costPerDayLessThanSevenDays = costPerDayLessThanSevenDays;
	}

	public double getCostPerDayMoreThanSevenDays() {
		return costPerDayMoreThanSevenDays;
	}

	public void setCostPerDayMoreThanSevenDays(double costPerDayMoreThanSevenDays) {
		this.costPerDayMoreThanSevenDays = costPerDayMoreThanSevenDays;
	}
	
	public double getRentalCostForSingleDay(int numberOfRentalDays) {
		return numberOfRentalDays >= 7 ? costPerDayMoreThanSevenDays : costPerDayLessThanSevenDays;
	}
	
	public abstract double getInsuranceCostForSingleDay(); 
	

	public double calculateTotalRent(int actualRentalDays, int reservedRentalDays) {
	
		double costPerDay = getRentalCostForSingleDay(actualRentalDays);
		
		if(actualRentalDays < reservedRentalDays) {
			//this means that the customer returned vehicle before reserved date
			//should half the price
			double fullReservedPeriodCost = actualRentalDays * costPerDay;
			double earlyReturnDiscount = ((reservedRentalDays - actualRentalDays) * costPerDay) / 2.0;
			
			System.out.println("Early return discount for rent: $ " + earlyReturnDiscount);
			
			//double fullInsurance = calculateTotalInsurance(actualRentalDays);
			//System.out.println("Early return discount for insurance: $ " + (fullInsurance - (reservedRentalDays - actualRentalDays) * getInsuranceCostForSingleDay()));
			

			return fullReservedPeriodCost + earlyReturnDiscount;
		} else {
			// rented for week or less & vehicle returned on schedule (on time)
			return actualRentalDays * costPerDay; 
		}
		
	}

	public abstract double calculateTotalInsurance(int actualRentalDays);
	
}
