package br.com.diolabs.lojaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NutritionsDTO {

    private Integer id;

    private Integer carbohydrates;

    private Integer protein;

    private Double fat;

    private Integer calories;

    private Double sugar;
}
