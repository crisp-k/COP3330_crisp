public class Sphere extends Shape3D{

    public Sphere(double width){
        super(width);
    }

    String getName(){
        return "sphere";
    }

    double getArea(){
        return 4 * Math.PI * Math.pow(width, 2);
    }

    double getVolume(){
        return (4 * Math.PI * Math.pow(width, 3)) / 3;
    }

}
