package au.com.johnc.micrometer.controller;

import au.com.johnc.micrometer.model.Employee;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MicrometerController {

    // Metric Counter to collect the amount of helloWorld calls
    private Counter helloWorldCounter;

    // Metric Counter to collect the amount of getEmployee calls
    private Counter getEmployeeCounter;

    public MicrometerController(final MeterRegistry meterRegistry) {
        helloWorldCounter = meterRegistry.counter("rest_data", "api", "hello_world");
        getEmployeeCounter = meterRegistry.counter("rest_data", "api","get_employee");
    }

    @GetMapping("/hello")
    private String helloWorld() {
        log.info("GET request helloWorld() invoked!");
        helloWorldCounter.increment();
        return "Hello World";
    }

    @GetMapping(value = "/employee", produces = "application/json")
    private Employee getEmployee() {
        log.info("GET request getEmployee() invoked!");
        getEmployeeCounter.increment();
        return new Employee();
    }
}
