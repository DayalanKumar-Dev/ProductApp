package com.product.app.service;

import com.product.app.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void printReport(){
        System.out.println("inside print report============");
         productDao.employeeListDetails().forEach(System.out::println);
    }
}
