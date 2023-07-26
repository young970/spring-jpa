package com.kdt.clone.domain.multikey;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParentId2 implements Serializable {
    private String id1;
    private String id2;
}
