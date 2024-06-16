package vehicle_rental_system;

public class Motorcycle extends Vehicle{

	int ridersAge;
	private final static double COST_PER_DAY_LESS = 15.0;
	private final static double COST_PER_DAY_MORE = 10.0;
	
	public Motorcycle(String brand, String model, int value, int ridersAge) {
		super(brand, model, value, COST_PER_DAY_LESS, COST_PER_DAY_MORE);
		this.ridersAge = ridersAge;
	}

	public int getRidersAge() {
		return ridersAge;
	}

	public void setRidersAge(int ridersAge) {
		this.ridersAge = ridersAge;
	}

	@Override
	public double calculateTotalInsurance(int numberOfRentalDays) {
		double insuranceCostForSingleDay = getInsuranceCostForSingleDay();
		double fullInsurancePrice = insuranceCostForSingleDay * numberOfRentalDays;
		
		if(ridersAge < 25) {
			System.out.println("Initial insurance per day: $" + insuranceCostForSingleDay);
			
			double addition = insuranceCostForSingleDay * 0.20;
			System.out.println("Insurance addition per day: $" + addition);
			
			System.out.println("Insurance per day: $" + (insuranceCostForSingleDay + addition) + "\n");
			
			return fullInsurancePrice + fullInsurancePrice * 0.20;  
		}
		
		return fullInsurancePrice;
	}

	@Override
	public double getRentalCostForSingleDay(int numberOfRentalDays) {
		return numberOfRentalDays >= 7 ? COST_PER_DAY_MORE : COST_PER_DAY_LESS;
	}

	@Override
	public double getInsuranceCostForSingleDay() {
		//0.02% of the value of motorcycle
		return Math.round((0.0002 * value *100) / 100); 
	}

}
