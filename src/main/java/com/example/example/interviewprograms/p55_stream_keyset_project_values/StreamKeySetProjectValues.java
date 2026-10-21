package com.example.example.interviewprograms.p55_stream_keyset_project_values;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Additional example: Stream Keys, Then Look Up Their Values. Standard Java Map only. */
public class StreamKeySetProjectValues {
    public static void main(String[] args) {
        Map<Integer, String> employeeNameById = new LinkedHashMap<>();
        employeeNameById.put(1001, "Asha");
        employeeNameById.put(1002, "Ravi");
        employeeNameById.put(1003, "Mina");
        employeeNameById.put(1004, "Dev");

        List<String> names = employeeNameById.keySet().stream()
                .filter(id -> id >= 1003)
                .sorted()
                .map(employeeNameById::get)
                .collect(Collectors.toList());

        System.out.println("Employees with ID 1003 or higher: " + names);
    }
}
