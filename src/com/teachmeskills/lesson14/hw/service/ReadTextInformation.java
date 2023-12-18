package com.teachmeskills.lesson14.hw.service;


import com.teachmeskills.lesson14.hw.logger.Logger;
import com.teachmeskills.lesson14.hw.validation.DocumentNumberValidation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * There is a file with document numbers.
 * The document number is a string consisting of letters and numbers (without service characters).
 * Let this file contain each document number on a new line and no other information on the line, only the document number.
 * A valid document number must be 15 characters long and begin with the sequence docnum (hereinafter any sequence of letters/numbers)
 * or contract (hereinafter any sequence of letters/numbers).
 * Write a program to read information from an input file - the path to the input file must be specified via the console.
 * The program must check document numbers for validity.
 * Valid document numbers docnum should be recorded in one report file.
 * Valid contract numbers should be recorded in another report file.
 * Errors, if they occur, should be recorded in the error_log.txt file Logs should be written to the file execution_log.txt
 * Invalid document numbers should be recorded in another report file,
 * but after the document numbers you should add information about why this document is invalid
 * (incorrect sequence of characters at the beginning/there are service characters in the document name, etc.).
 */
public class ReadTextInformation {
    public static void readFileInformation(String path) {
        Logger.logExecutionInfo(new Date(), "start read document\n");
        List<String> result;
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
             result = DocumentNumberValidation.docNumberValidate(lines);
            for (String s : result) {
                Logger.LogValidDocumentNumber(new Date(),s);
            }
        Logger.logExecutionInfo(new Date(),"success\n");
        } catch (IOException e) {
            Logger.logErrorInfo(new Date(), "error read file", e);
        }
        Logger.logExecutionInfo(new Date(), "end read document\n");
    }

    public static void main(String[] args) {
        readFileInformation("C:\\Users\\Savva\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW-\\doc\\document_number\\document.txt");
    }
}
