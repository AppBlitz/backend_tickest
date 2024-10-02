package com.example.uniquindio.spring.model.documents;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "databaseSequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

}
