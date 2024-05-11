package com.task.TaskAllocation.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum RestApiResponseStatus {

CREATED(21000),
VALIDATION_FAILURE(40000),
OK(20000),
NOT_UPDATED(42200),
RETRIEVED(23000),
DELETED(20400),
NOT_DELETED(40000),
NOT_FOUND(40400),
NOT_CREATED(42200),
NAME_EXISTS(40900),
BAD_REQUEST(40000), INTERNAL_SERVER_ERROR(50000);

    private final Integer StatusCode;
}