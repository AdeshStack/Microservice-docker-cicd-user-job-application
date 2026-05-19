package com.smarthireai.smarthireai.service.AIservice.EmbededService;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbeddingService {

    // embedding model use to convert string into vector
    private final EmbeddingModel embeddingModel;

    public EmbeddingService(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    public float[] createEmbedding(String text) {

        EmbeddingResponse response =
                embeddingModel.embedForResponse(List.of(text));

       return response.getResult().getOutput();
    }
}