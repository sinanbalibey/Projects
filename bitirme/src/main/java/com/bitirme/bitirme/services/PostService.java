package com.bitirme.bitirme.services;


import com.bitirme.bitirme.entities.Post;
import com.bitirme.bitirme.entities.User;
import com.bitirme.bitirme.repos.PostRepository;
import com.bitirme.bitirme.requests.PostCreateRequest;
import com.bitirme.bitirme.requests.PostUpdateRequest;
import com.bitirme.bitirme.responses.LikeResponse;
import com.bitirme.bitirme.responses.PostResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {


    private PostRepository postRepository;
    private UserService userService;
    private LikeService likeService;

    @Autowired
    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;

    }


    @Autowired
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }

    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()) {
            list = postRepository.findByUserId(userId.get());
        }else
            list = postRepository.findAll();
        return list.stream().map(p -> {
            List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
            return new PostResponse(p, likes);}).collect(Collectors.toList());
    }


    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public PostResponse getOnePostByIdWithLikes(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(postId));
        return new PostResponse(post, likes);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user=userService.getOneUserById(newPostRequest.getUserId());
        if(user==null)
            return null;


        Post toSave=new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);

        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {

        Optional<Post> post =postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate=post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);

            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
