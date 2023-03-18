package com.levkorolkov.application.facade;

import com.levkorolkov.application.dto.PostDTO;
import com.levkorolkov.application.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class PostFacade {
    @Transactional
    public PostDTO postToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setId(post.getId());
        postDTO.setCaption(post.getCaption());
        postDTO.setLikes(post.getLikes());
        postDTO.setUsersLiked(post.getLikedUsers());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());

        return postDTO;
    }

}
