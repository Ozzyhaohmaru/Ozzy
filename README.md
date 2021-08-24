## Sample of Product Sale

#### How to get the project source
- Git:
  https://github.com/guiban/ozzy-project.git

## Prerequisites
- JDK 11.0+
- Maven 3.2+


## Running the Services
> When the app is runing execute the following command in terminal:

>  curl -H "Content-Type: application/json" -X POST http://localhost:8080/product  -d '[{"products":[{"qty":1,"descryption":"book","value":12.49,"category":1,"isImport":false},{"qty":1,"descryption":"music CD","value":16.48,"category":4,"isImport":false},{"qty":1,"descryption":"chocolate bar","value":0.85,"category":2,"isImport":false}],"salesTaxes":1.5,"total":29.82},{"products":[{"qty":1,"descryption":"imported box of chocolatess","value":10.5,"category":2,"isImport":true},{"qty":1,"descryption":"imported bottle of perfume","value":54.62,"category":4,"isImport":true}],"salesTaxes":7.63,"total":65.12},{"products":[{"qty":1,"descryption":"imported bottle of perfume","value":32.18,"category":4,"isImport":true},{"qty":1,"descryption":"bottle of perfume","value":20.88,"category":4,"isImport":false},{"qty":1,"descryption":"packet of headache pills","value":9.75,"category":3,"isImport":false},{"qty":1,"descryption":"imported box of chocolates","value":11.81,"category":2,"isImport":true}],"salesTaxes":6.66,"total":74.62}]'


For package generation:
```bash
mvn clean install 
```


