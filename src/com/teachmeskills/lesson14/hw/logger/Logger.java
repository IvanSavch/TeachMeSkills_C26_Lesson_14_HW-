package com.teachmeskills.lesson14.hw.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger {
    private static final String INVALID_DOCUMENT_FILE = "C:\\Users\\Savva\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW-\\doc\\invalid_document_number\\invalid_document_number";
    private static final String VALID_DOCUMENT_FILE = "C:\\Users\\Savva\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW-\\doc\\valid_document_number\\valid_documents_number.txt";
    private static final String ERROR_FILE = "C:\\Users\\Savva\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW-\\error_log\\error_log.txt";
    private static final String EXECUTION_LOG = "C:\\Users\\Savva\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW-\\execution_log\\execution_log.txt";

    public static void logExecutionInfo(Date date, String message) {
        String mes = date + "->" + message;
        try {
            Files.write(Paths.get(EXECUTION_LOG), mes.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    public static void logErrorInfo(Date date, String message, Exception e) {
        StackTraceElement[] elements = e.getStackTrace();
        StringBuilder builder = new StringBuilder();
        builder.append(date + "->" + message);
        builder.append("\n");
        for (StackTraceElement element : elements) {
            builder.append(element.toString());
            builder.append("\n");
        }
        try {
            Files.write(Paths.get(ERROR_FILE), builder.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
        }
    }

    public static void LogInvalidDocumentNumber(Date date, String message, String documentNumber) {
        String mes = documentNumber + "->" + message + "->" + date + "\n";
        try {
            Files.write(Paths.get(INVALID_DOCUMENT_FILE), mes.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
    }
    public static void LogValidDocumentNumber(Date date, String documentNumber) {
        String mes = documentNumber + "->" + date + "\n";
        try {
            Files.write(Paths.get(VALID_DOCUMENT_FILE), mes.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
    }

}
