package noyau;

public abstract subject {

    private List<Observer> observers = new ArrayList<Observer>();
    
    public abstract void attach(Observer o);
    
    public abstract void detach(Observer o);
    
    public abstract void notifyObservers();
    
}