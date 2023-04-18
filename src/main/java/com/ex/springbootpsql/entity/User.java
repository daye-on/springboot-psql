package com.ex.springbootpsql.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_user")
@ToString
public class User {

    @Id
    @Column(name="user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name="user_id")
    private String userId;
}
