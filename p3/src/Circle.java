public class Circle extends Shape2D{

    public Circle(double width){
        super(width);
    }

    String getName(){
        return "circle";
    }

    double getArea(){
        return Math.PI * Math.pow(width, 2);
    }
}
