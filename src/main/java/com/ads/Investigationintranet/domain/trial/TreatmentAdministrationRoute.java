package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;



@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentAdministrationRoute {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administration_route_id")
    
    
    private AdministrationRoute administrationRoute;
    private Boolean administrationRouteEnabled;

    public TreatmentAdministrationRoute(Boolean administrationRouteEnabled) {
        this.administrationRouteEnabled = administrationRouteEnabled;
    }

    public Optional<AdministrationRoute> getAdministrationRoute() {
        return Optional.ofNullable(administrationRoute);
    }

}
