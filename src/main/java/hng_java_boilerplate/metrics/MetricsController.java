package hng_java_boilerplate.metrics;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class MetricsController {

    private final PrometheusMeterRegistry prometheusMeterRegistry;

     @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getMetrics() {
        String metrics = prometheusMeterRegistry.scrape();
        return ResponseEntity.ok(metrics);
    }

}