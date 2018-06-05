package ua.skillsup.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.skillsup.DAO.repo.impl.ProductDAOImpl;
import ua.skillsup.DAO.repo.impl.UserDAOImpl;
import ua.skillsup.services.DTO.ProductDTO;
import ua.skillsup.services.DTO.UserDTO;
import ua.skillsup.services.ProductService;
import ua.skillsup.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main (String[] args)throws IOException{

        ApplicationContext applicationContext = new GenericXmlApplicationContext("context-main.xml");
        UserService userServices = applicationContext.getBean(UserService.class);
        ProductService productServices = applicationContext.getBean(ProductService.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean result = true;
        while (result) {
            String line = reader.readLine();
            args = line.split(" ");
            switch (args[0]) {
                case "UC":
                    UserDTO userDTO = new UserDTO(args[1], args[2], Integer.parseInt(args[3]));
                    userServices.create(userDTO);
                    break;
                case "UL":
                    UserDAOImpl userDAO = applicationContext.getBean(UserDAOImpl.class);
                    System.out.println(userDAO.findAll());
                    break;
                case "PC":
                    ProductDTO productDTO = new ProductDTO(args[1], args[2], args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]));
                    productServices.create(productDTO);
                    break;
                case "PL":
                    ProductDAOImpl productDAO = applicationContext.getBean(ProductDAOImpl.class);
                    System.out.println(productDAO.getAll());
                    break;
                default:
                    if (line.equals("exit")) {
                        result = false;
                        System.out.println("go out");
                    } else {
                        System.out.println("НЕПОНЯТНО");
                    }

            }
        }
    }
}