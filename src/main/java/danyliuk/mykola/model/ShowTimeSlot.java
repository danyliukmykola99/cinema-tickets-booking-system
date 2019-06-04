package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mykola Danyliuk
 */
@AllArgsConstructor
@Getter
public enum ShowTimeSlot {
    FROM_9_TO_11("9:00"),
    FROM_11_TO_13("11:00"),
    FROM_13_TO_16("13:00"),
    FROM_16_TO_19("16:00"),
    FROM_19_TO_22("22:00");

    private String startTime;

}