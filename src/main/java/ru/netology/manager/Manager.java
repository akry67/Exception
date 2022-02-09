package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;


public class Manager {
    private Product[] items = new Product[0];

    public void add(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
            if (findById(id) == null) throw new NotFoundException("Element with id: " + id + " not found");
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }

//    public Product[] searchBy(String text) {
//        Product[] result = new Product[0];
//        for (Product product : repository.findAll()) {
//            if (matches(product, text)) {
//                Product[] tmp = new Product[result.length + 1];
//                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
//                System.arraycopy(result, 0, tmp, 0, result.length);
//                tmp[tmp.length - 1] = product;
//                result = tmp;
//            }
//        }
//        return result;

