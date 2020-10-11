public class Pyramid extends Shape3D{

    public Pyramid(double length, double width, double height){
        super(length, width, height);
    }

    String getName(){
        return "pyramid";
    }

    double getArea(){
        double area = (length * width) + calculateAreaComponent(length, width, height)
                      + calculateAreaComponent(width, length, height);

        return area;
    }

    double getVolume(){
        return (width * height * length) / 3;
    }

    double calculateAreaComponent(double x, double y, double z){
        double component = x * Math.sqrt( Math.pow(y/2, 2) + Math.pow(z, 2) );

        return component;
    }
}
