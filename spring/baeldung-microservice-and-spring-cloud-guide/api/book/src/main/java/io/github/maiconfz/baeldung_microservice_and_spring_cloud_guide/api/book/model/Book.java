package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.model;

import java.util.UUID;

import com.google.common.collect.ComparisonChain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class Book implements Comparable<Book> {
    @EqualsAndHashCode.Include
    private UUID id;
    private String title;
    private String author;

    @Override
    public int compareTo(Book o) {
        if (o == null) {
            return 1;
        }

        return ComparisonChain.start().compare(this.id, o.id).result();
    }

}
