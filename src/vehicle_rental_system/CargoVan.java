package vehicle_rental_system;

public class CargoVan extends Vehicle {

	private int driversExperience;
	private final static double COST_PER_DAY_LESS = 50.0;
	private final static double COST_PER_DAY_MORE = 40.0;
	
	public CargoVan(String brand, String model, int value, int driversExperience) {
		super(brand, model, value,COST_PER_DAY_LESS, COST_PER_DAY_MORE);
		this.driversExperience = driversExperience;
	}

	public int getDriversExperience() {
		return driversExperience;
	}

	public void setDriversExperience(int driversExperience) {
		this.driversExperience = driversExperience;
	}

	@Override
	public double calculateTotalInsurance(int numberOfRentalDays) {
		double insuranceCostForSingleDay = getInsuranceCostForSingleDay();
		double totalInsurancePrice = numberOfRentalDays * insuranceCostForSingleDay;
		
		if(driversExperience > 5) {
			
			System.out.println("Initial insurance per day: $" + Math.round(insuranceCostForSingleDay * 100.0) / 100.0);

			double discount = getInsuranceCostForSingleDay() * 0.15;
 			System.out.println("Insurance discount per day: $" + Math.round(discount * 100.0) / 100.0);
 			
			System.out.println("Insurance per day: $" + (insuranceCostForSingleDay-discount) +"\n");
 			
			return totalInsurancePrice - totalInsurancePrice * 0.15;
		} else {
			return 0;
		}
	}

	@Override
	public double getInsuranceCostForSingleDay() {
		//0.03% of value of the cargoVan
		return Math.round((0.0003 * value *100) / 100); 
	}


}
