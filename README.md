# CEP API

CEP API is a Spring Boot application that provides an endpoint to query Brazilian postal codes (CEP) and retrieve address information. It consumes the public [ViaCep API](https://viacep.com.br) to fetch address details.

## Technologies Used
__Java:__ The primary programming language for the project.<br>
__Spring Boot:__ Framework for building the RESTful API.<br>
__Maven:__ Build automation and dependency management tool.<br>
__Git:__ Version control system.

## Versions
__Java:__ 17 <br>
__Spring Boot:__ 3.2.4


## 1. Installations

### A. **Install Java 17**

To run this project, you need to have Java 17 installed on your system following the official Oracle documentation: [JDK Installation Guide](https://docs.oracle.com/en/java/javase/17/install/index.html#GUID-E409CC44-9A8F-4043-82C8-6B95CD939296). 

### B. **Install IntelliJ IDEA Community Edition**

If you don't have IntelliJ IDEA installed, follow these steps to install install IntelliJ IDEA Community Edition from the [official website](https://www.jetbrains.com/help/idea/installation-guide.html).

### C. **Clone the Project**

Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/jalvesm/cepApi.git
```

## 2. **Run the Project**
Open the project in IntelliJ IDEA.

Make sure your Java version is set to 17. Go to File > Project Structure > Project, then set the Project SDK to Java 17.

Build and run the application. In IntelliJ, you can run it by clicking the Run button or executing the following command in the terminal:

```bash
./mvnw spring-boot:run
```

## 3. Test the Endpoint
Once the application is running, onpen your terminal with the command `ctrl + alt + t` test the CEP endpoint using the curl command:

```bash
curl -X GET http://localhost:8080/cep/01001000
```
The expected output should be:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "unidade": "",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "estado": "São Paulo",
  "regiao": "Sudeste",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

🐟 Just keep swimming!
