package com.product.app.service;

import com.product.app.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public void printReport(){
         productDao.employeeListDetails().forEach(System.out::println);
    }
}
