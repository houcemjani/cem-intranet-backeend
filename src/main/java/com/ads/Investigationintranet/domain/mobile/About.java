package com.ads.Investigationintranet.domain.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ig_about")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "text", columnDefinition = "VARCHAR(10000)")
    @JsonProperty
    private String text;

}
