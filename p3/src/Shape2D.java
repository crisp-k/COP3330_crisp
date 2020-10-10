abstract class Shape2D extends Shape{

    protected double width;
    protected double height;

    public Shape2D(double width) {
        this.width = width;
    }

    public Shape2D(double width, double height){
        this.width = width;
        this.height = height;
    }
}
