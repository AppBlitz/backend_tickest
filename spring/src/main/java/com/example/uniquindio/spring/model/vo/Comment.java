package com.example.uniquindio.spring.model.vo;

import com.example.uniquindio.spring.model.documents.User;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Comment {

    @NonNull
    private User user;

    @NonNull
    private LocalDateTime localData;

    @NonNull
    private String comment;

}
