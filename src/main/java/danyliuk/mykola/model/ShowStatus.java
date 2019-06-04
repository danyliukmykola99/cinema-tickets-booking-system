package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mykola Danyliuk
 */
@AllArgsConstructor
@Getter
public enum ShowStatus {
    SCHEDULED("Заплановано"),
    CANCELED("Відмінено"),
    STARTED("Стартував"),
    FINISHED("Завершено");

    private String name;
}
