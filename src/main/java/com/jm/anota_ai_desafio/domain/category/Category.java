package com.jm.anota_ai_desafio.domain.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category") // coleção no MongoDB em que o documento será armazenado
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    private String ownerId;

}
