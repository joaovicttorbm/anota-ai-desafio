package com.jm.anota_ai_desafio.services;
import com.jm.anota_ai_desafio.domain.product.Product;
import com.jm.anota_ai_desafio.domain.product.ProductDTO;
import com.jm.anota_ai_desafio.exception.CategoryNotFoundException;
import com.jm.anota_ai_desafio.exception.ProductNotFoundException;
import com.jm.anota_ai_desafio.repositories.CategoryRepository;
import com.jm.anota_ai_desafio.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product insert(ProductDTO productData) {
        // Validar dados do produto
        if (productData.title() == null || productData.title().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (productData.price() == null || productData.price() < 0) {
            throw new IllegalArgumentException("Price must be a non-negative number");
        }
        if (productData.categoryTitle() == null || productData.categoryTitle().isEmpty()) {
            throw new IllegalArgumentException("CategoryId cannot be empty");
        }

        // Verificar se a categoria existe
        if (!categoryRepository.existsByTitle(productData.categoryTitle())) {
            throw new IllegalStateException("Category with title '" + productData.categoryTitle() + "' already not exists");
        }



        // Verificar se um produto com o mesmo título já existe
        if (productRepository.findByTitle(productData.title()).isPresent()) {
            throw new IllegalArgumentException("Product with this title already exists");
        }

        // Criar e salvar o novo produto
        Product newProduct = new Product();
        newProduct.setTitle(productData.title());
        newProduct.setDescription(productData.description());
        newProduct.setOwnerId(productData.ownerId());
        newProduct.setPrice(productData.price());
        newProduct.setCategoryTitle(productData.categoryTitle()); // Definir apenas o ID da categoria
        return productRepository.save(newProduct);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product update(String id, ProductDTO productData) {
        // Encontrar o produto existente
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        // Atualizar campos do produto se os dados forem fornecidos
        if (productData.title() != null && !productData.title().isEmpty()) {
            existingProduct.setTitle(productData.title());
        }

        if (productData.description() != null) {
            existingProduct.setDescription(productData.description());
        }

        if (productData.ownerId() != null && !productData.ownerId().isEmpty()) {
            existingProduct.setOwnerId(productData.ownerId());
        }

        if (productData.price() != null && productData.price() >= 0) {
            existingProduct.setPrice(productData.price());
        }

        if (productData.categoryTitle() != null && !productData.categoryTitle().isEmpty()) {
            // Verifica se a categoria fornecida existe antes de atualizar
            categoryRepository.findById(productData.categoryTitle())
                    .orElseThrow(() -> new CategoryNotFoundException(productData.categoryTitle()));
            existingProduct.setCategoryTitle(productData.categoryTitle());
        }

        // Salvar e retornar o produto atualizado
        return productRepository.save(existingProduct);
    }

    public void delete(String id) {
        Product existingProduct = findById(id);
        productRepository.delete(existingProduct);
    }
}