package com.example.uniquindio.spring.model.vo;

import com.example.uniquindio.spring.model.documents.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Comment {

    @NonNull
    private String iduser;

    @NonNull
    private LocalDateTime localData;

    @NonNull
    private String comment;

    @NonNull
    private List<Comment> answers;

}
