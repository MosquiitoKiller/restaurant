package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.admin.products.Admin_ProductDataAccess;
import ru.orangemaks.restaurant.domain.order.MenuDataAccess;
import ru.orangemaks.restaurant.entities.Product;
import ru.orangemaks.restaurant.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

/**
 * Class data access to Product
 */
public class JpaProduct implements Admin_ProductDataAccess, MenuDataAccess {
    /**
     * data access
     */
    private final ProductRepository productRepository;

    /**
     * default EntityManager
     */
    @PersistenceContext
    private EntityManager em;

    public JpaProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * get all products
     * @return list of all products
     */
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * filter products by parametres
     * @param id id product
     * @param name name of product
     * @param category category of product
     * @return filtered products
     */
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

    /**
     * find product by id
     * @param id id product
     * @return product by id
     */
    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * save new product or reload existing product
     * @param product product for save
     */
    @Override
    public void save(Product product) {
        product.setImg(parse(product.getImg()));
        productRepository.save(product);
    }

    /**
     * delete product by if
     * @param id id product
     * @return deleted product
     */
    @Override
    public Product deleteById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.deleteById(id);
            return product;
        }
        else return null;
    }

    /**
     * https://drive.google.com/file/d/13dCjpWflutbu6-9kRlxFd2BJMQAqAE1D/view?usp=sharing
     *           ||
     *          \||/
     *           \/
     * https://drive.google.com/uc?export=view&id=13dCjpWflutbu6-9kRlxFd2BJMQAqAE1D
     * @param url url for parse
     * @return parsed url for google drive
     */

    public String parse(String url){
        if(url.charAt(("https://drive.google.com/").length()) == 'u') return url;
        return "https://drive.google.com/uc?export=view&id="+url.substring(("https://drive.google.com/file/d/").length(),url.length()-"/view?usp=sharing".length());
    }
}
