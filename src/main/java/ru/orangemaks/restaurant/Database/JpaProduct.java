package ru.orangemaks.restaurant.Database;

import ru.orangemaks.restaurant.Domain.Admin.Products.Admin_ProductDataAccess;
import ru.orangemaks.restaurant.Domain.Order.MenuDataAccess;
import ru.orangemaks.restaurant.Entities.Product;
import ru.orangemaks.restaurant.Repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

public class JpaProduct implements Admin_ProductDataAccess, MenuDataAccess {
    private final ProductRepository productRepository;

    @PersistenceContext
    private EntityManager em;

    public JpaProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> filter(Long id, String name, String category) {
        if (id==null && name.equals("") && category.equals("")){
            return getAll();
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        Predicate predicateForId = cb.equal(productRoot.get("id"), id);
        Predicate predicateForName = cb.like(productRoot.get("name"), name);
        Predicate predicateForCategory = cb.like(productRoot.get("category"),category);

        Predicate finalePredicate = null;

        if(id!=null){
            finalePredicate = cb.and(predicateForId);
        }
        if(!name.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForName);
            else finalePredicate = predicateForName;
        }
        if(!category.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForCategory);
            else finalePredicate = predicateForCategory;
        }

        criteriaQuery.where(finalePredicate);
        List<Product> products = em.createQuery(criteriaQuery).getResultList();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        product.setImg(parse(product.getImg()));
        productRepository.save(product);
    }

    @Override
    public Product deleteById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.deleteById(id);
            return product;
        }
        else return null;
    }

    //https://drive.google.com/file/d/13dCjpWflutbu6-9kRlxFd2BJMQAqAE1D/view?usp=sharing
    //  ||
    // \||/
    //  \/
    //https://drive.google.com/uc?export=view&id=13dCjpWflutbu6-9kRlxFd2BJMQAqAE1D
    public String parse(String url){
        if(url.charAt(("https://drive.google.com/").length()) == 'u') return url;
        return "https://drive.google.com/uc?export=view&id="+url.substring(("https://drive.google.com/file/d/").length(),url.length()-"/view?usp=sharing".length());
    }
}
