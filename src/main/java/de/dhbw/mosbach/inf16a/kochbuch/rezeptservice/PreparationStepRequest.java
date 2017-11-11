package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Thomas Hörner
 * @author Enrico Gresser
 * @author Florian Eder
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PreparationStepRequest {

    @NonNull
    private Integer effort;

    @NonNull
    private String instruction;
}