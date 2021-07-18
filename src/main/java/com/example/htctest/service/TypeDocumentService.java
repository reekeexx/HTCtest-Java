package com.example.htctest.service;

import com.example.htctest.entity.TypeDocument;
import com.example.htctest.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeDocumentService {

    private final TypeDocumentRepository typeDocumentRepository;

    @Autowired
    public TypeDocumentService(TypeDocumentRepository typeDocumentRepository) {
        this.typeDocumentRepository = typeDocumentRepository;
    }

    public TypeDocument findById(Long id) {
        return typeDocumentRepository.getById(id);
    }
}
