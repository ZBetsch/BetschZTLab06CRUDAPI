package com.elkabani.firstspringboot.controllers;


import com.elkabani.firstspringboot.dtos.ProductDto;
import com.elkabani.firstspringboot.entities.Product;
import com.elkabani.firstspringboot.mappers.ProductMapper;
import com.elkabani.firstspringboot.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(name = "categoryId", required = false) Integer categoryId) {
        var products = (categoryId == null)
                ? productRepository.findAll()
                : productRepository.findByCategoryId(categoryId);

        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        Product entity = productMapper.toEntity(dto);
        entity = productRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDto(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id,
                                             @RequestBody ProductDto dto) {
        var existing = productRepository.findById(id).orElse(null);
        if (existing == null) return ResponseEntity.notFound().build();
        productMapper.update(dto, existing);
        var saved = productRepository.save(existing);
        return ResponseEntity.ok(productMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        var existing = productRepository.findById(id).orElse(null);
        if (existing == null) return ResponseEntity.notFound().build();
        productRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}
