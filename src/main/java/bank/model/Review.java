package bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Review {

		@Id
	    @GeneratedValue
	    private int id;
		@NotBlank
	    private String service;
	    private String comments;
	    private Double rating;
	    
	    @OneToOne
	    private Token token;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public Double getRating() {
			return rating;
		}

		public void setRating(Double rating) {
			this.rating = rating;
		}

		public Token getToken() {
			return token;
		}

		public void setToken(Token token) {
			this.token = token;
		}

		public Review() {
		}

		public Review(int id, @NotBlank String service, String comments, Double rating, Token token) {
			super();
			this.id = id;
			this.service = service;
			this.comments = comments;
			this.rating = rating;
			this.token = token;
		}
	    
		
		
	    
}
