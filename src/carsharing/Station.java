package carsharing;

import java.util.ArrayList;

public class Station {
  private int stationNumber;
  private ArrayList<Passenger> people;

  
  public Station(int number){
    setStationNumber(number);
    this.people = new ArrayList<Passenger>();
  }

  
  private void setStationNumber(int number){
    this.stationNumber = number;
  }

  
  public int getNumber(){
    return this.stationNumber;
  }
 
  public void add(Passenger p){
    this.people.add(p);
  }

 
  public Passenger get(int index){
    return this.people.get(index);
  }

  
  public boolean remove(Passenger p){
    return this.people.remove(p);
  }

 
  public ArrayList<Passenger> peopleWaitingList(){
    return this.people;
  }

  public String toString(){
    StringBuilder stringBuilderConcat = new StringBuilder()
      .append("The following people are at this station: ");
    for(Passenger p : this.peopleWaitingList()){
      stringBuilderConcat.append(" " + p);
    }
    return stringBuilderConcat.toString();
  }
}