package com.kdt.clone.domain.order.dto;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String nickName;
    private int age;
    private String address;
    private String description;
}
