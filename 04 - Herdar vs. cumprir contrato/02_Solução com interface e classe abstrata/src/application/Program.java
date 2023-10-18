package application;
import java.util.Locale;

import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;
import model.enums.Color;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		AbstractShape circle = new Circle(Color.BLACK, 2.0);
		AbstractShape rectangle = new Rectangle(Color.WHITE, 3.0, 4.0);

		System.out.println("Circle color: " + circle.getColor());
		System.out.println("Circle area: " + String.format("%.3f", circle.area()));
		
		System.out.println();
		
		System.out.println("Rectangle color: " + rectangle.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", rectangle.area()));
	}
	
}