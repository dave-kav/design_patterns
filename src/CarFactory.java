
public class CarFactory implements IVehicleFactory {

	public IVehicle buildVehicle() {
		return new Car();
	}

}
