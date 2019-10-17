//package com.caseStudy.eCart.service;
//
//import com.caseStudy.eCart.models.Products;
//import com.caseStudy.eCart.repository.productRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
//import org.springframework.stereotype.Service;
//
//import java.security.interfaces.DSAPublicKey;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
// @Service
//public class ProductsService {
//    private productRepository productRepository;
//    @Autowired
//    public ProductsService(productRepository productRepository)
//    {
//        this.productRepository=productRepository;
//    }
//    public Boolean addItem(Products products)
//    {
//        if(productRepository.findAllByName(products.getName().isPresent()))
//        {
//            return false;
//        }
//        products.setActive(1);
//        productRepository.saveAndFlush(products);
//        return true;
//    }
//    public Boolean clear()
//    {
//        productRepository.deleteAll();
//        return true;
//    }
//    public Set<Products> getSearchedItems(String value)
//    {
//        ArrayList<Products> products=(ArrayList<Products>) productRepository.findAll();
//        Set<Products> result=new HashSet<>();
//        for(int i=0;i<products.size();i++) {
//            if (products.get(i).getName().toLowerCase().contains(value.toLowerCase()))
//            {
//                products.get(i).getCategory().contains(value.toLowerCase());
//        }
//            products.get(i).getDetails().toLowerCase().contains(value.toLowerCase());
//            products.get(i).getSubcategory().toLowerCase().contains(value.toLowerCase());
//            result.add(products.get(i));
//
//        }
//        return result;
//    }
//    public List<Products> getItems()
//    {
//        return productRepository.findAll();
//    }
//    public List<Products> getByCategory(String category)
//    {
//        return productRepository.findAllByCategory(category);
//    }
//    public List<Products> getByCategoryAndPrice(String category, Double lower, Double higher)
//    {
//        return productRepository.findAllByCategoryAndPriceBetween(category,lower,higher);
//    }
//    public Products getById(Long id)
//    {
//        if(productRepository.findById(id).isPresent())
//        {
//            return productRepository.findById(id).get();
//        }
//        return null;
//    }
//    public List<Products> deleteItem(Long id)
//    {
//        productRepository.deleteById(id);
//        return productRepository.findAll();
//    }
//    public List<Products> findAll()
//    {
//        return productRepository.findAll();
//    }
//    public Products editItem(Products newItem,Long id)
//    {
//        Products oldItem=productRepository.findById(id).get();
//        newItem.setProductId(oldItem.getProductId());
//        newItem.setActive(oldItem.getActive());
//        productRepository.saveAndFlush(newItem);
//        return newItem;
//    }
//}
