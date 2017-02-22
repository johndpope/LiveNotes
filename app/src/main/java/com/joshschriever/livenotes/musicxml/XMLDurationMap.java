package com.joshschriever.livenotes.musicxml;

//TODO - rename this to XMLDurationUtil
//TODO - move everything that has anything to do with durations into here
//TODO - parser will figure out the xml duration, and set that on the note, instead of setting the duration in millis

//TODO - a method to get base duration - basically duration minus extraTiedDuration

//TODO - default precision needs to be lower
public class XMLDurationMap {

    private static final int MAX_BEAT_TYPE = 8;

    public static String noteStringForDuration(int duration, int beatType) {
        return noteString(duration * MAX_BEAT_TYPE / beatType);
    }

    public static boolean noteDottedForDuration(int duration, int beatType) {
        return noteDotted(duration * MAX_BEAT_TYPE / beatType);
    }

    public static int noteExtraTiedDurationForDuration(int duration, int beatType) {
        return noteExtraTiedDuration(duration * MAX_BEAT_TYPE / beatType);
    }

    private static String noteString(int duration) {
        if (duration < 1) {
            return "64th";
        } else if (duration == 1) {
            return "32nd";
        } else if (duration <= 3) {
            return "16th";
        } else if (duration <= 7) {
            return "eighth";
        } else if (duration <= 15) {
            return "quarter";
        } else if (duration <= 31) {
            return "half";
        } else {
            return "whole";
        }
    }

    private static boolean noteDotted(int duration) {
        return (duration == 3) || (duration == 6) || (duration == 7)
                || (duration >= 12 && duration <= 15) || (duration >= 24 && duration <= 31);
    }

    private static int noteExtraTiedDuration(int duration) {
        if (duration > 32) {
            return duration - 32;
        }

        switch (duration) {
            case 5:
            case 7:
            case 9:
            case 13:
            case 17:
            case 25:
                return 1;
            case 10:
            case 14:
            case 18:
            case 26:
                return 2;
            case 11:
            case 15:
            case 19:
            case 27:
                return 3;
            case 20:
            case 28:
                return 4;
            case 21:
            case 29:
                return 5;
            case 22:
            case 30:
                return 6;
            case 23:
            case 31:
                return 7;
            default:
                return 0;
        }
    }

}
