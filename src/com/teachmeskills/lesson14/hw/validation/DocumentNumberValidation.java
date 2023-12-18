package com.teachmeskills.lesson14.hw.validation;


import com.teachmeskills.lesson14.hw.logger.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentNumberValidation {
    public static List<String> docNumberValidate(List<String> lines) throws IOException {
        List<String> result = new ArrayList<>();
        for (String s : lines) {
            if (checkDoc(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static boolean checkDoc(String s) {
        boolean isCheck = false;

        if (s.startsWith("docnum") || s.startsWith("contract")) {

            if (s.length() > 15) {
                Logger.LogInvalidDocumentNumber(new Date(), "wrong length number\n", s);
                return isCheck;
            }
            if (s.matches("\\W{1,}")) {
                Logger.LogInvalidDocumentNumber(new Date(), "Unacceptable symbols in the title document number\n", s);
                return isCheck;
            }
        } else {
            Logger.LogInvalidDocumentNumber(new Date(), "wrong name document", s);
            return isCheck;
        }
        isCheck = true;
        return isCheck;
    }

}

