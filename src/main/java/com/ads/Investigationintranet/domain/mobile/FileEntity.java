package com.ads.Investigationintranet.domain.mobile;

import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ig_trial_file_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {
    @Column
    public String name;
    @Column
    public String url;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;
    @Enumerated(EnumType.STRING)
    private FileTypeEnum type;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trialHhhId", updatable = false)
    private Trial trial;
}
