public class Main{
    private String name;
    private String location;
    private int weight;

    public Main(String name){
        this.name = name;
        this.location = "shelf";
        this.weight = 1;
    }
    public Main(String name,String location){
        this.name = name;
        this.location = location;
        this.weight = 1;
    }
    public Main(String name,int weight){
        this.name = name;
        this.location = "shelf";
        this.weight = weight;
    }
    public String toString() {
        return"Main{name='" + name + "',location='" + location +"',weight='" + weight +"'}";
    }
    public static void main(String[] args){
        Main tapeMeasure = new Main("Tape measure");
        Main plaster = new Main("Plaster","home improvement section");
        Main tyre = new Main("Tyre", 5);

        System.out.println(tapeMeasure);
        System.out.println(plaster);
        System.out.println(tyre);
    }
}