package com.example.feednoticias.repository;

import com.example.feednoticias.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Noticia, Long> {

}
