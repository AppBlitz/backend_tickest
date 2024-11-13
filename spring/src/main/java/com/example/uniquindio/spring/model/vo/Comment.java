package com.example.uniquindio.spring.model.vo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Null
    private List<Comment> answers;

}
