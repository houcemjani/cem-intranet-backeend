package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.auth.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "content")
    @JsonProperty
    private String content;

    @Column(name = "checked")
    @JsonProperty
    private boolean checked;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @JsonProperty
    private Calendar date;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerHhhId")
    
    private User owner;

}
