package com.task.TaskAllocation.Util;

import lombok.NoArgsConstructor;


public class EndPointBundle {
    public static final String BASEURL = "api/v1/";
    public static final String TASK = BASEURL + "task";
    public static final String TEAMMEMBERS = BASEURL + "team-members";
    public static final String update = "/{id}";
    public static  final String delete = "/delete/{id}";
    public static  final String GET = "/get/{id}";


}
