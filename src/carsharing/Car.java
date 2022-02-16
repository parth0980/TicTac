package carsharing;

import java.util.ArrayList;
import java.util.Iterator;


public class Car {
  
  private int idNo;
  private int destination;
  private int location;
  private ArrayList<Passenger> passengers;
  private double faresCollected;
  private int milesDriven;
  final private double FARESPERMILE = 1.0;
  final private int MAXPASSENGERS = 3;
  
 
  public Car(int idNo, int location, int destination){
    this.setidNo(idNo);
    this.setLocation(location);
    this.setDesintation(destination);
    this.passengers = new ArrayList<Passenger>();
  }

  
  private void setidNo(int idNo){
    this.idNo = idNo;
  }
  
  private void setLocation(int location){
    this.location = location;
  }

 
  private void setDesintation(int desintation){
    this.destination = desintation;
  }

   private void setMilesDriven(int miles){
    this.milesDriven = this.milesDriven + miles;
  }

  
  private void setFaresCollected(int milesDriven){
    this.faresCollected += this.FARESPERMILE * milesDriven;
  }

  
  public int getIdNo(){
    return this.idNo;
  }

  /**
   * 
   * @return location
   */
  public int getLocation(){
    return this.location;
  }

   public int getDestination(){
    return this.destination;
  }

  
  public double getFares(){
    return this.faresCollected;
  }

  
  public int getMilesDriven(){
    return this.milesDriven;
  }

 
  public ArrayList<Passenger> getPassengers(){
    return this.passengers;
  }

  public boolean hasArrived(){
    return (this.getLocation() == this.getDestination()) ? true : false;
  }

  public boolean hasRoom(){
    return (this.getPassengers().size() < this.MAXPASSENGERS) ? true : false;
  }
  
  public void drive(){
    if (!this.hasArrived()){
      int MILES_TO_NEXT_STATION = 1;
      this.setLocation(this.getLocation() + MILES_TO_NEXT_STATION);
      this.setMilesDriven(MILES_TO_NEXT_STATION);
      
      //Collect fares based on passengers
      for(int i = 0; i < this.getPassengers().size(); i ++){
        this.setFaresCollected(MILES_TO_NEXT_STATION);
      }
      
      System.out.println(String.format("Car %d drives to station %d", this.getIdNo(), this.getLocation()));
    }
  }

  public boolean dropOff(){
    boolean result = false;
    Iterator<Passenger> iter = this.getPassengers().iterator();
    while(iter.hasNext()){
      Passenger passenger = iter.next();
      if(passenger.getDestimation() == this.getLocation()){
        result = true;
        iter.remove();
        System.out.println(String.format(
          "Car %d drops off %s at station %d. Car now has %d passengers", 
          this.getIdNo(), 
          passenger, 
          this.getLocation(),
          this.getPassengers().size()));
      }
    }
    return result;
  }

  
  public boolean add(Passenger p){
    boolean result = false;
    if(this.hasRoom()){
      this.passengers.add(p);
      result = true;
    }
    return result;
  }
 
  public String toString(){
    return String.format("Car[idNo=%d, location=%d, destination=%d, passengers=%s]",
    this.getIdNo(),
    this.getLocation(),
    this.getDestination(),
    this.getPassengers());
  }
}