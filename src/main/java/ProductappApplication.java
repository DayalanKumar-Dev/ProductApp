import com.product.app.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductappApplication.class);
		context.registerShutdownHook();

		//SpringApplication.run(ProductappApplication.class, args);
		ProductService ps = context.getBean(ProductService.class);
		ps.printReport();
	}

}
