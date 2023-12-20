package com.example.stormmediamanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long attachment_id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private String attachment_type;
    private String attachment_path;
}
