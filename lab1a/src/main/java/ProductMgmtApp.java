import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.Product;

public class ProductMgmtApp {

    public static void main(String[] args) throws Exception {
        // Create product instances (using Date(String) is deprecated; consider using a proper date parser)
        Product productA = new Product(3128874119L, "Banana", new Date("2023/01/24"), 124, 0.55);
        Product productB = new Product(2927458265L, "Apple", new Date("2022/12/09"), 18, 1.09);
        Product productC = new Product(9189927460L, "Carrot", new Date("2023/03/31"), 89, 2.99);
        Product[] products = new Product[]{productA, productB, productC};

        new ProductMgmtApp().printProducts(products);
    }

    public void printProducts(Product[] products) throws Exception {
        // Define a date format (e.g., "yyyy-MM-dd")
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // JSON Conversion using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(dateFormat);
        String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println("JSON Format:");
        System.out.println(jsonOutput);

        // XML Conversion using Jackson XML module
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDateFormat(dateFormat);
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println("\nXML Format:");
        System.out.println(xmlOutput);

        // CSV Conversion using Jackson CSV module
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.setDateFormat(dateFormat);
        CsvSchema schema = csvMapper.schemaFor(Product.class).withHeader();
        String csvOutput = csvMapper.writer(schema).writeValueAsString(products);
        System.out.println("\nCSV Format:");
        System.out.println(csvOutput);
    }
}
