package com.retail.shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Vivek_singh
 *
 * @param <T>
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GenericResponseModel<T> {

	private T responseBody;
}
