package com.example.feednoticias.service;

import com.example.feednoticias.model.Noticia;
import com.example.feednoticias.repository.FeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedService {
    FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository){
        this.feedRepository = feedRepository;

    }

    public void insert(Noticia noticia){
        feedRepository.save(noticia);
    }
    public void update(Noticia noticia){
        feedRepository.saveAndFlush(noticia);
    }
    public Noticia findById(Long id){
        Optional<Noticia> noticia = feedRepository.findById(id);
        if(noticia.isPresent()){
            return noticia.get();
        }else{
            return null;
        }
    }
    public void deleteById(Long id){
        feedRepository.deleteById(id);
    }
    public List<Noticia> findAll(){
        return feedRepository.findAll();
    }
}
