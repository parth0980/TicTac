package carsharing;


public class Passenger {
  
  private String name;
  private int destination;
  
    public Passenger(String name, int destination){
    this.setName(name);
    this.setDesintation(destination);
  }

 
  private void setName(String name){
    this.name = name;
  }

    private void setDesintation(int desintation){
    this.destination = desintation;
  }

  public int getDestimation(){
    return this.destination;
  }

  public String toString(){
    return String.format("%s->%d", this.name, this.getDestimation());
  }
}