public class Cube extends Shape3D{

    public Cube(double width){
        super(width);
    }

    String getName(){
        return "cube";
    }

    double getArea(){
        return 6 * width * width;
    }

    double getVolume(){
        return Math.pow(width, 3);
    }
}
