package ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShopdbDto {

	@NonNull
	private String userName;
	private int birthYear;
	private String addr;
	private String mobile;
	private String prodName;
	private int price;
	private int amount;
}
