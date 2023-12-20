package com.example.stormmediamanagement.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "comments")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID commentId;

    @ManyToOne
    @JoinColumn(name = "storm_id")
    private Storm storm;

    @ManyToOne
    private User user;

    private String comment_text;

    // getters and setters
}