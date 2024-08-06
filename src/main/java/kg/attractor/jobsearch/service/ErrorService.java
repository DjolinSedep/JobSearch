package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.errors.handler.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {

    ErrorResponseBody makeResponse(Exception exception);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
