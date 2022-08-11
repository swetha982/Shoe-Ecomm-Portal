package com.example.service.Impl;

import com.example.bean.Category;
import com.example.bean.Product;
import com.example.dao.ProductDao;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao pd;

    @Autowired
    private CategoryService cs;

    @Override
    public String saveProduct(Product p, int id, String name) {

        System.out.println("Product:"+p);
        p.setCategory(cs.getCat(name));
        Product pro= pd.saveAndFlush(p);
        if(pro.getName() != null)
            return "Product Saved";
        else
            return "Product Not Saved";
    }

    @Override
    public List<Product> showProducts() {
        System.out.println("In Show all products");
        List<Product> pList=pd.showAllProd();
        System.out.println(pList);
        return pList;
    }

    @Override
    public Product getProduct(int id) {
        return pd.getById(id);
    }
}
