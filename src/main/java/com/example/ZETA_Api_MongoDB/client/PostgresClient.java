package com.example.ZETA_Api_MongoDB.client;

import com.example.ZETA_Api_MongoDB.dto.ProgramResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postgresApi", url = "${API_POSTGRESQL_URL}/api")
public interface PostgresClient {

    @GetMapping("/programs/find-id/{id}")
    ProgramResponseDTO findProgramById(@PathVariable("id") Integer id);

}
