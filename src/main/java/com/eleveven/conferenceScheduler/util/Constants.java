package com.eleveven.conferenceScheduler.util;

public class Constants {
    public static Long FIRST_HALF_START= 0L;
    public static Long SECONDS_HALF_START= 240L;

    public static Long FIRST_HALF_MAX_LENGTH = 180L;
    public static Long SECOND_HALF_MAX_LENGTH = 240L;

    public static Long NETWORKING_EVENT_EARLIEST_START = 180L;
    public static Long NETWORKING_EVENT_LATEST_END = 480L;
    public static String NETWORKING_EVENT_NAME = "Networking Event";

    public static Long LIGHTNING_LENGTH = 5L;

    public static int STARTING_HOUR = 9;
    public static Long MINUTES_IN_AN_HOUR = 60L;
    public static String ANTE_MERIDIEM = "AM";
    public static String POST_MERIDIEM = "PM";

    public static String MINUTE = " Min";
    public static String LIGHTNING = "Lightning";

    public static String JSON_TEMPLATE="[  \n" +
            "\t{  \n" +
            "\t\t\"name\":\"Meeting1\",  \n" +
            "\t\t\"length\":60  \n" +
            "\t}, \n" +
            "\t{  \n" +
            "\t\t\"name\":\"Meeting2\",  \n" +
            "\t\t\"length\":60  \n" +
            "\t}\n" +
            "]  ";

    public static String ERROR_SUMMARY="Error Occured";
    public static String CLIPBOARD_SUMMARY="INFO";
    public static String CLIPBOARD_MESSAGE="Copied Template To Clipboard";

}
