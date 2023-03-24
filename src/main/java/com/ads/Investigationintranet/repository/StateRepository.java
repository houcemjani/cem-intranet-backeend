package com.ads.Investigationintranet.repository;


import com.ads.Investigationintranet.dto.StateDto;
import com.ads.Investigationintranet.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StateRepository extends JpaRepository<State,Long> {

  @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.StateDto(State) FROM com.ads.Investigationintranet.entity.State state where state.hhhId IN (5, 6, 7)")
  List<StateDto> findStates();
}
