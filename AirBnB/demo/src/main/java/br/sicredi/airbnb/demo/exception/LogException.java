package br.sicredi.airbnb.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class LogException {

    public static ResponseEntity<String> error(HttpStatus status, String e) {
        log.error("Status: " + status + " -- " + "Exception : " + e );
        return ResponseEntity.status(status).body(e);
        //return new ResponseEntity<>(e, status);
    }
}
