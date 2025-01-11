package com.model.library;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "book_removed")
public class BookRemoved {
    @Id
    @Column(name = "id", length = 50)
    private String id;
    @Column(name = "removed_by", length = 20)
    private String removedBy;
    @Column(name = "removed_date", length = 20)
    private String removedDate;
    @Type(type = "text")
    @Column(name = "data")
    private String data;
}
