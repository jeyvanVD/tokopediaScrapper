# Tokopedia Web Scraper
This is a web scraper prototype for e-commerce websites made using Java, including the Java package JSOUP for the scraping and extraction process and maven for dependency and package handling processes.
This web scraper pulls information such as :
* The name of the products,
* The image link for the products,
* The price of the products,
* The seller and the location of the products.

To run this code, maven is required for the compilation and dependency handling.
The steps include:
* clone this repository
* Run the command ```mvn package``` to compile the code
* Run the commabd ```java -jar target\tokopedia_scraper-1.0-SNAPSHOT.jar``` to run the code.

To view the file used to create the web scraper, go to this directory:
```src/main/java/com/tokopedia/scraper/App.java```
The configuration and dependency settings for Maven could be found ehre:
```pom.xml```
