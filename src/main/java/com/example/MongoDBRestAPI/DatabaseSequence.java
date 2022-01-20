package com.example.MongoDBRestAPI;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "database_sequences")
@Component
@Data
@NoArgsConstructor
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;
}
