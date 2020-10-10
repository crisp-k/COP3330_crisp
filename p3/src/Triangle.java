public class Triangle extends Shape2D{

    public Triangle(double width, double height){
        super(width, height);
    }

    String getName(){
        return "triangle";
    }

    double getArea(){
        return (width * height) / 2;
    }

}
