package com.tokopedia.scraper;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter; 


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App 
{
    public static void main( String[] args )
    {
        try {
            // First we create an output file for the desired output
            File output = new File("Results.txt");
            if (output.createNewFile()) {
              System.out.println("File created: " + output.getName());
            } else {
              System.out.println("File already exists.");
            }
            // We initiate a new FileWriter object for us to write into our output file
            FileWriter writer = new FileWriter("Results.txt");
            
            // Here we use JSoup to fetch the website and store it into a Document object
            Document doc = Jsoup.connect("https://www.tokopedia.com/search?navsource=home&sc=24&st=product&q=mobile%20phones").get();
            System.out.println("Connection Succesful");

            Elements products = doc.getElementsByClass("css-jza1fo");
           
            for (Element product : products) {
                // Extract the product name
                String productName = product.getElementsByClass("css-1f4mp12").text();
                
                // Extract the product image url
                String productUrl = product.getElementsByClass("success fade").text();

                // Extract the product price
                String productPrice = product.getElementsByClass("css-rhd610").text();

                // Extract the location and seller of the product
                String productLocation = product.getElementsByClass("css-qjiozs").text();

                // Format and print the information to the console
                writer.write("Product name : " + productName);
                writer.write("Product image url : " + productUrl);
                writer.write("Product price : " + productPrice);
                writer.write("Product location and seller : " + productLocation);
                writer.write("\n");
            }
            writer.close();
        }    
     
        // In case of any IO errors, we want the messages written to the console
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
