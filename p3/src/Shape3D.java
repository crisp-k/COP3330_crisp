abstract class Shape3D extends Shape{

    protected double length;
    protected double width;
    protected double height;

    public Shape3D(double width){
        this.width = width;
    }

    public Shape3D(double width, double height, double length){
        this.width = width;
        this.height = height;
        this.length = length;
    }

    abstract double getVolume();

}
