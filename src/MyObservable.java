
public interface MyObservable {
	
	void addObserver(MyObserver o); 

	void setChanged();

	void notifyObservers();

}
