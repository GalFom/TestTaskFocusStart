public class SImpleRectangle implements Rectangle{
    private double width; //поле - переменные длина ширина
    private double height;

    public SImpleRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void print() {
        System.out.println("Recrangle[width=" + width + ", height=" + height + "]");
    }
}
