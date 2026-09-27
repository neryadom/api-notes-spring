package org.neryadom.notes.utils;

public class ParameterUtils {

    public static boolean isValidCaseSensitivityParam(String apiRequestParam) {
        return apiRequestParam.equalsIgnoreCase("true") || apiRequestParam.equalsIgnoreCase("false");
    }

    public static boolean convertCaseSensitiveParamToBoolean(String apiRequestParam) {
        return (apiRequestParam.equalsIgnoreCase("true"));
    }
}
