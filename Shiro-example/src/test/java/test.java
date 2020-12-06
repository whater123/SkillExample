import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Enter the radius and length of a cylinder:");
        double x=input.nextDouble();
        double y=input.nextDouble();
        System.out.print("the area is:");
        System.out.println(x*x*Math.PI);
        System.out.print("the volume is:");
        System.out.print(x*x*Math.PI*y);
    }
}
