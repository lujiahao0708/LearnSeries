package com.lujiahao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestGroupBy {
    public static void main(String[] args) {
        List<BlogPost> blogPostList = new ArrayList<>();
        blogPostList.add(new BlogPost("post1", "zhuoli", 1, 30));
        blogPostList.add(new BlogPost("post1", "zhuoli", 1, 30));
//        blogPostList.add(new BlogPost("post2", "zhuoli", 1, 40));
//        blogPostList.add(new BlogPost("post3", "zhuoli", 2, 15));
//        blogPostList.add(new BlogPost("post4", "zhuoli", 3, 33));
//        blogPostList.add(new BlogPost("post5", "Alice", 1, 99));
        blogPostList.add(new BlogPost("post6", "Michael", 3, 65));

        Map<Boolean, List<BlogPost>> postsPerTypeAndAuthor = blogPostList.stream()
                .collect(Collectors.groupingBy(post -> post.getType() < 3));

        List<BlogPost> aTrue = postsPerTypeAndAuthor.getOrDefault(Boolean.TRUE, null);

        System.out.println(postsPerTypeAndAuthor);
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class BlogPost {
    private String title;
    private String author;
    private Integer type;
    private Integer likes;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Tuple {
    private String author;
    private Integer type;
}
