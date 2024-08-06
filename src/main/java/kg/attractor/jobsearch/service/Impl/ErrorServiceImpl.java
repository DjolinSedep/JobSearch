package kg.attractor.jobsearch.service.Impl;

import kg.attractor.jobsearch.errors.handler.ErrorResponseBody;
import kg.attractor.jobsearch.service.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Slf4j
@Service
public class ErrorServiceImpl implements ErrorService {

    @Override
        public ErrorResponseBody makeResponse(Exception exception) {
            String errorMessage = exception.getMessage();
            return ErrorResponseBody.builder()
                    .error(errorMessage)
                    .reasons(Map.of("errors", List.of(errorMessage)))
                    .build();
        }

        @Override
        public ErrorResponseBody makeResponse(BindingResult bindingResult) {
            Map<String, List<String>> reasons = new HashMap<>();
            bindingResult.getFieldErrors().stream()
                    .filter(e -> e.getDefaultMessage() != null)
                            .forEach(e -> {
                                List<String> errors = new ArrayList<>();
                                errors.add(e.getDefaultMessage());
                                if (!reasons.containsKey(e.getField())) {
                                    reasons.put(e.getField(), new ArrayList<>());
                                } else {
                                    reasons.get(e.getField()).add(e.getDefaultMessage());
                                }
                            });
            return ErrorResponseBody.builder()
                    .error("Validation Error")
                    .reasons(reasons)
                    .build();
        }

}
