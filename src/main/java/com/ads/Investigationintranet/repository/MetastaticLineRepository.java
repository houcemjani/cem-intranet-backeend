package com.ads.Investigationintranet.repository;
import com.ads.Investigationintranet.dto.MetastaticLineDto;
import com.ads.Investigationintranet.entity.MetastaticLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MetastaticLineRepository extends JpaRepository<MetastaticLine,Long> {

  @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.MetastaticLineDto(m) FROM MetastaticLine m ")
  List<MetastaticLineDto> findMetastaticLines();
}
