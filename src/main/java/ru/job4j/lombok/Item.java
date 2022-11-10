package ru.job4j.lombok;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Item {
    @Getter
    @Setter
    @NonNull
    private int id;
    @EqualsAndHashCode.Include
    private String name;
}
