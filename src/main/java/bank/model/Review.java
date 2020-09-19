package bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
		public Review() {
			
			// TODO Auto-generated constructor stub
		}
		public Review(int id, @NotBlank String service, String comments, Double rating) {
			super();
			this.id = id;
			this.service = service;
			this.comments = comments;
			this.rating = rating;
		}
		@Override
		public String toString() {
			return "Review [id=" + id + ", service=" + service + ", comments=" + comments + ", rating=" + rating + "]";
		}
	    
		
	    
}
