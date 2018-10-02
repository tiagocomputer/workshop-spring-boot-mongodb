package com.tiagopereira.workshopmongo.config;

import com.tiagopereira.workshopmongo.dto.AuthorDTO;
import com.tiagopereira.workshopmongo.dto.CommentDTO;
import com.tiagopereira.workshopmongo.entity.Post;
import com.tiagopereira.workshopmongo.entity.User;
import com.tiagopereira.workshopmongo.repository.PostRepository;
import com.tiagopereira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //vai instanciar a data com a data do Brasil
        sdf.setTimeZone(TimeZone.getTimeZone("BRT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("01/10/2018"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("02/10/2018"), "Bom dia!", "Acordei feliz hoje! :)", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("02/10/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("01/10/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("03/10/2018"), new AuthorDTO(alex));

        post1.getCommentDTOS().addAll(Arrays.asList(c1, c2));
        post2.getCommentDTOS().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
