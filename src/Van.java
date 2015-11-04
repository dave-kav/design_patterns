import java.util.ArrayList;
import java.util.List;

public class Van implements MyObservable, IVehicle {

	private boolean status = false;
	protected List<MyObserver> observers = new ArrayList<MyObserver>();	

	public Van() {
		build();
	}

	@Override
	public void build() {
		System.out.println("New model of Van is currently under construction.");
	}

	@Override
	public void ready() {
		if (status)
			System.out.println("New model of Van ready for order");
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
			o.update(this);
		}	
	}
	
	@Override
	public void setChanged() {
		setStatus();
	}
	
	private void clearChanged() {
		status=false;
	}
}
