package com.jm.anota_ai_desafio.domain.product;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product") // coleção no MongoDB em que o documento será armazenado
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    private String ownerId;

    @NotNull
    @Min(value = 0, message = "Price must be positive")
    private Integer price;

    private String categoryTitle;
}
