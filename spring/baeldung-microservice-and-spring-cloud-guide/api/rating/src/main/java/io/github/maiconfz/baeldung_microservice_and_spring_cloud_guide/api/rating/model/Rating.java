package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.model;

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
public class Rating implements Comparable<Rating> {
    @EqualsAndHashCode.Include
    private UUID id;
    private UUID bookId;
    private int stars;

    @Override
    public int compareTo(Rating o) {
        if (o == null) {
            return 1;
        }

        return ComparisonChain.start().compare(this.id, o.id).result();
    }

}
