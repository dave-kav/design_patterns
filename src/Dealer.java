
public class Dealer implements MyObserver {
	
	private String name;
	
	public Dealer (String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public void update(MyObservable o) {
		if (o instanceof Car)
			System.out.println("Ordering New Car for: " + this.name);
		else if (o instanceof Van)
			System.out.println("Ordering new Van for: " + this.name);
	}
}
