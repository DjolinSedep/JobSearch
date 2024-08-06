package kg.attractor.jobsearch.errors.handler;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Builder
@Data
public class ErrorResponseBody {
    private Map<String, List<String>> reasons;
    private String error;
}
