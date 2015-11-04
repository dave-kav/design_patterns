
public class VanFactory implements IVehicleFactory {

	public IVehicle buildVehicle() {
		return new Van();
	}

}
