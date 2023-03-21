package com.ads.Investigationintranet.domain.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "igEmail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_contacts_emails")
public class Email  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactSetHhhid")
    @JsonIgnore
    private ContactSet contactSet;

    @Column(name = "value")
    private String value;

    @Column(name = "type")
    private String type;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "position")
    private int position;

    @Column(name = "comment")
    private String comment;

}
