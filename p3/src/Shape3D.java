abstract class Shape3D extends Shape{

    protected double length;
    protected double width;
    protected double height;

    public Shape3D(double width){
        this.width = width;
    }

    public Shape3D(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    abstract double getVolume();

}
