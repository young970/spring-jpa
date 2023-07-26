package com.kdt.clone.domain.multikey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parent2 {
    @EmbeddedId
    private ParentId2 id;
}
