package ss16_IO_stream.readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/ss16_IO_stream/readfile/countries.csv";
        List<Country> countries = readCountries(fileName);
        System.out.printf("| %-3s | %-10s | %-20s |%n", "ID", "CODE", "NAME");
        System.out.println("------------------------------------------");
        countries.forEach(System.out::println);
    }
    public static List<Country> readCountries(String fileName) {
        List<Country> list = new ArrayList<>();
        try(FileReader fileReader = new FileReader("src/ss16_IO_stream/readfile/countries.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line;
            String[] data;
            Country country;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                country = new Country(Integer.parseInt(data[0]), data[1].trim().replace("\"", ""), data[2].trim().replace("\"", ""));
                list.add(country);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return list;
    }
}
