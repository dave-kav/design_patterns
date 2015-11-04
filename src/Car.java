import java.util.ArrayList;

public class Car implements MyObservable, IVehicle {

	private boolean status = false;
	private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
	
	public Car() {
		build();
	}

	@Override
	public void build() {
		System.out.println("New model of Car is currently under construction.");
	}

	@Override
	public void ready() {
		if (status)
			System.out.println("New model of car ready for order.");
	}

	@Override
	public void setStatus() {
		status = true;
		ready();
		notifyObservers();
		clearChanged();
	}
	
	public void addObserver(MyObserver o) {
		observers.add(o);
	} 
	
	@Override
	public void notifyObservers() {
		for (MyObserver o: observers) {
			o.update((MyObservable)this);
		}
	}
	
	@Override
	public void setChanged() {
		setStatus();		
	}
	
	public void clearChanged() {
		status = false;
	}
}
