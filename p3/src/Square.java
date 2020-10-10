public class Square extends Shape2D{

    public Square(double width){
        super(width);
    }

    String getName(){
        return "square";
    }

    double getArea(){
        return width * width;
    }
}
