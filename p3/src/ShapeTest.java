import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    public void testSquareName(){
        Shape shape = new Square(10);
        assertEquals("square", shape.getName());
    }

    @Test
    public void testSquareArea(){
        Shape2D shape = new Square(10);
        assertEquals(100, shape.getArea());
    }

    @Test
    public void testSquareArea2(){
        Shape2D shape = new Square(0.5);
        assertEquals(0.25, shape.getArea());
    }

    @Test
    public void testTriangleName(){
        Shape shape = new Triangle(100, 100);
        assertEquals("triangle", shape.getName());
    }

    @Test
    public void testTriangleArea(){
        Shape2D shape = new Triangle(10, 10);
        assertEquals(50, shape.getArea());
    }

    @Test
    public void testTriangleArea2(){
        Shape2D shape = new Triangle(0.5, 0.25);
        assertEquals(0.063, shape.getArea(), 0.001);
    }
}
