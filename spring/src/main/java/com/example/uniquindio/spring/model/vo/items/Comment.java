package com.example.uniquindio.spring.model.vo.items;

import java.time.LocalDateTime;

import com.example.uniquindio.spring.model.documents.User;
import lombok.*;

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
