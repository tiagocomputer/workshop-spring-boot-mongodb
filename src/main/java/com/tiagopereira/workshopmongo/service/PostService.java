package com.tiagopereira.workshopmongo.service;

import com.tiagopereira.workshopmongo.entity.Post;
import com.tiagopereira.workshopmongo.repository.PostRepository;
import com.tiagopereira.workshopmongo.service.exception.ObjectNotFoundExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundExcepion("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }
}
